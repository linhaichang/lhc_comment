package cn.haichang.comment;

import cn.haichang.comment.impl.CommentImpl;
import cn.weforward.common.ResultPage;

/**
 * @author HaiChang
 * @date 2020/10/25
 **/
public interface CommentService {
    /**
     * 创建评论 
     * @param accessId 接入对象的id
     * @param content 评论内容
     * @return
     */
    Comment createComment(String accessId,String content);

    /**
     * 获取接入对象的所有评论
     * @param accessId 接入对象的id
     * @return
     */
    ResultPage<Comment> getComments(String accessId);
    
}
