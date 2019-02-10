package com.cs.TestScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cs.ExcelRead.ExcelRead;
import com.cs.Restapi.WebServiceHandler;
import io.restassured.response.Response;

public class BatchApiTesting {
	@BeforeTest
	public void init_excelFile() {
		ExcelRead.loadExcelFileData("src//test//resources//dataFile//TestData.xlsx");

	}

	@Test(groups= {"Positive"},description = "validating the batch trading i.e. spot,forward and options in same post calls")
	public void test_Valid_Batch_testing() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		List<String> actual_Status = response.getBody().jsonPath().getList("status");
		List<String> expected_Status=new ArrayList<String>();
		expected_Status.add("SUCCESS");
		expected_Status.add("SUCCESS");
		expected_Status.add("SUCCESS");
		Assert.assertEquals(actual_Status,expected_Status );
		

	}
	@Test(groups= {"Negative"},description = "batch trading i.e. spot,forward and options in same post calls with invalid data")
	public void test_inValid_message_Batch_testing() throws Exception {
		List<String> expected_Status=new ArrayList<String>();
		String expected_message=WebServiceHandler.getExpectedResponseBody();
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		List<String> actual_Status = response.getBody().jsonPath().getList("status");
		expected_Status.add("ERROR");
		expected_Status.add("SUCCESS");
		expected_Status.add("ERROR");
		Assert.assertEquals(actual_Status,expected_Status );
		String actual_response=response.getBody().asString();
		Assert.assertEquals(actual_response,expected_message );
		

	}
}
