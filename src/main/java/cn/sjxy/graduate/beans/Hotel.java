package cn.sjxy.graduate.beans;

import java.io.Serializable;

/**
 * (Hotel)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 643585590610594628L;
    
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
    private String desc;
    /**
    * 价格
    */
    private Double price;
    /**
    * 评价
    */
    private String evaluate;
    /**
    *  0:热门 1:不热门
    */
    private String hot;
    /**
    * 地址
    */
    private String area;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}