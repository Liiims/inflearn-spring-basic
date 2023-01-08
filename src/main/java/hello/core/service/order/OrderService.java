package hello.core.service.order;

import hello.core.entity.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
