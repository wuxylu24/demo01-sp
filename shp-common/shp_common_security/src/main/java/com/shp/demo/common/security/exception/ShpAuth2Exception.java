package com.shp.demo.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shp.demo.common.security.component.ShpAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = ShpAuth2ExceptionSerializer.class)
public class ShpAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public ShpAuth2Exception(String msg) {
		super(msg);
	}

	public ShpAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
