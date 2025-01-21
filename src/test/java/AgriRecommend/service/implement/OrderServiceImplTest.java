package AgriRecommend.service.implement;

import AgriRecommend.domain.OrderItem;
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
    void makeNewOrder() {
        f();
        orderService.makeNewOrder(1L,orderItems);
        orderService.makePayment(1L,new BigDecimal(100),"微信");
    }

    @Test
    void makePayment() {
        orderService.makePayment(3L,new BigDecimal(100),"微信");
    }
}