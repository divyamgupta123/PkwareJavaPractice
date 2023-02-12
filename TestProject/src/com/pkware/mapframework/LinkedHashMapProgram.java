package com.pkware.mapframework;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapProgram {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lkdHashMap = new LinkedHashMap<>();
		
//		LinkedHashMap<Integer, String> lkdHashMap = new LinkedHashMap<>() {
//			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest)
//            {
//                return size() > MAX;
//            }
//		};
		
		lkdHashMap.put(1, "one");
		lkdHashMap.put(2, "two");
		lkdHashMap.put(6, "six");
		lkdHashMap.put(7, "seven");
		lkdHashMap.put(8, "eight");
		lkdHashMap.put(3, "three");
		lkdHashMap.put(4, "four");
		lkdHashMap.put(5, "five");
		
		System.out.println("Initial map - "+lkdHashMap);
		
		//traversing map
		System.out.println("Traversing the map - ");
		for(Map.Entry<Integer, String> mp:lkdHashMap.entrySet()) {
			System.out.println(mp.getKey()+" : "+mp.getValue());
		}
		
		//changing element
		lkdHashMap.put(8, "eight Eight");
		System.out.println("After Changing - "+lkdHashMap);
		
		//replace 
		lkdHashMap.replace(5, "Five five");
		lkdHashMap.replace(9,"Nine");
		System.out.println("After replace - "+lkdHashMap);
		
		//removing elements
		lkdHashMap.remove(8);
		lkdHashMap.remove(7,"seven");
		System.out.println("After removing elements - "+lkdHashMap);

		//contains key
		System.out.println("Hash map has key 8 - "+lkdHashMap.containsKey(8));
		
		//contains value
		System.out.println("Hash map has value 'one' - "+lkdHashMap.containsValue("one"));
	
		//keySet
		System.out.println("Map key set - "+lkdHashMap.keySet());
		
		//values
		System.out.println("Values is map - "+lkdHashMap.values());
		
		//size 
		System.out.println("Size of map - "+lkdHashMap.size());
		
		//getOrDefault
		System.out.println("Value for key 8 - "+lkdHashMap.getOrDefault(8, "Not Found"));
		System.out.println("Value for key 5 - "+lkdHashMap.getOrDefault(5, "Not Found"));
		
		//putIfAbsent
		lkdHashMap.putIfAbsent(9, "nine");
		lkdHashMap.putIfAbsent(1, "two");
		System.out.println("Map - "+lkdHashMap);
		
		//clear
		lkdHashMap.clear();
		System.out.println("After clearing - "+lkdHashMap);
	}

}
