package cn.haichang.comment.impl;

import cn.haichang.comment.Comment;
import cn.haichang.comment.CommentService;
import cn.weforward.common.ResultPage;
import cn.weforward.common.util.ResultPageHelper;
import cn.weforward.data.persister.PersisterFactory;

/**
 * @author HaiChang
 * @date 2020/10/25
 **/
public class CommentServiceImpl extends CommenDiImpl implements CommentService {

    public CommentServiceImpl(PersisterFactory m_Factory) {
        super(m_Factory);
    }

    @Override
    public Comment createComment(String accessId, String content) {
        return new CommentImpl(this,accessId,content);
    }

    @Override
    public ResultPage<CommentImpl> getComments(String accessId) {
        ResultPage<CommentImpl> rp = m_PsComment.startsWith(accessId);
        return rp;
    }
}
