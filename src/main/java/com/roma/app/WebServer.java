package com.roma.app;

import com.roma.app.servlets.AllRequestsServlet;
import com.roma.app.servlets.MirrorServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.*;
import java.lang.Exception;
import java.lang.InterruptedException;

public class WebServer
{
    public static void main( String[] args ) throws Exception, IOException, InterruptedException {

        AllRequestsServlet allRequestServlet = new AllRequestsServlet();
        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(allrequestServler), "/allrequests");
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();

        System.out.println("Server started");

        server.join();
    }
}
