简单的微服务项目:应用spring boot spring cloud security auth gateway 
简单的集成用户 api

角色
先区分下OAuth 2.0 中有哪些角色:
Client: 客户端,也就是Third-party application - 第三方应用程序
Service：服务端,也就是服务的提供者
User： 用户,也就是Resource Owner - 资源所有者
User Agent：用户代理,如浏览器，下文中将其与Client合并考虑。
Authorization Server：认证服务器,即服务提供商专门用来处理认证的服务器。
Resource Server：资源服务器,即服务提供商存放用户生成的资源的服务器。

客户端的授权模式
客户端必
须得到用户的授权（authorization grant），才能获得令牌（access token）。OAuth 2.0定义了四种授权方式。
授权码模式（authorization code）
简化模式（implicit）
密码模式（resource owner password credentials）
客户端模式（client credentials）

AuthorizationServer 授权服务接口介绍
/oauth/authorize：验证接口， AuthorizationEndpoint
/oauth/token：获取token
/oauth/confirm_access：用户授权
/oauth/error：认证失败
/oauth/check_token：资源服务器用来校验token
/oauth/token_key：jwt模式下获取公钥；位于：TokenKeyEndpoint ，通过 JwtAccessTokenConverter 访问key

JWT – Json Web Token, 
使用Json方式保存Web Token的协议 

eureka --微服务中心
commom --工具项目
admin --主要业务代码项目
auth -- 认证授权
gateway --网关转发
zuul --资源控制

