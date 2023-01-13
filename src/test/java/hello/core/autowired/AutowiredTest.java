package hello.core.autowired;

import hello.core.entity.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    /**
     * 스프링 빈이 아닌 Member 를 자동 주입 대상일 때,
     * 옵션으로 처리하는 방법 테스트용 클래스
     */
    static class TestBean {

        @Autowired(required = false) // Member 는 스프링 빈이 아니므로 메서드 호출 자체가 안됨
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2); // noBean2 = null
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3); // noBean3 = Optional.empty
        }
    }
}
