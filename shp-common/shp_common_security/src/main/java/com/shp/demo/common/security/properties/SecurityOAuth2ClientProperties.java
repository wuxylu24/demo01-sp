package com.shp.demo.common.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "security.oauth2.client")
public class SecurityOAuth2ClientProperties {

    private String clientId;

    private String clientSecret;
}
