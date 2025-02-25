package AgriRecommend.service;

import AgriRecommend.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    // 方法1：根据用户ID和商品ID查找收藏记录
    Optional<Favorite> findByUserIdAndProductId(Long userId, Long productId);

    // 方法2：获取用户收藏的所有商品ID列表
    @Query("SELECT f.productId FROM Favorite f WHERE f.userId = ?1")
    List<Long> findProductIdsByUserId(Long userId);
}
