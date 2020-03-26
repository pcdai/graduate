package cn.sjxy.graduate.entity.dto;

import cn.sjxy.graduate.entity.Scenic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/26 14:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScenicDto extends Scenic {
    private List imgList;
}
