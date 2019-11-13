import com.mloine.spring.demo2.config.MloineConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description:    容器初始化测试用例
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo2Test {
    /**
     * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
     * org.springframework.context.annotation.internalRequiredAnnotationProcessor
     * org.springframework.context.annotation.internalCommonAnnotationProcessor
     * org.springframework.context.event.internalEventListenerProcessor
     * org.springframework.context.event.internalEventListenerFactory
     * mloineConfig2
     * orderController
     * orderDao
     * orderService
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig2.class);

        //1.获取所有容器中的组件
        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        for(String x:beanDefinitionNames){
            System.out.println(x);
        }
    }
}
