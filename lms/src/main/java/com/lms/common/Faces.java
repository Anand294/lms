package com.lms.common;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class Faces {
	
	public ArrayList<Master> getString()
	{ArrayList<Master> list=new ArrayList<Master>();
	try {
	   for (int i=0;i<=9;i++) {
		   Master masters=new Master();
		   masters.setId(i);
		   masters.setName(i+"-name");
		  
		   list.add(masters);
		 
	   }
	}
	   catch(Exception ex) {
		   System.out.println("Anand");  
	   }
	  
		return list;
	}
}
