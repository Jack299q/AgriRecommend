package AgriRecommend.mapper;

import AgriRecommend.domain.Order;
import org.apache.ibatis.annotations.*;

@Mapper

public interface OrderMapper {
    @Select("select * from agri_order where order_num=#{orderNum}  ")
    public Order selectOrderBynum(String orderNum);

    @Insert("insert into agri_order(order_id, order_num,user_id, total, order_status, payment_method,create_time,create_by,update_time,update_by)"+
            " values(#{orderId}, #{orderNum},#{userId} ,#{total} ,#{orderStatus} ,#{paymentMethod},#{createTime},#{createBy} ,#{updateTime} ,#{updateBy}    ) ")
    public int insertOrder(Order order);

    @Update("update agri_order set order_status =#{orderStatus} ,payment_method=#{paymentMethod} ")
    public int updateOrder(Order order);
    @Delete("delete from agri_order where order_id=#{id} ")
    public int deleteOrderById(Long id);
}
