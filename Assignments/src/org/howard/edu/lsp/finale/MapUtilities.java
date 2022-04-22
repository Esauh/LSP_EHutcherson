package org.howard.edu.lsp.finale;

import java.util.HashMap;
import java.util.Map;

import org.howard.edu.lsp.assignment6.integerset.ListEmptyException;

public class MapUtilities {
	
	public static int commonKeyValuePairs(HashMap<String, String> map1,HashMap<String, String> map2)throws NullMapException {
    	int result = 0;
        if (map1 == null || map2 == null) {
     	   NullMapException e= new NullMapException("One or both maps are null!");
     	   throw e;
        }
        if (map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }
        
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(map2.containsKey(key)){
                if(map2.get(key).equals(value)){
                    result++;
                }
            }
        }
return result;
    }
    
  }
    

