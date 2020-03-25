package cn.sjxy.graduate.utils;

import tk.mybatis.mapper.entity.Condition;

/**
 * @Author dpc
 * @Date 2020/3/25 10:50
 */
public class ConditionUtil {
    public static Condition getCondition(Class type){
        Condition condition = new Condition(type);
        return condition;
    }
}
