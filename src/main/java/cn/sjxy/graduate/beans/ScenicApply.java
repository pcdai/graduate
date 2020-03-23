package cn.sjxy.graduate.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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



}