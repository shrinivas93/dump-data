package com.shri.dumpdata.exception.mapper;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.shri.dumpdata.util.response.ResponseEntity;
import com.shri.dumpdata.util.response.ResponseStatus;
import com.shri.dumpdata.util.response.ResponseType;
import com.shri.dumpdata.util.response.ResponseUtil;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Autowired
	private ResponseUtil responseUtil;

	@Override
	public Response toResponse(WebApplicationException exception) {
		String message = exception.getMessage();
		int code = exception.getResponse().getStatus();
		try {
			return responseUtil.getErrorResponse(message, code);
		} catch (IOException e) {
			ResponseStatus status = new ResponseStatus(ResponseType.ERROR, code, message);
			ResponseEntity responseEntity = new ResponseEntity(null, status);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(responseEntity).build();
		}
	}

}
