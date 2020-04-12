package com.shp.demo.common.security.properties;

import lombok.Getter;
import lombok.Setter;
import com.shp.demo.common.base.constants.GlobalsConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = GlobalsConstants.SHP_OAUTH_PREFIX)
public class ShpSecurityProperties {

    WebProperties web = new WebProperties();

    OAuth2Properties oauth2 = new OAuth2Properties();

}
