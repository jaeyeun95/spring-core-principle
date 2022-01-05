package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServcieSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
//        statefulService1.order("userA", 10000);
        // ThreadB : B사용자 20000원 주문
//        statefulService2.order("userB", 20000);

        // ThreadA : 사용자A 주문 금액 조회 -> A사용자 것을 조회했지만 2만원이 출력된다.
        // 같은 Bean을 보고 있기 때문에
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

//         해결
        int priceA = statefulService1.order("userA", 10000);
        int priceB = statefulService2.order("userB", 20000);

        System.out.println("A = " + priceA);
        System.out.println("B = " + priceB);
    }

    static class TestConfig {

        @Bean
        public StatefulService stateFulService() {
            return new StatefulService();
        }
    }

}