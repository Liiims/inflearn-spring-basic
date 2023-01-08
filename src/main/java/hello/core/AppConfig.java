package hello.core;

import hello.core.entity.discount.FixDiscountPolicy;
import hello.core.entity.member.MemoryMemberRepository;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
