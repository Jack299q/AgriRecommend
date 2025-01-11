package AgriRecommend.service;

import AgriRecommend.domain.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long categoryId);
    List<Category> listAllCategory();
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategoryById(Long categoryId);
}
