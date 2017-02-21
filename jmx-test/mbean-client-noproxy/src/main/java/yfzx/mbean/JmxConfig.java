package yfzx.mbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import java.net.MalformedURLException;

/**
 * Created by JiKai Lin on 2017/2/21.
 */
@Configuration
public class JmxConfig {

    @Bean
    public MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean() throws MalformedURLException {

        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        mbscfb.setServiceUrl("service:jmx:rmi://10.10.16.61/jndi/rmi://10.10.16.61:1199/ljktest");
        return mbscfb;
    }
}
