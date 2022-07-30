package com.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class FileToActiveMQ {

    /**
     * Created by Sakshi Mittal
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        // Connection for ActiveMQ server.
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        context.addComponent("activemq",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        // Create camel route
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                    from("file:input_directory?noop=true")  // pick the files from this directory
                            .to("activemq:queue:get_file");  // send the files to ActiveMQ server
            }
        });

        // Keep the route in "start" mode, don't need to stop it.
        while (true)
            context.start();
    }
}
