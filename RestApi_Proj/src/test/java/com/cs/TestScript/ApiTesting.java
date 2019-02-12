package com.cs.TestScript;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cs.ExcelRead.ExcelRead;
import com.cs.Restapi.WebServiceHandler;

import io.restassured.response.Response;

public class ApiTesting {
	@BeforeTest
	public void init_excelFile() {
		ExcelRead.loadExcelFileData("src//test//resources//dataFile//TestData.xlsx");

	}

	@Test
	public void test_Trade_Validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");

	}

	@Test
	public void test_Trade_Date_Validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		String actual_Message = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Status, "ERROR");
		Assert.assertEquals(actual_Message,"Value date 2019-01-28 cannot be null and it has to be after trade date 2019-08-30 ");

	}
	
	@Test
	public void test_value_date_cannot_fall_on_weekend_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		String actual_Message = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Status, "ERROR");
		Assert.assertEquals(actual_Message,"Value date [2019-02-10] cannot fall on Saturday/Sunday");

	}
	
	@Test
	public void test_supported_counterparties_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_unsupported_counterparties_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message,"Counterparty [AJIT] is not supported. Supported counterparties: [[PLUTO2, PLUTO1]]");
		

	}
	@Test
	public void test_only_one_legal_entity_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");

		

	}
	@Test
	public void test_invalid_legal_entity_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");

		

	}
	@Test
	public void test_valid_currencies_ISO_Code_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");

		

	}

	@Test
	public void test_inValid_currencies_ISO_Code_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message,"Invalid currency pair [AFADYU]");
		

	}
	
	@Test
	public void test_FORWARD_BUY_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_FORWARD_SELL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_SPOT_BUY_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_SPOT_SELL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_EUROPEAN_BUY_CALL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_EUROPEAN_SELL_CALL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_EUROPEAN_BUY_PUT_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_EUROPEAN_SELL_PUT_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}

	@Test
	public void test_OPTIONS_AMERICAN_BUY_CALL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_AMERICAN_SELL_CALL_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_AMERICAN_BUY_PUT_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_exerciseStartDate_tradeDAte_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message1="";
		try {
		 actual_Message1 = response.getBody().jsonPath().get("messages[0]");
		}
		catch(NullPointerException var ) {
			Assert.assertEquals(actual_Message1,"Exercise start date 2017-08-10 cannot be null and it has to be after trade date 2017-08-11 ");
		}
	}
		@Test
		public void test_OPTIONS_AMERICAN_SELL_PUT_exerciseStartDate_expiryDate_validation() throws Exception {
			WebServiceHandler.setBody("#Body");
			WebServiceHandler.setHeader("#Header1", "#Header2");
			WebServiceHandler.setEndPointUrl("#endPoint_Url");
			Response response = WebServiceHandler.postrestcalls();
			String actual_Status = response.getBody().jsonPath().get("status");
			Assert.assertEquals(actual_Status, "ERROR");
			String actual_Message1="";
			try {
			 actual_Message1 = response.getBody().jsonPath().get("messages[0]");
			}
			catch(NullPointerException var ) {
				Assert.assertEquals(actual_Message1,"Exercise start date 2017-08-22 cannot be null and it has to be after trade date 2017-08-21 ");
			}
	}
	
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_expiryDate_before_deliveryDate_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

	}
	
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_expiryDate_after_deliveryDate_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message1 = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message1,"Expiry date 2019-02-12 has to be before delivery date 2019-02-10 ");

		

	}
	
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_premiumDate_after_deliveryDate_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message1 = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message1,"Premium date 2019-02-12 has to be before delivery date 2019-02-10 ");

		

	}
	
	@Test
	public void test_OPTIONS_AMERICAN_SELL_PUT_premiumDate_before_deliveryDate_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "SUCCESS");
		

		

	}
	
	@Test
	public void test_Negative_OPTIONS_AMERICAN_SELL_PUT_without_exerciseStartDate_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		Integer actual_Status = response.getStatusCode();
		Assert.assertEquals(actual_Status, new Integer(400));
		

	}
	
	@Test
	public void test_InvalidStyle_OPTIONS_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message1 = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message1,"Invalid option style [ AMRICAN ]. Valid option styles are: [AMERICAN, EUROPEAN]");
	

	}
	
	@Test
	public void test_deliveryDate_OPTIONS_validation() throws Exception {
		WebServiceHandler.setBody("#Body");
		WebServiceHandler.setHeader("#Header1", "#Header2");
		WebServiceHandler.setEndPointUrl("#endPoint_Url");
		Response response = WebServiceHandler.postrestcalls();
		String actual_Status = response.getBody().jsonPath().get("status");
		Assert.assertEquals(actual_Status, "ERROR");
		String actual_Message1 = response.getBody().jsonPath().get("messages[0]");
		Assert.assertEquals(actual_Message1,"Expiry date 2019-02-11 has to be before delivery date 2019-02-08 ");
		String actual_Message2 = response.getBody().jsonPath().get("messages[1]");
		Assert.assertEquals(actual_Message2,"Premium date 2019-02-09 has to be before delivery date 2019-02-10 ");
	
	

	}



}
