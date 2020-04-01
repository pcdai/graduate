package cn.sjxy.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @Author dpc
 * @Date 2020/3/29 9:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    private static final String DDFormat = "yyyy-MM-dd";
    private static final String TIME_ZONE = "GMT+8";

    @Id
    private Integer id;
    private String comment;
    private Integer userId;
    private Integer scenicApplyId;
    @JsonFormat(pattern=DDFormat, timezone = TIME_ZONE)
    private Date commentTime;
    @Transient
    private String memberName;
    @Transient
    private String phone;
}
