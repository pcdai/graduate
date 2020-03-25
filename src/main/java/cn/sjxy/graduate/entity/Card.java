package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * CREATE TABLE `home_stay` (
 * `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
 * `name` VARCHAR ( 255 ) DEFAULT NULL COMMENT '名称',
 * `icon` VARCHAR ( 255 ) DEFAULT NULL COMMENT '封面图',
 * `img` VARCHAR ( 255 ) DEFAULT NULL COMMENT '详情图',
 * `desc` VARCHAR ( 255 ) DEFAULT NULL COMMENT '详情',
 * `price` DECIMAL ( 10, 2 ) DEFAULT NULL COMMENT '价格',
 * `evaluate` VARCHAR ( 255 ) DEFAULT NULL COMMENT '评价',
 * `hot` VARCHAR ( 255 ) DEFAULT NULL COMMENT '热门 0:热门 1:不热门',
 * `area` VARCHAR ( 255 ) DEFAULT NULL COMMENT '地址',
 * PRIMARY KEY ( `id` )
 * ) ENGINE = INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8 COMMENT = '酒店/民宿';
 */

/**
 * 专有账户，模仿付款(Card)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {

    @Id
    private Integer id;
    /**
    * 账户
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户id
    */
    private Integer memberId;
    /**
    * 余额
    */
    private String balance;



}