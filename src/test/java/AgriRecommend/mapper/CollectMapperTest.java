package AgriRecommend.mapper;

import AgriRecommend.domain.Collect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollectMapperTest {

    @Autowired
    CollectMapper mapper;
 @Test
    public  void f(){

     Collect collect=new Collect();
     collect.setUserId(Long.valueOf(2));
     collect.setUserId(8L);
     System.out.println(mapper.selectCollect(collect));
 }
}