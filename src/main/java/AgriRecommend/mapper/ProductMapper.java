package AgriRecommend.mapper;

import AgriRecommend.domain.ProductDescription;
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

    @Insert("insert into agri_product( product_sn, product_name, price, stock, description, category_id) " +
            "values (#{productSn} ,#{productName},#{price} ,#{stock},#{description} ,#{categoryId}  )")
    public int insertProduct(ProductDescription productDescription);

    @Update("update agri_product set product_sn=#{productSn} ,product_name=#{productName} ,price=#{price} ,stock=#{stock} ,description=#{description} " +
            "where product_id=#{productId} ")
    public int updateProduct(ProductDescription productDescription);

    @Delete("delete  from agri_product where product_id=#{productId} ")
    public int deleteProductById(Long productId);

    /**
     * 查询产品列表
     *
     * @param productDescription 查询参数
     * @return 对象集合
     */
    @Select("SELECT * FROM agri_product WHERE agri_product.product_name LIKE CONCAT('%', #{query}, '%')")
    List<ProductDescription> selectProductList(String query);
}
