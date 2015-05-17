package com.im.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* CopyRright (c)2013:		InstantMessage                          
* Project:					InstantMessageServer                                          
* Module ID:				3    
* Comments:  				获取当前格式化时间                     
* JDK version used:			JDK 1.7                              
* NameSpace:				com.im.server.utils                         
* Author：					Ellery                 
* Create Date：				2013-05-16 23:41
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:					0.1                       
*/ 

public class DateUtils {

	public static String getCuttentTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		String currentTime = simpleDateFormat.format(new Date());
		return currentTime;
	}
}
