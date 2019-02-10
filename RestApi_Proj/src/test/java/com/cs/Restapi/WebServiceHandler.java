package com.cs.Restapi;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.ExcelRead.DataSourceDecider;


public class WebServiceHandler {
	
	
	static String bodyOfApi;
	static String endPointUrl;
	static Map<String, String> headers;
	
	public static void setBody(String body) throws Exception {
		bodyOfApi =DataSourceDecider.dataFinder(body); 
	}

	public static void setHeader(String... header) throws Exception {
		List<String> headerList= new ArrayList<String>();
		for (int i=0;i<header.length;i++) {
			headerList.add(DataSourceDecider.dataFinder(header[i]));
		 }
		
		headers = new HashMap<String, String>();
		headerList.stream().map(elem -> elem.split(",")).forEach(elem -> headers.put(elem[0], elem[1]));
			
	
	}

	public static void setEndPointUrl(String endPoint) throws Exception {
		
		endPointUrl =DataSourceDecider.dataFinder(endPoint);
		
	}
	public static Response postrestcalls(){
	RestAssured.useRelaxedHTTPSValidation();	
	Response response=given().
	auth().none().body(bodyOfApi).headers(headers).
	when().post(endPointUrl).
	then().extract().response();


	//JsonPath jsonPathEvaluator=response.jsonPath();
	//String onemore=jsonPathEvaluator.getString("PromoSearchResponse.PromoSearchResult.PromoSearchResultItem.PromoStartDate");
	//System.out.print(onemore);
	response.prettyPrint();

	return response;

	}

	public static String getExpectedResponseBody() throws Exception {
		// TODO Auto-generated method stub
		return DataSourceDecider.dataFinder("#Expected Response");
	}







}



