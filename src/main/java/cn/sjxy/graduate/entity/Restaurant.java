package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 餐厅表(Restaurant)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    private Integer id;
    /**
    * 风格id
    */
    private Integer styleId;
    /**
    * 特色菜
    */
    private String specialty;
    /**
    * 地理位置
    */
    private String location;
    /**
    * 封面
    */
    private String icon;
    /**
    * 详情图
    */
    private String img;
    /**
    * 门店信息
    */
    private String info;
    /**
    * 热门 0:热门 1:不热门
    */
    private String hot;


}