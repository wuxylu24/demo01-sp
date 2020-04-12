package com.shp.demo.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shp.demo.common.security.component.ShpAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;


@JsonSerialize(using = ShpAuth2ExceptionSerializer.class)
public class MethodNotAllowed extends ShpAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
