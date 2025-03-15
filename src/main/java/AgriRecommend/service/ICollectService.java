package AgriRecommend.service;

import AgriRecommend.domain.Collect;
import AgriRecommend.domain.CollectData;

import java.util.List;

public interface ICollectService {
    boolean collect(Collect collect);
    List<CollectData> listCollecrData(Long userId);
     int remove(Long userId,Long productId);
}
