package cn.haichang.comment.impl;

import cn.haichang.comment.Comment;
import cn.haichang.comment.CommentService;
import cn.weforward.common.ResultPage;
import cn.weforward.common.util.ResultPageHelper;
import cn.weforward.data.persister.PersisterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaiChang
 * @date 2020/10/25
 **/
public class CommentServiceImpl extends CommenDiImpl implements CommentService {

    public CommentServiceImpl(PersisterFactory m_Factory) {
        super(m_Factory);
    }
    
    /**
     * 创建评论 
     * @param accessId 接入对象的id
     * @param content 评论内容
     * @return
     */
    @Override
    public Comment createComment(String accessId, String content) {
        return new CommentImpl(this,accessId,content);
    }

    /**
     * 获取接入对象的所有评论
     * @param accessId 接入对象的id
     * @return
     */
    @Override
    public ResultPage<Comment> getComments(String accessId) {
        ResultPage<? extends Comment> rp = m_PsComment.startsWith(accessId);
        List<Comment> list = new ArrayList<>();
        for (Comment comment : ResultPageHelper.toForeach(rp)) {
            list.add(comment);
        }
        return ResultPageHelper.toResultPage(list);
    }
}
