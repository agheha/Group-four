package g4.mini.reservation.dao;

import java.util.HashMap;

import g4.mini.ui.BaseUI;
import net.nurigo.java_sdk.api.Message;


public class SendMessage extends BaseUI{

	public static String PHNo = null;
	public static String msg = null;
	
	
	public void service() {
		
		String api_key = "NCS0IT0FTWU8DUJY";
	    String api_secret = "7LWCWOABDRATZ9KOKWGZHIIRJBDJCEFE";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    
	    
	    params.put("to",  PHNo);
	    params.put("from", "01011111111");
	    params.put("type", "SMS");
	    params.put("text",  msg);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	    	System.out.println(params);
//	      JSONObject obj = (JSONObject) coolsms.send(params);
//	      System.out.println(obj.toString());
	    } catch (Exception e) {
//	      System.out.println(e.getMessage());
//	      System.out.println(e.getCode());
	    }
	}

	
	
}