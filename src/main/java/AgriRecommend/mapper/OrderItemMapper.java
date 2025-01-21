package AgriRecommend.mapper;

import AgriRecommend.domain.OrderItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {
    @Insert("insert into agri_orderitem( product_id, order_id, product_name, price, quantity)"+
            "values (#{productId} ,#{orderId} ,#{productName} ,#{price} ,#{quantity} )")
    public int insertOrderItem(OrderItem orderItem);
    @Delete("delete from agri_orderitem where order_id=#{orderId} ")
    public int deleteOrderItemById(Long orderId);
}
