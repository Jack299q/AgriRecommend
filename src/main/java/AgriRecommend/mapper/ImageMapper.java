package AgriRecommend.mapper;

import AgriRecommend.domain.ProductImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ImageMapper {

    @Insert("INSERT INTO image_path(product_id, path) VALUES (#{productId}, #{path})")
    public void insertImage(ProductImage productImage);

    @Select("SELECT * FROM image_path WHERE product_id = #{productId}")
    public List<ProductImage> selectImageByProductId(Long productId);

    @Delete("DELETE FROM image_path WHERE product_id = #{productId}")
    public void deleteImageByProductId(Long productId);
}
