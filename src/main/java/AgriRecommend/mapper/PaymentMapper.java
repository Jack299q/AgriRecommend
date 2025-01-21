package AgriRecommend.mapper;

import AgriRecommend.domain.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    @Insert("insert into agri_payment( user_id, order_id, total, payment_method, create_by, create_time, update_by, update_time) "
            +"values(#{userId} ,#{orderId} ,#{total} ,#{paymentMethod} ,#{createBy} ,#{createTime} ,#{updateBy} ,#{updateTime} ) ")
    public int insertPayment(Payment payment);
}
