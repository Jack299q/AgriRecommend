package AgriRecommend.mapper;

import AgriRecommend.domain.ProductDescription;
import AgriRecommend.domain.Recommend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select  * from agri_product where product_sn=#{productSn} ")
    ProductDescription getProductByProductSn(String productSn);

    @Select("select * from agri_product")
    List<ProductDescription> listAllProduct();

    @Select("select * from agri_product where product_id=#{productId} ")
    public ProductDescription selectProductById(Long productId);

    @Select("select  ur.product_id,ur.probability,p.product_name,p.price,p.description "+
            "from recommendresult ur join agri_product p on ur.product_id=p.product_id "+
            "where user_id=#{userId} order by ur.probability DESC"
            )
    List<Recommend> selectRecommendationsByUserId(@Param("userId") Long userId);

    @Insert("insert into agri_product( product_sn, product_name, price, stock, description, category_id) " +
            "values (#{productSn} ,#{productName},#{price} ,#{stock},#{description} ,#{categoryId}  )")
    @Options(useGeneratedKeys = true, keyProperty = "productId",keyColumn = "product_id")
    public int insertProduct(ProductDescription productDescription);

    @Update("update agri_product set product_sn=#{productSn} ,product_name=#{productName} ,price=#{price} ,stock=#{stock} ,description=#{description} " +
            "where product_id=#{productId} ")
    public int updateProduct(ProductDescription productDescription);

    @Delete("delete  from agri_product where product_id=#{productId} ")
    public int deleteProductById(Long productId);

  //搜索
    @Select("SELECT * FROM agri_product WHERE agri_product.product_name LIKE CONCAT('%', #{query}, '%')")
    List<ProductDescription> selectProductList(String query);
}
