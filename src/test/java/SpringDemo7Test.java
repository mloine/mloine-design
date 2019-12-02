import com.mloine.spring.demo7.config.MloineConfig7;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo7Test {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig7.class);

        System.out.println("IOC容器创建完成....................");
//        Object bike = app.getBean("bike");
        app.close();
    }
}
