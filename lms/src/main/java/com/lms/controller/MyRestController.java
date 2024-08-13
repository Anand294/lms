package com.lms.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.common.Faces;
import com.lms.common.Master;
import org.json.simple.JSONObject;

@RestController
public class MyRestController {
 @Autowired
	private Faces faces;


	@GetMapping("/home")
    public ArrayList<Master>  getString() {
		
		ArrayList<Master> list =faces.getString();
		
        return list;
    }
	
	@GetMapping("/index")
	public HashMap<Integer, String> postMethodName() {
		//TODO: process POST request
		System.out.println("Anand");
		HashMap<Integer, String> hMap=new HashMap<Integer,String>();
		for (int i=0;i<=9;i++) {
			   Master masters=new Master();
			   masters.setId(i);
			   masters.setName(i+"-name");
			  
			   hMap.put(masters.getId(), masters.getName());
			  
		   }
		  
			
		return hMap;
	}
	@GetMapping("/getObj")
	public JSONObject getObject(){
		JSONObject jsonObj= new JSONObject();
		jsonObj.put("isSuccess", true);
		jsonObj.put("id", 5);
		return jsonObj;
	}
	
	
	
}

