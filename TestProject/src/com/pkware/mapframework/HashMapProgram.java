package com.pkware.mapframework;

import java.util.HashMap;
import java.util.Map;

public class HashMapProgram {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		
		hashMap.put(1, "one");
		hashMap.put(2, "two");
		hashMap.put(6, "six");
		hashMap.put(7, "seven");
		hashMap.put(8, "eight");
		hashMap.put(3, "three");
		hashMap.put(4, "four");
		hashMap.put(5, "five");
		
		System.out.println("Initial map - "+hashMap);
		
		//traversing map
		System.out.println("Traversing the map - ");
		for(Map.Entry<Integer, String> mp:hashMap.entrySet()) {
			System.out.println(mp.getKey()+" : "+mp.getValue());
		}
		
		//changing element
		hashMap.put(8, "eight Eight");
		System.out.println("After Changing - "+hashMap);
		
		//replace 
		hashMap.replace(5, "Five five");
		hashMap.replace(9,"Nine");
		System.out.println("After replace - "+hashMap);
		
		//removing elements
		hashMap.remove(8);
		hashMap.remove(7,"seven");
		System.out.println("After removing elements - "+hashMap);

		//contains key
		System.out.println("Hash map has key 8 - "+hashMap.containsKey(8));
		
		//contains value
		System.out.println("Hash map has value 'one' - "+hashMap.containsValue("one"));
	
		//keySet
		System.out.println("Map key set - "+hashMap.keySet());
		
		//values
		System.out.println("Values is map - "+hashMap.values());
		
		//size 
		System.out.println("Size of map - "+hashMap.size());
		
		//getOrDefault
		System.out.println("Value for key 8 - "+hashMap.getOrDefault(8, "Not Found"));
		System.out.println("Value for key 5 - "+hashMap.getOrDefault(5, "Not Found"));
		
		//putIfAbsent
		hashMap.putIfAbsent(9, "nine");
		hashMap.putIfAbsent(1, "two");
		System.out.println("Map - "+hashMap);
		
		//clear
		hashMap.clear();
		System.out.println("After clearing - "+hashMap);
	}

}