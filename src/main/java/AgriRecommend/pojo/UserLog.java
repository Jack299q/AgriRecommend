package AgriRecommend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Around;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLog {
    private Long id;
    private Long userId;
    private Long productId;
    private int opType;
    private LocalDateTime opTime;
}
