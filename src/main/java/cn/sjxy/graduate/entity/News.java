package cn.sjxy.graduate.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

import static com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser.TIME_ZONE;

/**
 * @Author dpc
 * @Date 2020/3/30 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News {
    private static final String DDFormat = "yyyy-MM-dd";
    private static final String TIME_ZONE = "GMT+8";

    @Id
    private Integer id;
    private String title;
    private String icon;
    private String img;
    @Transient
    private List imgList;
    @Transient
    private List detailsList;
    private Integer count;
    private String details;
    @JsonFormat(pattern=DDFormat, timezone = TIME_ZONE)
    private Timestamp time;
    private Integer hot;
}
