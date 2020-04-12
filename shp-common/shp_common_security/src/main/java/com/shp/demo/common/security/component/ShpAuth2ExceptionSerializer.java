package com.shp.demo.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.shp.demo.common.security.exception.ShpAuth2Exception;
import lombok.SneakyThrows;
import com.shp.demo.common.base.constants.GlobalsConstants;

public class ShpAuth2ExceptionSerializer extends StdSerializer<ShpAuth2Exception> {


	public ShpAuth2ExceptionSerializer() {
		super(ShpAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(ShpAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", GlobalsConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
