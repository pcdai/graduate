package cn.sjxy.graduate.beans;

import java.io.Serializable;

/**
 * 景点分类表(Type)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public class Type implements Serializable {
    private static final long serialVersionUID = -38810760015553431L;
    
    private Integer id;
    /**
    * 分类介绍
    */
    private String desc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}