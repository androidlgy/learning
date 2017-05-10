package cn.wistron.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
 

public class MyJsonUtils {
	
	public void readjsonList(String jsonstr){
	    try {
	    	ObjectMapper objectMapper = new ObjectMapper();
	        List<LinkedHashMap<String, Object>> list = objectMapper.readValue(jsonstr, List.class);

	        System.out.println(list.size());

	        for (int i = 0; i < list.size(); i++) {

	            Map<String, Object> map = list.get(i);

	            Set<String> set = map.keySet();

	            for (Iterator<String> it = set.iterator();it.hasNext();) {

	                String key = it.next();

	                System.out.println(key + ":" + map.get(key));

	            }

	        }

	    }catch (IOException e) {

	        e.printStackTrace();

	    }
		
	}
	

}
