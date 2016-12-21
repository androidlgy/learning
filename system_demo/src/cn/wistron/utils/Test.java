package cn.wistron.utils;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String s = "22,2016-04-11,14,true;22,2016-04-11,14,true";
		String[] ss = sz1(s);
		String[][] array = new String[ss.length][];
		for (int i = 0; i < array.length; i++) {
			array[i] = sz2(ss[i]);
			
		}for(int i=0;i<array.length;i++){
		System.out.println(Arrays.toString(array[i]));
	}
	}
	public static String[] sz1(String s){
		return s.split(";") ;
	}
	public static String[] sz2(String s){
		String[] ss = s.split(",");
		String[] ii = new String[ss.length];
		for (int i = 0; i < ss.length; i++) {
			ii[i] = ss[i];
		}
		return ii;
	}
}