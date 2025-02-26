package AgriRecommend.controller;

import AgriRecommend.aop.Log;
import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.ICartService;
import AgriRecommend.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    /**
     * 获取购物车中的商品列表
     * @return 购物车商品列表
     */
    @GetMapping("/get")
    public AjaxResult getCartItems() {
        Long userId = UserHolder.getUser();
        try {
            return AjaxResult.success(cartService.getCartItems(userId));
        } catch (Exception e) {
            return AjaxResult.error("获取购物车失败：" + e.getMessage());
        }
    }

    @GetMapping("/total")
    public AjaxResult gettotal(){
        Long userId = UserHolder.getUser();
        return  AjaxResult.success(cartService.total(userId));
    }

    @PostMapping("/add")
    @Log
    public AjaxResult addToCart( @RequestParam Long productId, @RequestParam Integer quantity){
        try {
            Long userId = UserHolder.getUser();
            cartService.addToCart(userId, productId, quantity);
            return AjaxResult.success("Add successfully!");
        } catch (Exception e) {
            return AjaxResult.error("Failed：" + e.getMessage());
        }
    }

    @PostMapping("/edit")
    public AjaxResult edit(@RequestParam Long productId,@RequestParam Integer quantity){
        try {
            Long userId = UserHolder.getUser();
            cartService.updateCard(userId, productId, quantity);
            return AjaxResult.success("edit successfully!");
        } catch (Exception e) {
            return AjaxResult.error("Failed：" + e.getMessage());
        }
    }

    @PostMapping("/remove")
    public AjaxResult remove(@RequestParam Long productId){
        Long userId = UserHolder.getUser();
        cartService.removeFromCart(userId, productId);
        return  AjaxResult.success("从购物车删除成功");
    }

    @DeleteMapping("/clear")
    public AjaxResult clear(){
        Long userId = UserHolder.getUser();
        cartService.clearCart(userId);
        return AjaxResult.success("清空购物车成功！");
    }
}
