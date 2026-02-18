package com.interview.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static final ThreadLocal<SimpleDateFormat> simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		public SimpleDateFormat initialValue() {
			System.out.println("Creating SimpleDateFormat Instance for: "+Thread.currentThread().getName());
			return new SimpleDateFormat("dd/MM/yyyy");
		}
	};
	
	public static String getDate(String format) {
		return simpleDateFormat.get().format(new Date());
	}
}
