package ru.sber.beautifulcode.infrastructure.bootstrap;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import ru.sber.beautifulcode.shared.infrastructure.api.ApiServlet;

import java.io.File;

public class Service {
  private static final int DEFAULT_PORT = 7777;

  public static void main(String[] args) throws LifecycleException {

    String portVariableValue = System.getenv("SBER_BEAUTIFULCODE_SERVICE_PORT");
    int port = portVariableValue == null ? DEFAULT_PORT : Integer.parseInt(portVariableValue);

    Tomcat tomcat = new Tomcat();
    tomcat.setPort(port);

    Connector connector = new Connector();
    connector.setPort(port);
    tomcat.setConnector(connector);

    String contextPath = "";
    String servletName = "api";

    Context context = tomcat.addContext(contextPath, new File(".").getAbsolutePath());
    tomcat.addServlet(contextPath, servletName, new ApiServlet(Endpoints.all()));

    context.addServletMappingDecoded("/*", servletName);

    tomcat.start();
    tomcat.getServer().await();
  }
}
