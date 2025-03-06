package AgriRecommend;

import AgriRecommend.service.ICategoryService;
import AgriRecommend.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AgriRecommendApplicationTests {

    @Autowired
    ICategoryService categoryService;
    @Autowired
    IProductService productService;
    @Test
    void contextLoads() {
        System.out.println(productService.selectRecommendationsByUserId(8L));
    }

}
