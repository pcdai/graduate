package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * (Hotel)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel implements Serializable {
    private static final long serialVersionUID = 643585590610594628L;
    @Id
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 封面图
     */
    private String icon;
    /**
     * 详情图
     */
    private String img;
    /**
     * 详情
     */
    private String details;
    /**
     * 价格
     */
    private Double price;
    /**
     * 评价
     */
    private String commentId;
    /**
     * 0:热门 1:不热门
     */
    private String hot;
    /**
     * 地址
     */
    private String area;
    /**
     * 景点id
     */
    private Integer scenicId;
    /**
     *
     */
    @Transient
    private List imgList;
}