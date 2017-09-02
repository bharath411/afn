package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandle {

	
	
	public List<List<String>> getData(){
		
		List<String> l1 = new ArrayList<String>();
		l1.add("username1");
		l1.add("password1");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("username2");
		l2.add("password2");
		
		List<String> l3 = new ArrayList<String>();
		l3.add("username3");
		l3.add("password3");;
		
		List<String> l4 = new ArrayList<String>();
		l4.add("username4");
		l4.add("password4");
		
		List<String> l5 = new ArrayList<String>();
		l5.add("username5");
		l5.add("password5");
		
		List<List<String>> li = new ArrayList<List<String>>();
		li.add(l1);
		li.add(l2);
		li.add(l3);
		li.add(l4);
		li.add(l5);
		return li;
	}
	
	
	
	public Map<Integer,List<String>> getMapData(){
		Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
		
		List<String> l1 = new ArrayList<String>();
		l1.add("username1");
		l1.add("password1");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("username2");
		l2.add("password2");
		
		List<String> l3 = new ArrayList<String>();
		l3.add("username3");
		l3.add("password3");;
		
		List<String> l4 = new ArrayList<String>();
		l4.add("username4");
		l4.add("password4");
		
		List<String> l5 = new ArrayList<String>();
		l5.add("username5");
		l5.add("password5");
		
		map.put(0, l1);
		map.put(1, l2);
		map.put(2, l3);
		
		
		return map;
	}
	
	public Map<Integer,Map<Integer,String>> getData1(){
		Map<Integer,Map<Integer,String>> map = new HashMap<Integer,Map<Integer,String>>();
		
		
		return map;
	}
}
