package com.company;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * Created by junjshi on 2/20/18.
 */
public class HelloAgent {
    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanRegistrationException, IOException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(),helloName);

        LocateRegistry.createRegistry(9999);
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url,null,server);
        System.out.println("begin jojo.rmi start");
        jcs.start();
        System.out.println("jojo.rmi start");
    }
}
