package yfzx.mbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;

/**
 * Created by JiKai Lin on 2017/2/21.
 */
@Configuration
public class MbeanConfiguration{

    @Bean
    public MBeanServerConnectionFactoryBean connectionFactoryBean() throws MalformedURLException {
        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        mbscfb.setServiceUrl("service:jmx:rmi://10.10.16.61/jndi/rmi://10.10.16.61:1199/ljktest");
        return mbscfb;
    }

    @Bean
    public MBeanProxyFactoryBean proxyFactoryBean(MBeanServerConnection connection) throws MalformedObjectNameException {

        MBeanProxyFactoryBean proxy = new MBeanProxyFactoryBean();
        proxy.setObjectName("bean:name=ljktest");
        proxy.setServer(connection);
        proxy.setProxyInterface(IJmxTest.class);
        return proxy;
    }
}
