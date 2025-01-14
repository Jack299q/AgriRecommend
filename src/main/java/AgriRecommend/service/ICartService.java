package AgriRecommend.service;

import AgriRecommend.domain.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface ICartService {
    List<Cart> getCartItems(Long userId);
     void addToCart(Long userId, Long productId, Integer quantity);
    void removeFromCart(Long userId, Long productId);
    void updateCard(Long userId,Long productId,Integer quantity);
    //清空购物车
    void clearCart(Long userId);
    //计算每个用户购物车总金额
    BigDecimal total(Long userId);
}
