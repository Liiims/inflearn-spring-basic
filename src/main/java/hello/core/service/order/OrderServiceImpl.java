package hello.core.service.order;

import hello.core.entity.discount.DiscountPolicy;
import hello.core.entity.discount.FixDiscountPolicy;
import hello.core.entity.member.Member;
import hello.core.entity.member.MemberRepository;
import hello.core.entity.member.MemoryMemberRepository;
import hello.core.entity.order.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}