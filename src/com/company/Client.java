package com.company;

import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created by junjshi on 2/20/18.
 */
public class Client {

    public static void main(String[] args) throws IOException, Exception, NullPointerException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mbeanName = new ObjectName("jmxBean:name=hello");
        System.out.println("Domains ......");
        String[] domains = mbsc.getDomains();
        for(int i=0;i<domains.length;i++){
            System.out.println("doumain[" + i + "]=" + domains[i] );
        }
        System.out.println("MBean count = " + mbsc.getMBeanCount());
        mbsc.setAttribute(mbeanName,new Attribute("Name","hangzhou"));
        mbsc.setAttribute(mbeanName,new Attribute("Age","1990"));
        String age = (String)mbsc.getAttribute(mbeanName, "Age");
        String name = (String)mbsc.getAttribute(mbeanName, "Name");
        System.out.println("age=" + age + ";name=" + name);

        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc,mbeanName,HelloMBean.class,false);
        proxy.helloWorld();
        proxy.helloWorld("hihi");
        proxy.getTelephone();
        mbsc.invoke(mbeanName, "getTelephone", null, null);
        mbsc.invoke(mbeanName, "helloWorld", new String[]{"I'll connect to JMX Server via client2"}, new String[]{"java.lang.String"});
        mbsc.invoke(mbeanName, "helloWorld", null, null);
    }

}
