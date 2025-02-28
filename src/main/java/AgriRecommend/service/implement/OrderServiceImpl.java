package AgriRecommend.service.implement;

import AgriRecommend.core.OrderStatus;
import AgriRecommend.domain.Order;
import AgriRecommend.domain.OrderItem;
import AgriRecommend.domain.Payment;
import AgriRecommend.mapper.OrderItemMapper;
import AgriRecommend.mapper.OrderMapper;
import AgriRecommend.mapper.PaymentMapper;
import AgriRecommend.service.IOrderService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private Order order;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Order makeNewOrder(Long userId, List<OrderItem> orderItemList) {

        order = new Order();
        Date orderDate = new Date();

        String ordernum = "so-" + IdUtil.getSnowflakeNextId(); //雪花算法生成订单编号

        BigDecimal total = new BigDecimal(0);
        for (OrderItem orderItem : orderItemList) {
            total = total.add(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
        }
        order.setUserId(userId);
        order.setCreateTime(orderDate);
        order.setOrderNum(ordernum);
        order.setOrderStatus(OrderStatus.ORDER_RESERVED);
        System.out.println("总价是" + total);
        order.setTotal(total);
        orderMapper.insertOrder(order);

        order.setOrderId(orderMapper.selectOrderBynum(ordernum).getOrderId());

        // 为订单添加商品
        for (OrderItem item : orderItemList) {
            item.setOrderId(order.getOrderId());

            orderItemMapper.insertOrderItem(item);
        }

        return order;
    }

    @Override
    public BigDecimal makePayment(Long userId, BigDecimal cashTendered, String paymentMethod,String orderNUm) {
        Order order1=new Order();
        order1=orderMapper.selectOrderBynum(orderNUm);
        Payment payment = new Payment();
        payment.setOrderId(order1.getOrderId());
        payment.setTotal(order1.getTotal());
        payment.setPaymentMethod(paymentMethod);
        payment.setUserId(userId);
        paymentMapper.insertPayment(payment);
        BigDecimal changecash = cashTendered.subtract(order1.getTotal());
        order1.setOrderStatus(OrderStatus.ORDER_PAID);
        order1.setPaymentMethod(paymentMethod);
        orderMapper.updateOrder(order1,order1.getOrderId());
        return changecash;
    }

    @Override
    public List<Order> listAllOrder(Long userId) {

        return orderMapper.listAllOrder( userId);
    }
    public List<Order> selectOrderByStatus(Long userId,String status){
        return orderMapper.selectOrderByStatus(userId,status);
    }
}
