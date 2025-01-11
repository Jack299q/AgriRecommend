package AgriRecommend.mapper;

import AgriRecommend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT 1 FROM user WHERE account = #{account}")
    public Integer getUserByAccount(String account);

    @Insert("INSERT INTO user (account, password) VALUES (#{account}, #{password})")
    public void insertUser(User user);

    @Select("SELECT * FROM user WHERE account=#{account} and password=#{password}")
    public User getUser(User user);

    @Update("UPDATE user SET login_time=NOW() WHERE account=#{account}")
    public void UpdateUser(User user);
}
