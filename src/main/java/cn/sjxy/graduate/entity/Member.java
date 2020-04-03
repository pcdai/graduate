package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户表(Member)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private Integer id;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private String code;
    /**
     * 专有账户id
     */
    private Integer cardId;
    /**
     * 已订购的景点
     */
    private Integer scenicApplyId;
    /**
     * 已订购的酒店
     */
    private Integer hotelApplyId;
    /**
     * 头像
     */
    private String photo;
    /**
     * 手机号码
     */
    private String telephone;

}