package AgriRecommend.mapper;

import AgriRecommend.domain.Collect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectMapper {

    @Insert("insert into agri_collect(id, user_id, product_id, collect_time) values (#{id}, #{user_id}, #{product_id}, #{collect_time})")
    public int insert(Collect collect);

    @Select("select count(*) from agri_collect where user_id = #{user_id} and product_id = #{product_id}")
    public int selectCollect(Collect collect);
}
