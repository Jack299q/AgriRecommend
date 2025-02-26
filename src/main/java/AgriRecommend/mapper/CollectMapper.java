package AgriRecommend.mapper;

import AgriRecommend.domain.Collect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectMapper {

    @Insert("insert into agri_collect(id, user_id, product_id, collect_time) values (#{id}, #{userId}, #{productId}, #{collectTime})")
    public int insert(Collect collect);

    @Select("select count(*) from agri_collect where user_id = #{userId} and product_id = #{productId}")
    public int selectCollect(Collect collect);
}
