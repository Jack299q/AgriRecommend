package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.domain.OrderItem;
import AgriRecommend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderAndPaymentController {
    @Autowired
    private IOrderService iOrderService;
    @PostMapping("/makeNewOrder")
    public AjaxResult makeNewOrder(@RequestParam  Long userId,@RequestParam List<OrderItem> orderItemList){
        return AjaxResult.success(iOrderService.makeNewOrder(userId, orderItemList));
    }
    @PostMapping("/makePayment")
    public AjaxResult makePayment(@RequestParam Long userId, @RequestParam BigDecimal cashtendered, @RequestParam String paymentMethod){
        return AjaxResult.success(iOrderService.makePayment(userId, cashtendered, paymentMethod));
    }

}
