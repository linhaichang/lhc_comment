package cn.haichang.comment.impl;

import cn.haichang.comment.Comment;
import cn.haichang.comment.di.CommentDi;
import cn.weforward.common.util.StringUtil;
import cn.weforward.data.UniteId;
import cn.weforward.data.persister.support.AbstractPersistent;
import cn.weforward.framework.support.Global;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 评论Bo实现类
 * @author HaiChang
 * @date 2020/10/25
 **/
public class CommentImpl extends AbstractPersistent<CommentDi> implements Comment {
    
    @Resource
    protected String m_User;
    @Resource
    protected String m_Content;
    @Resource
    protected Date m_CreateTime;
    
    protected CommentImpl(CommentDi di) {
        super(di);
    }

    public CommentImpl(CommentDi di, String accessId, String m_Content) {
        super(di);
        genPersistenceId(accessId);
        this.m_User = getUser();
        this.m_Content = m_Content;
        this.m_CreateTime = new Date();
        markPersistenceUpdate();
    }


    @Override
    public UniteId getId() {
        return getPersistenceId();
    }



    @Override
    public String getContent() {
        return m_Content;
    }


    /**
     * 创建日期
     * @Params user
     * @return
     */
    @Override
    public Date getCreatTime() {
        return m_CreateTime;
    }

    @Override
    public String getUserName() {
        return m_User;
    }

    private String getUser() {
        String creator = Global.TLS.getValue("visitor");
        if (null == creator) {
            creator = "visitor";
        }
        return creator;
    }
}
