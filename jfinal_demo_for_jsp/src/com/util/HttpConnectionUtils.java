package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpConnectionUtils {


	public static String doPost(String message, String strURL,String contentType) throws Exception {
		URL url = null;
		HttpURLConnection con = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		try {
			url = new URL(strURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setUseCaches(false);// 不使用缓存
			con.setDoInput(true);// 允许输入
			con.setDoOutput(true);// 允许输出
			// con.setConnectTimeout(5000);
			// con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type", contentType);
			con.connect();
			out = new BufferedWriter(new OutputStreamWriter(
					con.getOutputStream(), "UTF-8"));
			out.write(message);
			out.flush();

			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
				"UTF-8"));
			String line = in.readLine();
			String result=line;
			while (line != null) {
				line = in.readLine();
				if(line!=null)
				result+=line;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			if (con != null)
				con.disconnect();
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}
	
	public static String doGet(String strURL,String contentType) throws Exception {
		URL url = null;
		HttpURLConnection con = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		try {
			url = new URL(strURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setUseCaches(false);// 不使用缓存
			con.setDoInput(true);// 允许输入
			// con.setConnectTimeout(5000);
			// con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type",contentType);
			con.connect();
			in = new BufferedReader(new InputStreamReader(con.getInputStream(),
				"UTF-8"));
			String line = in.readLine();
			String result=line;
			while (line != null) {
				line = in.readLine();
				if(line!=null)
				result+=line;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			if (con != null)
				con.disconnect();
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
        //调用酒店id接口
		String message ="{'Usercd':'SZ2747','Authno':'123456','QueryType':'gainhotelids','city':'70008'}";
		//调用酒店接口
		String message = "{'Usercd':'sz2747','Authno':'123456' ,'hotelIds':'1/2/3','QueryType':'hotelinfo'}";
		String url="http://58.250.56.214:6000/commonQueryServlet";
		String result=HttpConnectionUtils.doPost(message, url);
		JSONObject jsonObject  = JSON.parseObject(result);
		System.out.println(jsonObject);
		JSONArray o=jsonObject.getJSONArray('data');
		System.out.println(o.get(1));
		System.out.println(o.get(2));
		System.out.println(o.get(0));*/
		//System.out.println(o.getJSONArray('0'));
		//JSONObject data=(JSONObject) jsonObject.get('data');
	    //System.out.println(data.toJSONString());
		//System.out.println(result);
	}

}
