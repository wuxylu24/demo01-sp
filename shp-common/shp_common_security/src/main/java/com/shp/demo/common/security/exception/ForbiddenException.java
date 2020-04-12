package com.shp.demo.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shp.demo.common.security.component.ShpAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = ShpAuth2ExceptionSerializer.class)
public class ForbiddenException extends ShpAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

