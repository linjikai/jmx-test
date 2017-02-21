package yfzx.mbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

/**
 * Created by JiKai Lin on 2017/2/21.
 */
@Configuration
public class JmxConfig {

    @Bean
    @DependsOn(value = "rmiRegistryFactoryBean")
    public ConnectorServerFactoryBean connectorServerFactoryBean() {
        ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
        csfb.setServiceUrl("service:jmx:rmi://10.10.16.61/jndi/rmi://10.10.16.61:1199/ljktest");
        return csfb;
    }

    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
//        rmiRegistryFactoryBean.setHost("10.10.16.61");
        rmiRegistryFactoryBean.setPort(1199);
        return rmiRegistryFactoryBean;
    }
}
