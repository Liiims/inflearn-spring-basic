package hello.core;

import hello.core.entity.member.Grade;
import hello.core.entity.member.Member;
import hello.core.entity.order.Order;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
