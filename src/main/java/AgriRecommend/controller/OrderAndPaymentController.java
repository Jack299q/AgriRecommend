package AgriRecommend.controller;

import AgriRecommend.core.AjaxResult;
import AgriRecommend.domain.OrderItem;
import AgriRecommend.service.IOrderService;
import AgriRecommend.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderAndPaymentController {
    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/makeNewOrder")
    public AjaxResult makeNewOrder(@RequestBody List<OrderItem> orderItemList){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.makeNewOrder(userId, orderItemList));
    }

    @PostMapping("/makePayment")
    public AjaxResult makePayment(@RequestParam String cashtendered, @RequestParam String paymentMethod,@RequestParam String orderNUm){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.makePayment(userId, new BigDecimal(cashtendered), paymentMethod,orderNUm));
    }
    @GetMapping("/listAllOrder")
    public AjaxResult listAllOrder(){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.listAllOrder(userId));
    }
    @GetMapping("/selectOrderByStatus")
    public AjaxResult selectOrderByStatus(@RequestParam String status){
        Long userId = UserHolder.getUser();
        return AjaxResult.success(iOrderService.selectOrderByStatus(userId,status));
    }
    @GetMapping("/orderitem")
    public AjaxResult orderitem(@RequestParam Long orderId){
        return AjaxResult.success(iOrderService.selectorderitem(orderId));
    }
}
