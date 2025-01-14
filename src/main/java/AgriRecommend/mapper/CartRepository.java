package AgriRecommend.mapper;

import AgriRecommend.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {
    //查询该用户所有商品
    List<Cart> findByUserId(Long userId);
    //根据用户 ID 和商品 ID 查询特定的购物车商品
    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);
}
