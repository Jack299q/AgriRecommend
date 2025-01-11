package AgriRecommend.mapper;

import AgriRecommend.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void listAllCategory() {
    List<Category> list=    categoryMapper.listAllCategory();
    for (Category category:list){
        System.out.println(category.getCategoryName());
    }
    }
    @Test
    void getcategorybyid(){
        Category category=categoryMapper.getCategoryById(1L);
        System.out.println(category.getCategoryName());
    }
}