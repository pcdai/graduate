package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * 景点(Scenic)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Scenic implements Serializable {
    private static final long serialVersionUID = 493872214223193942L;
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
     * 具体图片
     */
    private String img;
    /**
     * 图片集合（在数据中没有对应字段）
     */

    private List<String> imgList;
    /**
     * 景区详情
     */

    private String details;
    /**
     * 联系电话
     */

    private String contact;
    /**
     * 开放时间
     */

    private String openTime;

    /**
     * 地址
     */
    private String area;

    /**
     * 门票价格
     */
    private String ticket;
    /**
     * 描述
     */
    private String info;
    /**
     * 分类
     */
    private Integer typeId;
    /**
     * 评价
     */
    private String commentId;
    /**
     * 热门 0:热门 1:不热门
     */
    private String hot;
    /**
     * 附近餐厅
     */
    private String restId;
    /**
     * 附近民宿
     */
    private String hotelId;

}