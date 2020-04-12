package com.shp.demo.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shp.demo.common.security.component.ShpAuth2ExceptionSerializer;


@JsonSerialize(using = ShpAuth2ExceptionSerializer.class)
public class InvalidException extends ShpAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
