package cn.work.MapKeyLowercase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapKey2Lowercase {


	/**
	 * 将Map中key值转换成小写
	 * @author lwm
	 *
	 */
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("CATEGORY", "merchant");
		map.put("categoryID", "8380101");
		System.out.println(map);
//		Map map1=mapKey2Lowercase(map);
		Map map2=mapKey3Lowercase(map);
		if(map2.containsKey("category")){
			System.out.println(map2+"=="+map);
		}
	}
	public static Map mapKey3Lowercase(Map mapV) {
		Map map=new HashMap();
		Set keyset=mapV.keySet();
		for (Iterator iterator = keyset.iterator(); iterator.hasNext();) {
			Object key = (Object) iterator.next();
			Object svalue=mapV.get(key);
			Object skey=key.toString().toLowerCase();
			System.out.println(skey+"==="+svalue);
			if(skey!=null&&svalue!=null){
				map.put(skey, svalue);
			}
		}
		return map;
	}
	public static Map mapKey2Lowercase(Map mapV) {
		Map map = new HashMap();
		Map.Entry entry = null;
		Object key = null;
		Object value = null;
		String keyStr = null;
        for(Iterator it = mapV.entrySet().iterator(); it.hasNext();) {		
        	entry = (Map.Entry) it.next();
        	key = entry.getKey();
        	keyStr = key.toString().toLowerCase();
        	value = entry.getValue();
        	map.put(keyStr, value);
        }
		return map;
	}
	

}
