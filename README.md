# INVOKE EJB3.0 from external server 

These examples contains an ejb 3.0 module and web application for invoke remote ejb3 via JNDI.

#ejbRemoto
Ejb project for deploy at jBoss.

#ejbTesting
War project for invoke remote ejb running on jboss server.

#Test
Run jbossDeploy 
Deploy ejbRemoto.jar. You can get it from ejbRemoto\out\artifacts\ejbRemoto_jar folder or generate with you favourite ide. 
Run tomcat
Deploy ejbTesting.war. You can get it from ejbTesting\out\artifacts\ejbTesting folder or generate with you favourite ide. 
Type on your internet navigator http://localhost:8080 or url configured in your tomcat.
Submit the form.