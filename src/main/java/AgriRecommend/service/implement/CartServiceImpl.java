package AgriRecommend.service.implement;

import AgriRecommend.domain.Cart;
import AgriRecommend.domain.Category;
import AgriRecommend.domain.ProductDescription;
import AgriRecommend.mapper.CartRepository;
import AgriRecommend.mapper.CategoryMapper;
import AgriRecommend.mapper.ProductMapper;
import AgriRecommend.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void addToCart(Long userId, Long productId, Integer quantity) {
        // 查询购物车中是否已有该商品
        Optional<Cart> existingItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if (existingItem.isPresent()) {
            // 如果商品已存在，则更新数量和总价
            Cart cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);

            cartRepository.save(cartItem); // 保存更新后的商品
        } else {
            // 如果商品不存在，则创建新记录
            Cart cartItem = new Cart();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(quantity);
            ProductDescription productDescription=productMapper.selectProductById(productId);
            cartItem.setProductName(productDescription.getProductName());
            Category category=categoryMapper.getCategoryById(productDescription.getCategoryId());
            cartItem.setCategoryName(category.getCategoryName());
            cartRepository.save(cartItem); // 保存新商品
        }
    }
  public  void updateCard(Long userId,Long productId,Integer quantity){
      // 查询购物车中是否存在该商品
      Optional<Cart> existingItem = cartRepository.findByUserIdAndProductId(userId, productId);
if (existingItem.isPresent()){
   Cart cart= existingItem.get();
   if(quantity>0){
       cart.setQuantity(quantity);
       cartRepository.save(cart);
   }
   else {
       cartRepository.delete(cart);
   }
}
    }
    @Override
    public void removeFromCart(Long userId, Long productId) {
// 查询指定商品
        Optional<Cart> item = cartRepository.findByUserIdAndProductId(userId, productId);
        // 如果商品存在，则从数据库中删除
        item.ifPresent(cartRepository::delete);
    }

    @Override
    public void clearCart(Long userId) {
        // 查询该用户的所有购物车商品
        List<Cart> items = cartRepository.findByUserId(userId);
        // 批量删除所有商品
        cartRepository.deleteAll(items);
    }

   public  BigDecimal total(Long userId){
       List<Cart> items = cartRepository.findByUserId(userId);
       BigDecimal total=new BigDecimal(0);
       for(Cart cartitem:items){
           ProductDescription product=productMapper.selectProductById(cartitem.getProductId());
         total=  total.add(product.getPrice().multiply(new BigDecimal(cartitem.getQuantity())));
       }
       return total;
   }
}
