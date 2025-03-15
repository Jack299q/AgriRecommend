package AgriRecommend.service.implement;

import AgriRecommend.domain.Collect;
import AgriRecommend.domain.CollectData;
import AgriRecommend.mapper.CollectMapper;
import AgriRecommend.service.ICollectService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public boolean collect(Collect collect) {
        if(collectMapper.selectCollect(collect)>0){
            return false;
        }
        return collectMapper.insert(collect)==1;
    }
    public List<CollectData> listCollecrData(Long userId){
        return collectMapper.listCollecrData(userId);
    }
    public int remove(Long userId,Long productId){
        return  collectMapper.remove(userId,productId);
    }
}
