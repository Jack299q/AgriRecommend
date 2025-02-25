package AgriRecommend.service.implement;

import AgriRecommend.domain.ProductDescription;
import AgriRecommend.mapper.ProductMapper;
import AgriRecommend.service.IProductService;
import ch.qos.logback.core.util.StringUtil;
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


    /**
     * 根据id查询产品
     * @param id 产品id
     * @return 产品
     */
    public ProductDescription getProduct(Long id) {
        return productMapper.selectProductById(id);
    }

    /**
     * 根据商品名称进行模糊查询
     * @param query 名称
     * @return 产品列表
     */
   public List<ProductDescription> selectProductList(String query){
       if(StringUtil.isNullOrEmpty(query)){
           return productMapper.listAllProduct();
       }
        return productMapper.selectProductList(query);
    }

}
