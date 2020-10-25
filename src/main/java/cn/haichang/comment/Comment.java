package cn.haichang.comment;

import cn.weforward.data.UniteId;

import java.util.Date;

/**
 * 评论
 * @author HaiChang
 * @date 2020/10/25
 **/
public interface Comment {
    UniteId getId();


    /**
     * 获取评论内容
     * @return
     */
    String getContent();
    
    /**
     * 获取创建日期
     * @return
     */
    Date getCreatTime();

    /**
     * 获取评论人
     * @return
     */
    String getUserName();



}
