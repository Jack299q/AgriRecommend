package AgriRecommend.mapper;

import AgriRecommend.domain.Collect;
import AgriRecommend.domain.CollectData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {

    @Insert("insert into agri_collect(id, user_id, product_id, collect_time) values (#{id}, #{userId}, #{productId}, #{collectTime})")
    public int insert(Collect collect);

    @Select("select count(*) from agri_collect where user_id = #{userId} and product_id = #{productId}")
    public int selectCollect(Collect collect);
    @Select("select c.product_id,p.price,p.product_name from agri_collect c join agri_product p on c.product_id = p.product_id where user_id=#{userId} ")
    public List<CollectData> listCollecrData(Long userId);

    @Delete("delete from agri_collect where product_id=#{productId} and user_id=#{userId} ")
    public int remove(Long userId,Long productId);
}
