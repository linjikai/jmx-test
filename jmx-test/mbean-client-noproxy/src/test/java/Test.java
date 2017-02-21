import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yfzx.App;

import javax.management.*;
import java.io.IOException;
import java.util.Set;

/**
 * Created by JiKai Lin on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Test {

    @Autowired
    private MBeanServerConnection mBeanServerConnection;

    @org.junit.Test
    public void mbeanTest() throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, InvalidAttributeValueException {


        int age = (int) mBeanServerConnection.getAttribute(new ObjectName("bean:name=ljktest"), "Age");
        System.out.println(age);
        mBeanServerConnection.setAttribute(new ObjectName("bean:name=ljktest"),new Attribute("Age",10));
        int age1 = (int) mBeanServerConnection.getAttribute(new ObjectName("bean:name=ljktest"), "Age");
        System.out.println(age1);
//        int i =mBeanServerConnection.getMBeanCount();
//        System.out.println(i);
//        Set<ObjectName> objectNames = mBeanServerConnection.queryNames(null, null);
//        for (ObjectName o : objectNames) {
//            System.out.println(o.toString());
//        }
//        String cronExpression = (String) mBeanServerConnection.getAttribute(
//                new ObjectName("DefaultDomain:name=com.xmgps.yun.jmx.JmxCommunicationMBean"),"");
    }
}
