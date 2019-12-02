import com.mloine.spring.demo6.config.MloineConfig6;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo6Test {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig6.class);

        Object bean1 =  app.getBean("mloineFactoryBean");
        Object bean2 =  app.getBean("mloineFactoryBean");
        System.out.println(bean1.getClass());
        System.out.println(bean2.getClass());
        System.out.println(bean1 == bean2);

        Object bean3 =  app.getBean("&mloineFactoryBean");

        System.out.println("IOC容器创建完成....................");

        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).stream().forEach(System.out::println);


    }
}
