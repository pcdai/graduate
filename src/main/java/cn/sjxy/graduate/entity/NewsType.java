package cn.sjxy.graduate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author dpc
 * @Date 2020/4/3 12:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NewsType {
    @Id
    private Integer id;
    private String type;
}
