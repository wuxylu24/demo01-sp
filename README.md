Eureka -- Micro Service Center

Commom -- tool project

Admin -- main business code project

Auth -- authentication and authorization

Gateway -- gateway forwarding

Zuul -- resource control



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
