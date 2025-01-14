package AgriRecommend.service.implement;

import AgriRecommend.domain.ProductDescription;
import AgriRecommend.mapper.ProductMapper;
import AgriRecommend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductDescription getProductByProductSn(String productSn) {
        return productMapper.getProductByProductSn(productSn);
    }

    public List<ProductDescription> listAllProduct() {
        return productMapper.listAllProduct();
    }

    /**
     * 查询单个产品
     *
     * @param productId 主键
     * @return 对象
     */
    public ProductDescription selectProductById(Long productId) {
        return productMapper.selectProductById(productId);
    }

    /**
     * 新增产品
     *
     * @param productDescription
     * @return 影响记录数
     */
    public int insertProduct(ProductDescription productDescription) {
        return productMapper.insertProduct(productDescription);
    }

    /**
     * 修改产品
     *
     * @param productDescription
     * @return 影响记录数
     */
    public int updateProduct(ProductDescription productDescription) {
        return productMapper.updateProduct(productDescription);
    }

    /**
     * 删除产品
     *
     * @param productId 主键
     * @return 影响记录数
     */
    public int deleteProductById(Long productId) {
        return productMapper.deleteProductById(productId);
    }
}
