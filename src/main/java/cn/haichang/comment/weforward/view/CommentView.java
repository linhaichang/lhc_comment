package cn.haichang.comment.weforward.view;

import cn.haichang.comment.Comment;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;

import java.util.Date;

/**
 * @author HaiChang
 * @date 2020/10/25
 **/
@DocObject(description = "评论视图")
public class CommentView {
    protected Comment m_Comment;

    public CommentView(Comment comment) {
        this.m_Comment = comment;
    }

    public static CommentView valueOf(Comment comment){
        return null == comment ? null : new CommentView(comment);
    }
    
    @DocAttribute(description = "评论id")
    public String getId(){
        return m_Comment.getId().getOrdinal();
    }
    @DocAttribute(description = "评论人")
    public String getUser(){
        return m_Comment.getUserName();
    }

    @DocAttribute(description = "评论内容")
    public String getContent(){
        return m_Comment.getContent();
    }
    @DocAttribute(description = "评论创建时间")
    public Date getCreateTime(){
        return m_Comment.getCreatTime();
    }
    
    
}
