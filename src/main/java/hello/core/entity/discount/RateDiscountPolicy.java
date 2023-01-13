package hello.core.entity.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.entity.member.Grade;
import hello.core.entity.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // @Qualifier("mainDiscountPolicy") 와 동일하게 동작함(@Qualifier("mainDiscountPolicy") 는 컴파일 오류로 잡을 수 없음)
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
