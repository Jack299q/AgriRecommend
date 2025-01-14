package AgriRecommend.service.implement;

import AgriRecommend.domain.Category;
import AgriRecommend.mapper.CategoryMapper;
import AgriRecommend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public Category getCategoryById(Long categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    public List<Category> listAllCategory() {
        return categoryMapper.listAllCategory();
    }

    public int insertCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    public int deleteCategoryById(Long categoryId) {
        return categoryMapper.deleteCategoryById(categoryId);
    }
}
