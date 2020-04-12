package com.shp.demo.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shp.demo.common.security.component.ShpAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = ShpAuth2ExceptionSerializer.class)
public class ServerErrorException extends ShpAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
