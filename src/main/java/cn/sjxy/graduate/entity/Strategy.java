package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    @Id
    private Integer id;
    /**
    * 景点id
    */
    private Integer scenicId;
    /**
    * 攻略内容          
    */
    private String introducer;
    /**
    * 攻略图片
    */
    private String img;



}