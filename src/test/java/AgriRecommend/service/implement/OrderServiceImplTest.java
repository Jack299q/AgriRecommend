package AgriRecommend.service.implement;

import AgriRecommend.domain.Order;
import AgriRecommend.domain.OrderItem;
import AgriRecommend.mapper.OrderMapper;
import AgriRecommend.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    IOrderService orderService;
    @Autowired
    OrderMapper orderMapper;

    List<OrderItem> orderItems=new ArrayList<OrderItem>();

    OrderItem orderItem;
    public void f(){
        orderItem=new OrderItem();
        orderItem.setProductId(1L);
        orderItem.setProductName("车厘子");
        orderItem.setPrice(new BigDecimal(99));
        orderItem.setQuantity(1);
        orderItems.add(orderItem);
    }

@Test
    public void f2(){
    Order order=orderMapper.selectOrderBynum("so-1895141528683155456");
    order.setPaymentMethod("Alipay");
    order.setOrderStatus("已付款");
    orderMapper.updateOrder(order,8L);
//    System.out.println(orderService.makePayment(8L,new BigDecimal(100),"Alipay","so-1895141528683155456"));
}
}