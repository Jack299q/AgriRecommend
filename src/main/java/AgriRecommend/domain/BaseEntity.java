package AgriRecommend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    public String createBy;
    public String updateBy;
    public Date createTime;
    public Date updateTime;
}
