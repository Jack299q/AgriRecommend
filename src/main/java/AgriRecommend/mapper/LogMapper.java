package AgriRecommend.mapper;

import AgriRecommend.pojo.UserLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    @Insert("INSERT INTO userlog(user_id, product_id, op_type) VALUES (#{userId}, #{productId}, #{opType})")
    public void insertLog(UserLog log);

}
