import com.mloine.spring.demo4.config.MloineConfig4;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description:    @Lazy 测试用例
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo4Test {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig4.class);

        System.out.println("IOC容器创建完成....................");
        app.getBean("persion");


    }
}
