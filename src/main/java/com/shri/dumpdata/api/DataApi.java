package com.shri.dumpdata.api;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shri.dumpdata.document.Data;
import com.shri.dumpdata.document.Data.DataBuilder;
import com.shri.dumpdata.service.DataService;
import com.shri.dumpdata.util.response.ResponseUtil;

@Component
@Path("data")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class DataApi {

	@Autowired
	private ResponseUtil responseUtil;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private DataService dataService;

	@POST
	public Response addData(String dataStr) throws JsonGenerationException, JsonMappingException, IOException {
		Object dataObject = objectMapper.readValue(dataStr, Object.class);
		Data data = DataBuilder.build(dataObject);
		return responseUtil.getSuccessResponse(dataService.addData(data), "Data added successfully",
				Status.OK.getStatusCode());
	}

}
