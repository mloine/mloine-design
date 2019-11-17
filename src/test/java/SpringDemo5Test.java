import com.mloine.spring.demo4.config.MloineConfig4;
import com.mloine.spring.demo5.config.MloineConfig5;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/11/13 14:51
 */
public class SpringDemo5Test {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig5.class);

        System.out.println("IOC容器创建完成....................");


    }
}
