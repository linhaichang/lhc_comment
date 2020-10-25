package cn.haichang.comment.impl;

import cn.haichang.comment.Comment;
import cn.haichang.comment.di.CommentDi;
import cn.weforward.common.ResultPage;
import cn.weforward.data.UniteId;
import cn.weforward.data.log.BusinessLog;
import cn.weforward.data.log.BusinessLogger;
import cn.weforward.data.mongodb.persister.MongodbPersisterFactory;
import cn.weforward.data.persister.Persistent;
import cn.weforward.data.persister.Persister;
import cn.weforward.data.persister.PersisterFactory;

/**
 * 评论di实现
 * @author HaiChang
 * @date 2020/10/25
 **/
public class CommenDiImpl implements CommentDi {

    protected PersisterFactory m_Factory;
    protected Persister<CommentImpl> m_PsComment;

    public CommenDiImpl(PersisterFactory m_Factory) {
        this.m_Factory = m_Factory;
        this.m_PsComment = m_Factory.createPersister(CommentImpl.class, this);
    }
    
    @Override
    public <E extends Persistent> Persister<E> getPersister(Class<E> aClass) {
        return m_Factory.getPersister(aClass);
    }
    
}
