package cn.sjxy.graduate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 景点申请(ScenicApply)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScenicApply {
    private static final String DDFormat = "yyyy-MM-dd";
    private static final String TIME_ZONE = "GMT+8";

    @Id
    private Integer id;
    /**
     * 景点id
     */
    private Integer scenicId;
    /**
     * 付款金额
     */
    private String pay;
    /**
     * 用户id
     */
    private Integer memberId;
    /**
     * 下单时间
     */
    @JsonFormat(pattern = DDFormat, timezone = TIME_ZONE)
    private Date orderTime;
    /**
     * 支付状态：0已支付,1 未支付
     */
    private Integer status;
    /**
     * 订单名称::其实就是景点名称
     */
    private String orderName;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 单价
     */
    private String money;
    /**
     * 总价钱
     */
    private String allMoney;
    @Transient
    private String img;
}