package com.util;

/**
 * 格式化分页
 * @author yourname
 *
 */
public class PageUtil {
	public static int toPage(int page) {
		if (page == 0) {
			page = 1;
		}
		return page;
	}

	public static int toCount(int count) {
		if (count == 0) {
			count = 10;
		}
		return count;
	}

}
