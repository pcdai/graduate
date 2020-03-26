package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 景点分类表(Type)实体类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Type implements Serializable {
    private static final long serialVersionUID = -38810760015553431L;
    
    private Integer id;
    private String desc;
    private Integer scenicId;


}