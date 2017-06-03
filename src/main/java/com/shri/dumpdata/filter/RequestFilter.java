package com.shri.dumpdata.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext containerRequest) throws IOException {
	}

}
