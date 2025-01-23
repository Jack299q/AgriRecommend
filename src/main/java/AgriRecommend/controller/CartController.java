package AgriRecommend.controller;

import AgriRecommend.aop.Log;
import AgriRecommend.core.AjaxResult;
import AgriRecommend.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    /**
     * 获取购物车中的商品列表
     * @param userId 用户 ID
     * @return 购物车商品列表
     */
    @GetMapping("/{userId}")
    public AjaxResult getCartItems(@PathVariable("userId") Long userId) {
        try {
            return AjaxResult.success(cartService.getCartItems(userId));
        } catch (Exception e) {
            return AjaxResult.error("获取购物车失败：" + e.getMessage());
        }
    }

    @GetMapping("/total/{userId}")
    public AjaxResult gettotal(@PathVariable("userId") Long userId){
        return  AjaxResult.success(cartService.total(userId));
    }

    @PostMapping("/add")
    @Log
    public AjaxResult addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity){
        try {
            cartService.addToCart(userId, productId, quantity);
            return AjaxResult.success("Add successfully!");
        } catch (Exception e) {
            return AjaxResult.error("Failed：" + e.getMessage());
        }
    }

    @PostMapping("/edit")
    public AjaxResult edit(@RequestParam Long userId,@RequestParam Long productId,@RequestParam Integer quantity){
        try {
            cartService.updateCard(userId, productId, quantity);
            return AjaxResult.success("edit successfully!");
        } catch (Exception e) {
            return AjaxResult.error("Failed：" + e.getMessage());
        }
    }

    @PostMapping("/remove")
    public AjaxResult remove(@RequestParam Long userId,@RequestParam Long productId){
        cartService.removeFromCart(userId, productId);
        return  AjaxResult.success("从购物车删除成功");
    }

    @GetMapping("/clear/{userId}")
    public AjaxResult clear(@PathVariable("userId") Long userId){
        cartService.clearCart(userId);
        return AjaxResult.success("清空购物车成功！");
    }
}
