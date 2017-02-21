import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yfzx.App;
import yfzx.mbean.IJmxTest;

/**
 * Created by JiKai Lin on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Test {

    @Autowired
    private MBeanProxyFactoryBean mBeanProxyFactoryBean;

    @org.junit.Test
    public void mbeanTest()  {

        IJmxTest object = (IJmxTest) mBeanProxyFactoryBean.getObject();
        int age = object.getAge();
        System.out.println(age);
    }
}
