package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 民宿申请(HotelApply)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelApply {

    @Id
    private Integer id;
    /**
    * 民宿信息
    */
    private Integer hotelId;
    /**
    * 用户id
    */
    private Integer memberId;
    /**
    * 付款金额
    */
    private String pay;



}