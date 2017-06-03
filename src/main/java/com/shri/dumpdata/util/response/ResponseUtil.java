package com.shri.dumpdata.util.response;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseUtil {

	@Autowired
	ObjectMapper objectMapper;

	public Response getSuccessResponse(String message, int code)
			throws JsonGenerationException, JsonMappingException, IOException {
		return getSuccessResponse(null, message, code);
	}

	public Response getSuccessResponse(Object object, String message, int code)
			throws JsonGenerationException, JsonMappingException, IOException {
		ResponseStatus status = new ResponseStatus(ResponseType.SUCCESS, code, message);
		ResponseEntity responseEntity = new ResponseEntity(object, status);
		String response = objectMapper.writeValueAsString(responseEntity);
		return Response.status(code).entity(response).build();
	}

	public Response getErrorResponse(String message, int code)
			throws JsonGenerationException, JsonMappingException, IOException {
		return getErrorResponse(null, message, code);
	}

	public Response getErrorResponse(Object object, String message, int code)
			throws JsonGenerationException, JsonMappingException, IOException {
		ResponseStatus status = new ResponseStatus(ResponseType.ERROR, code, message);
		ResponseEntity responseEntity = new ResponseEntity(null, status);
		String response = objectMapper.writeValueAsString(responseEntity);
		return Response.status(code).entity(response).build();
	}

}
