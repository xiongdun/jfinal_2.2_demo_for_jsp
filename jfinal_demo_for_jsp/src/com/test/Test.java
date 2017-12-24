package com.test;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.mongodbUtil.MongoJFinalPlugin;
import com.mongodbUtil.MongoQuery;

public class Test {
	static {
		Prop p = PropKit.use("mongodb_config.txt"); // 获取mangodb配置文件
		MongoJFinalPlugin jFinalPlugin = new MongoJFinalPlugin();
		jFinalPlugin.add(p.get("mongodb.host"),
				Integer.parseInt(p.get("mongodb.config")));
		jFinalPlugin.setDatabase(p.get("mongodb.name"));
		jFinalPlugin.auth(p.get("mongodb.username"), p.get("mongodb.password"));
		jFinalPlugin.start();
	}

	public static void main(String[] args) {
		JSONObject day = new JSONObject();		
		for(int i=1;i<3;i++){
		JSONArray day1List = new JSONArray();
		JSONObject day1 = new JSONObject();
		day1.put("name", "丽江");
			for(int j=0;j<5;j++){
				JSONArray list = new JSONArray();
				JSONObject plan = new JSONObject();
				plan.put("time", "9AM");
				plan.put("type", "飞机");
				plan.put("name", "深圳-丽江");
				list.add(plan);
				day1List.add(list);
			}
	    day1.put("plan", day1List);
		day.put("day"+i+"", day1);
		}
		System.out.println(day.toString());
/*		MongoQuery query = new MongoQuery();
        query.use("yh_travel_line")	
		.set("productno","YH")
		.set("title", "东部华侨城小梅沙海洋世界两日游")
		.set("overview", "http://pic3.40017.cn/scenery/destination/2015/06/10/13/kB1n84.jpg,"
				+ "http://pic3.40017.cn/scenery/destination/2015/06/10/13/2utWH7.jpg,"
				+ "http://pic3.40017.cn/scenery/destination/2015/06/10/13/kB1n84.jpg,"
				+ "http://pic3.40017.cn/scenery/destination/2015/06/10/13/sePpb6.jpg")
		.set("scenics", "东部华侨城,小梅沙海洋世界")
		.save();*/
		
		/*query.use("yh_trip")
		.set("uid", "1")                     //行程所属用户id
		.set("beginDate", new Date())         //开始时间
		.set("endDate", new Date())           //结束时间
		.set("tNo", "0")                     //订单编号
		.set("name", "扬起梦想之帆 大鹏山海两日休闲之旅")     //行程名称
		.set("imageKey", "56de3b32239d19327198eaf9")  //图片key
		.set("total_days", "2天1夜")                   //行程总时长
		.set("price", "100")                         //总价
		.set("status", 1)                     //状态
		.set("source", "yh")                  //来源
		.set("heat", "0")                     //热度
		.save();
		String tripId = query.getId();              //获取返回id
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, (0));
		MongoQuery query2 = new MongoQuery();
		query2.use("yh_trip_day")      //天数表
		.set("tid", tripId)           //行程id
		.set("tdNo", "001")           //天数编号
		.set("name", "第1天")          //天数名称
		.set("playDate", cal.getTime())  //游玩的具体时间
		.set("playCityId", "91")
		.save();
		
		cal.add(Calendar.DATE, (1));
		MongoQuery query3 = new MongoQuery();
		query3.use("yh_trip_day")      //天数表
		.set("tid", tripId)           //行程id
		.set("tdNo", "001")           //天数编号
		.set("name", "第1天")          //天数名称
		.set("playDate", cal.getTime())  //游玩的具体时间
		.set("playCityId", "91")
		.save();
		
		MongoQuery query4 = new MongoQuery();
		query4.use("yh_trip_detail")
		.save();*/
		
		
/*		String s="http://pic3.40017.cn/scenery/destination/http://pic4.40017.cn/scenery/destination/2016/05/17/12/mHfgNk.jpg";
		System.out.println("2016/05/17/12/mHfgNk.jpg".length());
		System.out.println("http://pic3.40017.cn/scenery/destination/2015/04/18/05/LsFz1U.jpg".length());
		System.out.println(s.substring(41, s.length()));
		
		MongoQuery query = new MongoQuery();
		List<JSONObject> sceneryList = query.use("yh_image").findAll();
		System.out.println(sceneryList.size());
		for (JSONObject jsonObject : sceneryList) {
			if(jsonObject.get("imagePath").toString().length() > 80){
				MongoQuery update = new MongoQuery();
				String imagePath = jsonObject.get("imagePath").toString();
				imagePath = (String) imagePath.subSequence(41, imagePath.length());
				String id = jsonObject.get("_id").toString();
				long count = update.use("yh_image").byId(id).modify("imagePath", imagePath).update();
				
			}
			if(jsonObject.get("imagePath").toString().length() < 45){
				System.out.println("1");
				MongoQuery update = new MongoQuery();
				String imagePath = jsonObject.get("imagePath").toString();
				System.out.println(imagePath);
				String updateimage = "http://pic3.40017.cn/scenery/destination/"+imagePath;
				String id = jsonObject.get("_id").toString();
				System.out.println(id);
				long count = update.use("yh_image").byId(id).modify("imagePath", updateimage).update();
				System.out.println(count);
			}
		}
		System.exit(0);*/
	}
}
