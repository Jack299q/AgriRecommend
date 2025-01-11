package AgriRecommend.service;

import AgriRecommend.domain.ProductDescription;

import java.util.List;

public interface IProductService {
    ProductDescription getProductByProductSn(String productSn);

    List<ProductDescription> listAllProduct();
    /**
     * 查询单个产品
     * @param productId 主键
     * @return 对象
     */
    public ProductDescription selectProductById(Long productId);

    /**
     * 新增产品
     * @param productDescription
     * @return 影响记录数
     */
    public int insertProduct(ProductDescription productDescription);
    /**
     * 修改产品
     * @param productDescription
     * @return 影响记录数
     */
    public int updateProduct(ProductDescription productDescription);
    /**
     * 删除产品
     * @param productId 主键
     * @return 影响记录数
     */
    public int deleteProductById(Long productId);
}
