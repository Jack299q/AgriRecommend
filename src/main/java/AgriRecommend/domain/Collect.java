package AgriRecommend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private Long id;
    private Long userId;
    private Long productId;
    private LocalDateTime collectTime;
}
