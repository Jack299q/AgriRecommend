package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.domain.OrderItem;
import AgriRecommend.service.IOrderService;
import AgriRecommend.utils.UserHolder;
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
    public AjaxResult makeNewOrder(@RequestParam List<OrderItem> orderItemList){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.makeNewOrder(userId, orderItemList));
    }
    @PostMapping("/makePayment")
    public AjaxResult makePayment(@RequestParam BigDecimal cashtendered, @RequestParam String paymentMethod){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.makePayment(userId, cashtendered, paymentMethod));
    }

}
