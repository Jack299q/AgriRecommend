package AgriRecommend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescription extends BaseEntity{
    private Long productId;
    private  Category category;
    private Long categoryId;
    private String productName;
    private String productSn;
    private BigDecimal price;
    private  BigDecimal stock;
    private String description;

}
