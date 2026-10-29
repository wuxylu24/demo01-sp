Nacos -- Service registry (standalone server, started by docker-compose)

Commom -- tool project

Admin -- main business code project

Auth -- authentication and authorization

Gateway -- gateway forwarding

Zuul -- resource control

## Docker 部署

一键启动 MySQL、Redis、Nacos 以及 auth / admin / gateway / zuul 四个服务（镜像在 Docker 内用 JDK 8 + Maven 编译，无需本地构建）：

```bash
docker compose up -d --build
```

| 服务 | 地址 |
|---|---|
| Nacos 控制台 | http://localhost:8848/nacos |
| shp-auth | http://localhost:8000 |
| shp-admin | http://localhost:8001 |
| shp-gateway | http://localhost:8002 （`/api/auth/**`、`/api/admin/**`） |
| shp-zuul | http://localhost:8080 |

MySQL 首次启动时自动导入 `doc/db/shp.sql`。单独构建某个服务镜像：`docker build --build-arg MODULE=shp_auth -t shp-auth .`



Simple microservice project: applying spring boot spring cloud security auth gateway

Simple integrated user API

role

First, distinguish the roles in OAuth 2.0:

Client: client, that is, third-party application

Service: the server, which is the service provider

User: user, that is, resource owner - resource owner

User agent: a user agent, such as a browser, which will be considered in combination with the client later.

Authorization server: authentication server, that is, the server used by the service provider to handle authentication.

Resource server: resource server, that is, the server where the service provider stores the user generated resources.

Authorization mode of client

Client must

The user's authorization grant is required to obtain the access token. OAuth 2.0 defines four authorization methods.

Authorization code mode

Simplify mode

Resource owner password credentials

Client credentials



Authorization server authorization service interface introduction

/OAuth / authorize: authentication interface, authorizationendpoint

/OAuth / token: get token

/OAuth / confirm_access: user authorization

/OAuth / error: authentication failed

/OAuth / check_token: used by resource server to verify token

/OAuth / token_key: obtain the public key in JWT mode; located in: tokenkeyendpoint, access the key through jwtaccesstokenconverter



JWT – Json Web Token,

Protocol for saving web token in JSON mode
