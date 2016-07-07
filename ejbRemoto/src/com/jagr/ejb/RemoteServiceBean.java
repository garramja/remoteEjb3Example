package com.jagr.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Date;

/**
 * Created by javier.garcia on 06/07/2016.
 */
@Stateless
@Remote(RemoteServiceInterface.class)
public class RemoteServiceBean implements RemoteServiceInterface {

    @Override
    public String sayHello(String to) {
        System.out.println("Se ha invocado al EJB RemoteServiceBean, método sayHello.");
        return "Hola " + to + ". Encantado de conocerte. ¿Sabes que también me puedes preguntar la hora invocando mi servicio getDate()?";
    }

    @Override
    public Date getDate() {
        System.out.println("Se ha invocado al EJB RemoteServiceBean, método getDate().");
        return new Date();
    }
}
