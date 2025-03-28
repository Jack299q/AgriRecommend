package AgriRecommend.service;

import AgriRecommend.domain.ProductDescription;
import AgriRecommend.domain.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {
    ProductDescription getProductByProductSn(String productSn);

    List<ProductDescription> listAllProduct();
    List<Recommend> selectRecommendationsByUserId(@Param("userId") Long userId);

    /**
     * 查询单个产品
     *
     * @param productId 主键
     * @return 对象
     */
    ProductDescription selectProductById(Long productId);

    /**
     * 新增产品
     *
     * @param productDescription
     * @return 影响记录数
     */
    int insertProduct(ProductDescription productDescription);

    /**
     * 修改产品
     *
     * @param productDescription
     * @return 影响记录数
     */
    int updateProduct(ProductDescription productDescription);

    /**
     * 删除产品
     *
     * @param productId 主键
     * @return 影响记录数
     */
    int deleteProductById(Long productId);

    ProductDescription getProduct(Long id);
    List<ProductDescription> selectProductList(String query);
}
