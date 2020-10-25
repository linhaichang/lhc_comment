package cn.haichang.comment.weforward;

import cn.haichang.comment.Comment;
import cn.haichang.comment.CommentService;
import cn.haichang.comment.impl.CommentImpl;
import cn.haichang.comment.weforward.view.CommentView;
import cn.weforward.common.ResultPage;
import cn.weforward.framework.ApiException;
import cn.weforward.framework.WeforwardMethod;
import cn.weforward.framework.WeforwardMethods;
import cn.weforward.framework.doc.DocMethods;
import cn.weforward.framework.util.ValidateUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocMethod;
import cn.weforward.protocol.doc.annotation.DocParameter;
import cn.weforward.protocol.support.datatype.FriendlyObject;

import javax.annotation.Resource;

/**
 * @author HaiChang
 * @date 2020/10/25
 **/
@DocMethods(index = 100)
@WeforwardMethods
public class CommentMethods {
    @Resource
    CommentService m_CommentService;

    @WeforwardMethod
    @DocMethod(description = "创建评论", index = 0)
    @DocParameter({
            @DocAttribute(name = "accessId",type = String.class,necessary = true,description = "接入评论的id"),
            @DocAttribute(name = "content",type = String.class,necessary = true,description = "评论内容")
    })
    public CommentView createComment(FriendlyObject params) throws ApiException {
        String accessId = params.getString("accessId");
        String content = params.getString("content");
        ValidateUtil.isEmpty(accessId,"接入对象id不可为空");
        ValidateUtil.isEmpty(content,"评论内容不可为空");
        Comment comment = m_CommentService.createComment(accessId, content);
        return CommentView.valueOf(comment);
    }


    @DocMethod(description = "获取接入对象的所有评论")
    @DocParameter(@DocAttribute(name = "accessId",type = String.class,necessary = true,description = "需要添加评论的目标对象id"))
    @WeforwardMethod
    public ResultPage<CommentImpl> getComments(FriendlyObject params) throws ApiException {
        String accessId = params.getString("accessId");
        ValidateUtil.isEmpty(accessId,"接入对象id不可为空");
        return m_CommentService.getComments(accessId);
    }
}
