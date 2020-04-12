package com.shp.demo.common.base.constants;

/**
 */
public interface GlobalsConstants {

    /**
     * jwt对称加密
     * */
    String OAUTH_SIGNING_KEY = "shp_demo_oauth_key";

    String OAUTH_AUTH_FORM_URI = "/authentication/form";

    String OAUTH_AUTH_REQUIRE_URI = "/authentication/require";

    /**
     * 登录页面
     */
     String LOGIN_PAGE_URI = "/index.html";


    /**
     * Redis Cache
     */
     String REDIS_USER_CACHE = "RedisUserCache";

    /**
     * Redis Cache
     */
    String REDIS_CLIENT_CACHE = "RedisClientCache";

    /**
     * 缓存中user的key
     */
    String USER_KEY_PREFIX = "spd_demo_User_";

    /**
     * oauth 客户端信息
     */
     String CLIENT_DETAILS_KEY =  "spd_demo_Client_";

    /**
     * Redis默认过期时长，单位：秒  5分钟
     */
     long DEFAULT_EXPIRE = 60 * 5;

    /**
     * Redis 不设置过期时长
     */
     long NOT_EXPIRE = -1;

    /**
     * Redis set 前缀
     */
   String KEY_SET_PREFIX = "_set:";

    /**
     * Redis list 前缀
     */
    String KEY_LIST_PREFIX = "_list:";

    /**
     * ip
     */
     String UNKNOWN = "unknown";

    /**
     * druid配置
     */
     String DB_PREFIX = "spring.datasource";

    /**
     * security配置
     */
    String SHP_OAUTH_PREFIX = "shp.security";
    /**
     * oauth security配置
     */
     String OAUTH_SECURITY_PREFIX = "security.oauth2.client";

    /**
     * security  过滤url 配置
     */
    String FILTER_IGNORE = "ignore";

    /**
     * security  过滤url 配置
     */
    String SHP_RESOURCE_IDS = "shp.resource";

    /**
     * 成功标记
     */
     Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 前缀
     */
     String PROJECT_PREFIX = "shp_";

    /**
     * oauth 相关前缀
     */
     String  OAUTH_PREFIX = "oauth:";

    String CURRENT = "current";

     String SIZE = "size";

}
