package com.algorithm.diy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReadFileSortAndPrint {
	public static void sortURL() {
		String fileIn = "C:/Users/lenovo/Desktop/CV/test.txt";
		String fileOut = "C:/Users/lenovo/Desktop/CV/out.txt";
		HashMap<String,Integer> map = new HashMap<>();
		try (InputStreamReader ir = new InputStreamReader(new FileInputStream(fileIn), StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(ir);
				) {
			String line = null;
			while((line = br.readLine()) != null){
				if(map.containsKey(line)){
					map.put(line, map.get(line) + 1);
				}else{
					map.put(line, 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		List<Entry<String,Integer>> list = mapSort(map);
//		PrintStream ps = new PrintStream(new FileOutputStream(fileOut));
		try(FileOutputStream fos = new FileOutputStream(fileOut);) {
			for (int i = 0; i < list.size(); i++) {
				String result =  list.get(i).getKey() + "\n" + list.get(i).getValue() + "\n";
				fos.write(result.getBytes());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	private static List mapSort(HashMap map){
		
		List<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Entry<String, Integer>>() {    
            @Override    
            public int compare(Entry<String, Integer> arg0,    
                    Entry<String, Integer> arg1) {    
                return arg1.getValue()- arg0.getValue();
            }    
        });    
		return list;
	}
	
	
	public static void main(String[] args) {
		sortURL();
	}
	
}
