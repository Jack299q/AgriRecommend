package AgriRecommend.mapper;

import AgriRecommend.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface OrderMapper {
    @Select("select * from agri_order where order_num=#{orderNum}  ")
    public Order selectOrderBynum(String orderNum);
    @Select("select  * from agri.agri_order where order_status=#{status} and user_id=#{userId}")
    public List<Order> selectOrderByStatus(Long userId,String status);
    @Select("select  * from agri.agri_order where user_id=#{userId} ")
    public List<Order> listAllOrder(Long userId);

    @Insert("insert into agri_order(order_id, order_num,user_id, total, order_status, payment_method,create_time,create_by,update_time,update_by)"+
            " values(#{orderId}, #{orderNum},#{userId} ,#{total} ,#{orderStatus} ,#{paymentMethod},#{createTime},#{createBy} ,#{updateTime} ,#{updateBy}    ) ")
    public int insertOrder(Order order);

    @Update("update agri_order set order_status =#{order.orderStatus} ,payment_method=#{order.paymentMethod} where order_id=#{id} ")
    public int updateOrder(Order order,Long id);
    @Delete("delete from agri_order where order_id=#{id} ")
    public int deleteOrderById(Long id);
}
