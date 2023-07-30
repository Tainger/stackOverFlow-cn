package com.knowns.rss.generator.utils;

/**
 * 常量，用于激活代码
 * @author rocky
 */
public interface StackOverFlowConstant {

    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 重复激活
     */
    int ACTIVATION_REPEAT = 1;
    /**
     * 激活失败
     */
    int ACTIVATION_FAILURE = 2;

    /**
     * 默认状态的登陆凭证    //半天 单位秒。
     */
    int DEFAULT_EXPIRED_SESSION = 3600 * 12;

    /**
     * 记住状态的登陆凭证的超时时间 //100天  单位秒
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;

    /**
     *实体类型  帖子
     */
    int  ENTITY_TYPE_POST = 1;

    /**
     * 实体类型  评论
     */
    int ENTITY_TYPE_COMMENT=2;
    /**
     * user
     */
    int ENTITY_TYPE_USER=3;

    /**
     * 主题：评论
     */
    String TOPIC_COMMENT="comment";

    /**
     * 主题：点赞
     */
    String TOPIC_LIKE="like";

    /**
     * 主题：关注
     */

    String TOPIC_FOLLOW="follow";


    String TOPIC_PUBLISH="publish";
    /**
     * 系统的id
     */
    int SystemFromId = 1;
}
