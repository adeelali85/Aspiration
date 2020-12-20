package com.api.rest;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
;
 
public class GetCall {
 
	public static void getCall() {
	 
	
	// sending request and we are passing parameter in url itself
	String restURL_JSON = "https://jsonplaceholder.typicode.com/posts";
	 
	try {testStatusCode(restURL_JSON);} 
	catch (ClientProtocolException e) {e.printStackTrace();} 
	catch (IOException e) {e.printStackTrace();} 
	catch (JSONException e) {e.printStackTrace();}}
 
		public static void testStatusCode(String restURL) throws ClientProtocolException, IOException {
		 
		HttpUriRequest request = new HttpGet(restURL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
		
		// Convert the response to a String format
		String result = EntityUtils.toString(httpResponse.getEntity());
		JSONArray jArray = new JSONArray(result.trim());
		
		parseJsonData (jArray);
		
	}
 
		
		private static void parseJsonData(JSONArray jsonArray){
	        try
	        {
	            for(int i=0;i<jsonArray.length();i++)
	            {
	                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
	                String value1 = jsonObject1.optString("userId");
	                String value2 = jsonObject1.optString("id");
	                String value3 = jsonObject1.optString("title");
	                String value4 = jsonObject1.optString("body");
	                
	                if (value1.equals("1") && value2.equals("2") ) {
	                	System.out.println("title : " +value3+ "\n" + "body :" +value4);
	                	System.out.println("Print record (title,body) for userid=1, id =2 ...TestCase 2 Passed");
	                	break;}
	                
	            }
	        }
	        catch (JSONException e){e.printStackTrace();}
	    }
 
}