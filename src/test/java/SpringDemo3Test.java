import com.mloine.spring.demo1.entity.Persion;
import com.mloine.spring.demo3.config.MloineConfig3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description:    @scop测试用例
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo3Test {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig3.class);

        //1.获取所有容器中的组件
        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        for(String x:beanDefinitionNames){
            System.out.println(x);
        }

        //从容器中去两次persion实例 看是否为同一个bean

        Persion persion1 = (Persion) app.getBean("persion");

        Persion persion2 = (Persion) app.getBean("persion");

        System.out.println(persion1.hashCode());
        System.out.println(persion2.hashCode());
        System.out.println(persion1 == persion2);
    }
}
