package com.example.util;

import java.util.HashMap;

import com.example.data.CourseInfo;

public class GetShape {
	public static HashMap<String, Object> ItemShape(CourseInfo courseInfo,float avaveWidth,int avaveHeight){
		HashMap<String, Object> item=new HashMap<String, Object>();
		//������ĳ���
		int length;
		String a=courseInfo.getCourseTime().subSequence(0, 1).toString();
		String b=courseInfo.getCourseTime().subSequence(2, 3).toString();
		char e=courseInfo.getCourseTime().charAt(3);
		if(e>='0'&&e<='9'){
			b=b+e;
		}
		int c=Integer.parseInt(a);
		int d=Integer.parseInt(b);
		length=(d-c+1)*avaveHeight;
		item.put("length", length);
		//������ķ��ڵڼ���
		int temp=(courseInfo.getWeek()-1)*((int)avaveWidth-1);
		item.put("column", temp);
		item.put("row", (c-1)*avaveHeight);		
		return item;
	}
}
