package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	public String ConvertObjectToJson(Object obj){
		String Json=null;
		try {
			ObjectMapper om=new ObjectMapper();
			Json=om.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Json;
	}
	
	public Object  ConvertJsonToObject(String json,Class<?>  clz){
		Object ob=null;
		try {
			ObjectMapper om=new ObjectMapper();
			ob=om.readValue(json,clz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	
}
