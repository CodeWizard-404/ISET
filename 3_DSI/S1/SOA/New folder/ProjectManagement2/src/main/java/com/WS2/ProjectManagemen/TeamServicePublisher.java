package com.WS2.ProjectManagemen;

import javax.xml.ws.Endpoint;

public class TeamServicePublisher {

    public static void main(String[] args) {
        // Publish the service at the specified URL
        Endpoint.publish("http://localhost:8080/ws/team", new TeamServiceImpl());
        System.out.println("SOAP service is running at http://localhost:8080/ws/team?wsdl");
    }
}
