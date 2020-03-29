package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.dao.CommentDao;
import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author dpc
 * @Date 2020/3/29 9:46
 */
@Service
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Autowired
    private CommentDao commentDao;
}
