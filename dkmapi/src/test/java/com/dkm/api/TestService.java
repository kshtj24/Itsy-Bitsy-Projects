package com.dkm.api;

import javax.ws.rs.Produces;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/test_service")
public class TestService {

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public JSONArray getUsers() {
//
//		DBHelper.connectDB();
//		return DBHelper.getData();
//
//	}

	 @GET
	 @Produces(MediaType.TEXT_HTML)
	 public String test() {
	 return "Something";
	 }
}
