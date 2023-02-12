package com.pkware.mapframework;
import java.util.TreeMap;

public class TreeMapProgram {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		
		treeMap.put("one",1);
		treeMap.put("two",2);
		treeMap.put("six",6);
		treeMap.put("seven",7);
		treeMap.put("eight",8);
		treeMap.put("three",3);
		treeMap.put("four",4);
		treeMap.put("five",5);
		
		System.out.println("Initial map - "+treeMap);
		
		//containsKey
		System.out.println("Map has key 'one' - "+treeMap.containsKey("one"));
		
		//containsValue
		System.out.println("Map has value 5 - "+treeMap.containsValue(5));
		
		//firstKey
		System.out.println("First key in map - "+treeMap.firstKey());
		
		//lastKey
		System.out.println("Last key in map - "+treeMap.lastKey());
		
		//keySet
		System.out.println("Keys in map - "+treeMap.keySet());
		
		//values
		System.out.println("Values in map - "+treeMap.values());
		
		//headMap
		System.out.println("Map entries less than key value 'four' - "+treeMap.headMap("four"));
		
		//subMap
		System.out.println("Sub Map from key five to three- "+treeMap.subMap("five", "three"));
		
		//size
		System.out.println("Size of map - "+treeMap.size());
		
		//clear
		treeMap.clear();
		System.out.println("After clearing - "+treeMap);
	}

}
