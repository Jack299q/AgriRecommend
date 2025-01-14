package AgriRecommend.service.implement;

import AgriRecommend.domain.Cart;
import AgriRecommend.service.ICartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {

@Autowired
    private ICartService iCartService;
    @Test
    void total() {
        System.out.println(  iCartService.total(1L));
    }
    @Test
    void getall(){
     List<Cart> list=   iCartService.getCartItems(1L);
     for(Cart cart:list){
         System.out.println(cart.getProductId()+cart.getProductName());
     }
    }
    @Test
    void addcart(){
        iCartService.addToCart(3L,4L,1);
    }
    @Test
    void update(){
        iCartService.updateCard(2L,3L,1);
    }
}