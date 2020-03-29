package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @Author dpc
 * @Date 2020/3/29 9:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private Integer id;
    private String comment;
    private Integer userId;
    private Integer scenicApplyId;

    @Transient
    private String memberName;
    @Transient
    private String phone;
}
