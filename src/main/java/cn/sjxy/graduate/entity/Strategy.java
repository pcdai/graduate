package cn.sjxy.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 攻略(Strategy)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Strategy {
    private static final String DDFormat = "yyyy-MM-dd";
    private static final String TIME_ZONE = "GMT+8";
    @Id
    private Integer id;
    /**
     * 景点id
     */
    private Integer scenicId;
    /**
     * 攻略内容
     */
    private String introduce;
    @Transient
    private List introduceList;
    /**
     * 攻略图片
     */
    private String img;
    /**
     * 封面图
     */
    private String icon;
    /**
     * 评论id
     */
    private String commentId;
    /**
     * 用户id
     */
    private Integer memberId;
    @JsonFormat(pattern = DDFormat, timezone = TIME_ZONE)
    /**
     * 发布时间
     */
    private Date time;
    @Transient
    private List imgList;
    @Transient
    private String userName;
    @Transient
    private String userPhoto;
    private String title;
    @Transient
    private String scenicName;
    @Transient
    private List commentList;
}