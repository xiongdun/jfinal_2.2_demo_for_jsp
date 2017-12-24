package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成行程编号
 * @author yourname
 *
 */
public class TravelUtil {
	
	public static final String TRAVEL_KEY = "T";
	
	public static String generateTravelNo(String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return TRAVEL_KEY + sdf.format(new Date()) + id;
	}
	public static String generateTravelNo(Long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return TRAVEL_KEY + sdf.format(new Date()) + id;
	}
}
