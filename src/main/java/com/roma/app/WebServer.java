package com.roma.app;

import org.eclipse.jetty.server.Server;
import org .eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebServer
{
    public static void main( String[] args )
    {
        AllRequestServet allRequestServlet = new AllRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServlerContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allrequestServler), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
