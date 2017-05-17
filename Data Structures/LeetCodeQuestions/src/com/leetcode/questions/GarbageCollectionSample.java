package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class GarbageCollectionSample {
	 
	   static class Key {
	      Integer id;
	 
	      Key(Integer id) {
	         this.id = id;
	      }
	 
	      @Override
	      public int hashCode() {
	         return id.hashCode();
	      }
	      
	      @Override
	      public boolean equals(Object o) {
	         boolean response = false;
	         if (o instanceof Key) {
	            response = (((Key)o).id).equals(this.id);
	         }
	         return response;
	      }
	   }
	 
	   public static void main(String[] args) {
	      Map m = System.getProperties();
//	      while (true)
//	      {
//	         for (int i = 0; i < 10000; i++){
//	            if (!m.containsKey(new Key(i)))
//	               m.put(new Key(i), "Number:" + i);
//	         }
//	         
//	        System.out.println(m.size());
//	      	System.out.println("finished 1000 loops");
//	      }
//	      }
	      
	      
	      
	      Random random = new Random();
	      while(true)
	    	  m.put(random.nextInt(), "value");
	}
}
