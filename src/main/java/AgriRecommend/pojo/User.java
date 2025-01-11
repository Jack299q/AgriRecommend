package AgriRecommend.pojo;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String account;
    private String password;
    private int type;
    private LocalDateTime createTime;
    private LocalDateTime loginTime;
}
