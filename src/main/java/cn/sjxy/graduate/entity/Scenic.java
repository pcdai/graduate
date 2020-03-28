package cn.sjxy.graduate.entity;

import java.io.Serializable;

/**
 * 景点(Scenic)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */

public class Scenic implements Serializable {
    private static final long serialVersionUID = 493872214223193942L;
    
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
    * 具体图片
    */
    private String img;
    /**
    * 地址
    */
    private String area;

    @Override
    public String toString() {
        return "Scenic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", img='" + img + '\'' +
                ", area='" + area + '\'' +
                ", ticket='" + ticket + '\'' +
                ", desc='" + desc + '\'' +
                ", typeId=" + typeId +
                ", evaluate='" + evaluate + '\'' +
                ", hot='" + hot + '\'' +
                '}';
    }

    /**
    * 门票价格
    */
    private String ticket;
    /**
    * 详情
    */
    private String desc;
    /**
    * 分类
    */
    private Integer typeId;
    /**
    * 评价
    */
    private String evaluate;
    /**
    * 热门 0:热门 1:不热门
    */
    private String hot;


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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

}