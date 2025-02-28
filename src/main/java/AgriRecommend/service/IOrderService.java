package AgriRecommend.service;

import AgriRecommend.domain.Cart;
import AgriRecommend.domain.Order;
import AgriRecommend.domain.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderService {
   Order makeNewOrder(Long userId, List<OrderItem> orderItemList);
    BigDecimal makePayment(Long userId,BigDecimal cashTendered,String paymentMethod,String orderNUm);
    public List<Order> listAllOrder(Long userId);
    public List<Order> selectOrderByStatus(Long userId,String status);
}
