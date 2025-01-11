package AgriRecommend.mapper;

import AgriRecommend.domain.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT category_id,category_name FROM agri_category where category_id=#{categoryId}")
    Category getCategoryById(Long categoryId);
    @Select("SELECT category_id,category_name FROM agri_category")
    List<Category> listAllCategory();
    @Insert("INSERT into agri_category(category_name) values (#{categoryName} )")
    int insertCategory(Category category);
    @Update("update agri_category set category_name=#{categoryName} where category_id=#{categoryId} ")
    int updateCategory(Category category);
    @Delete("delete  from agri_category where category_id=#{categoryId} ")
    int deleteCategoryById(Long categoryId);
}
