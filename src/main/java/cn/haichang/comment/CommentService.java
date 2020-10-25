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
     * @param accessId 
     * @param content 
     * @return
     */
    Comment createComment(String accessId,String content);

    ResultPage<CommentImpl> getComments(String accessId);
    
}
