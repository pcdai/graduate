package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 风格表(Style)实体类
 *
 * @author dpc
 * @since 2020-03-22 10:12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Style {
    @Id
    private Integer id;
    /**
    * 特色  
    */
    private String info;




}