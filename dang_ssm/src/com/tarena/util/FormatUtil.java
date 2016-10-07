package com.tarena.util;

import java.util.List;

public class FormatUtil {
	public static String formatPrice(double price){
		String str=price+"";//180.0
		String s=str.substring(str.indexOf(".")+1);//0
		if(s.length()==1){
			return str+"0";//"180.00"
		}		
		return str;
	}
	
	public static String formatIds(List<Integer> subIds) {
		StringBuffer sb=new StringBuffer();
		int len=subIds.size();
		for(int i=0;i<len;i++){
			if(i==len-1){
				sb.append("?");
			}else{
				sb.append("?,");
			}
		}
		String ids=sb.toString();
		return ids;
	}
}
