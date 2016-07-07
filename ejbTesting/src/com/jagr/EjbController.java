package com.jagr;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jagr.ejb.RemoteServiceBean;
import com.jagr.ejb.RemoteServiceInterface;

/**
 * Created by javier.garcia on 06/07/2016.
 */
public class EjbController extends HttpServlet {

    private static final String APP = "";
    private static final String MODULE = "ejbRemoto";
    private static final String DISTINCT_NAME = "";
    private static final String BEAN = RemoteServiceBean.class.getSimpleName();
    private static final String REMOTE = RemoteServiceInterface.class.getName();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
		    //Propiedades JNDI
			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProps.put("jboss.naming.client.ejb.context", true);
			jndiProps.put(Context.PROVIDER_URL, "remote://localhost:4447");
			Context context = new InitialContext(jndiProps);

            //Lookup
			RemoteServiceInterface remoteServiceInterface = (RemoteServiceInterface) context.lookup("java:" + APP
					+ "/" + MODULE + "/" + DISTINCT_NAME + "/" + BEAN + "!" + REMOTE);

            String nombre = request.getParameter("nombre");

            if ("".equals(nombre) || nombre == null) {
                throw new Exception("No se ha especificado nombre");
            }

            //Ejecución de método remoto
			String respuesta = remoteServiceInterface.sayHello(nombre);

            //Redirect a la vista
            request.setAttribute("nombre", nombre);
            request.setAttribute("respuesta", respuesta);
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
            RequestDispatcher view = request.getRequestDispatcher("error.jsp");
            request.setAttribute("error", e.getMessage());
            view.forward(request, response);
		}

	}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

}
