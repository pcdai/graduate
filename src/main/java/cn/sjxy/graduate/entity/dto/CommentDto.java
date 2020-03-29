package cn.sjxy.graduate.entity.dto;

import cn.sjxy.graduate.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/29 10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentDto extends Comment {
    private String MemberName;
}
