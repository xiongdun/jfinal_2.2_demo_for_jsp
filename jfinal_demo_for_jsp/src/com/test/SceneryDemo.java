package com.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;
import com.demo.bean.yhCountry.yhCountry;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.mongodbUtil.MongoJFinalPlugin;
import com.mongodbUtil.MongoQuery;
import com.util.HttpConnectionUtils;
import com.util.ResponseUtils;
import com.util.TongChengSignUtil;
import com.util.UtilFuns;

public class SceneryDemo {
	
	static{
		PropKit.use("a_little_config.txt");	
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		c3p0Plugin.start();
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql",c3p0Plugin);
		arpMysql.addMapping("yh_country","id",yhCountry.class);
		arpMysql.start();
		
		Prop p= PropKit.use("mongodb_config.txt");   //获取mangodb配置文件
		MongoJFinalPlugin jFinalPlugin = new MongoJFinalPlugin();
		jFinalPlugin.add(p.get("mongodb.host"), Integer.parseInt(p.get("mongodb.config")));
		jFinalPlugin.setDatabase(p.get("mongodb.name"));
		jFinalPlugin.auth(p.get("mongodb.username"), p.get("mongodb.password"));
		jFinalPlugin.start();
		
/*		List<yhCountry> list=yhCountry.me.getProvince();
		for (int t = 0; t < list.size(); t++) {
			MongoQuery query =new MongoQuery();
			List<JSONObject> sceneryList = query.use("yh_scenery").eq("provinceId",list.get(t).get("id").toString()).find();
			for (JSONObject jsonObject : sceneryList) {
				MongoQuery del = new MongoQuery();
				del.use("yh_scenery").eq("sceneryId", jsonObject.get("sceneryId"))
				.modify("gradeId", Integer.parseInt(jsonObject.get("gradeId").toString()))
				.modify("commentCount", Integer.parseInt(jsonObject.get("commentCount").toString()))
				.update();
			}
				String Id = list.get(t).get("id").toString();
				System.out.println("取景区资源出现错误,省份id为"+Id+"!"+"  名称:"+list.get(t).get("name"));
				MongoQuery query =new MongoQuery();
				List<JSONObject> sceneryList = query.use("yh_scenery").eq("provinceId",Id).find();
				System.out.println("该省份资源条数："+sceneryList.size());				
					for (JSONObject jsonObject : sceneryList) {
						MongoQuery del = new MongoQuery();
						del.use("yh_image").eq("sceneryId", jsonObject.get("sceneryId")).delete();				
					}
				MongoQuery del =new MongoQuery();
				MongoQuery del2 =new MongoQuery();
				del2.use("yh_label").eq("source", "TongCheng").delete();
				System.out.println("删除景点数："+del.use("yh_scenery").eq("provinceId",Id).delete());
				System.out.println("已删除该省所记录条数");
		}
		System.out.println("11");*/
	}
	
	static String url = "http://tcopenapi.17usoft.com/handlers/scenery/queryhandler.ashx"; // 正式服务器地址
	
	public static void main(String[] args) {

		Hashtable<String, String> ht = new Hashtable<String, String>(); // 将参数放入Hashtable中，便于操作

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		SimpleDateFormat ymdhmsf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		String reqTime = ymdhmsf.format(date);
		// 账号 71f10c64-65ab-46e8-867e-5435dba7a940 密码 1ae9310a349aa5b3
		ht.put("version", "20111128102912"); // 接口协议版本号，详见接口协议文档
		ht.put("accountId", "71f10c64-65ab-46e8-867e-5435dba7a940"); // API帐户ID(小写)，待申请审批通过后发放
		ht.put("accountKey", "1ae9310a349aa5b3"); // API帐户密钥，待申请审批通过后发放		
		ht.put("reqTime", reqTime); // 当前日期		
		getProvince(ht, url);
	}

	//组装xml
	public static String assemblyXml(Hashtable<String, String> ht,String id,int page) {
		String strRequest = ""; // 请求XML字符串
		strRequest = strRequest
				+ "<?xml version='1.0' encoding='utf-8' standalone='yes'?>";
		strRequest = strRequest + "<request>";
		strRequest = strRequest + "<header>";
		strRequest = strRequest + "<version>" + ht.get("version")
				+ "</version>";
		strRequest = strRequest + "<accountID>" + ht.get("accountId")
				+ "</accountID>";
		strRequest = strRequest + "<serviceName>" + ht.get("serviceName")
				+ "</serviceName>";
		try {
			strRequest = strRequest + "<digitalSign>" + TongChengSignUtil.createDigitalSign(ht)
					+ "</digitalSign>";
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		strRequest = strRequest + "<reqTime>" + ht.get("reqTime")
				+ "</reqTime>";
		strRequest = strRequest + "</header>";
		strRequest = strRequest + "<body>";
		switch (ht.get("serviceName")) {
			case "GetSceneryList":    //根据省份查询景点列表
				//请求ip地址
				strRequest = strRequest + "<clientIp>" + "192.168.1.203" + "</clientIp>"; 
				//页数
				strRequest = strRequest + "<page>" + page + "</page>";
				//分页大小
				strRequest = strRequest + "<pageSize>" + "100" + "</pageSize>";		
				//省id
				strRequest = strRequest + "<provinceId>" + id + "</provinceId>";
				//坐标系统 1.高德   2.百度 不传默认为1
				strRequest = strRequest + "<cs>" + "1" + "</cs>";
				break;
			case "GetSceneryDetail":  //根据景点查询景点详情
				//景点id
				strRequest = strRequest + "<sceneryId>" + id + "</sceneryId>";
				//坐标系统 1.高德   2.百度 不传默认为1
				strRequest = strRequest + "<cs>" + "1" + "</cs>";
			    break;
			case "GetSceneryTrafficInfo":  //根据景点查询交通路线
				//景点id
				strRequest = strRequest + "<sceneryId>" + id + "</sceneryId>";
				break;
			case "GetSceneryImageList":    //根据景点查询图片列表
				//景点id
				strRequest = strRequest + "<sceneryId>" + id + "</sceneryId>";
				//页数
				strRequest = strRequest + "<page>" + page + "</page>";
				//分页大小
				strRequest = strRequest + "<pageSize>" + "3" + "</pageSize>";	
				break;
			default:
				break;
		}			
		strRequest = strRequest + "</body>";
		strRequest = strRequest + "</request>";		
		return strRequest;
	}
	
	/**
	 * 获取景点列表
	 * @param ht
	 * @param url
	 */	
	@SuppressWarnings("rawtypes")
	public static void getProvince(Hashtable<String, String> ht,String url){
		//从数据库获取省份id
		List<yhCountry> list=yhCountry.me.getProvince();
		int Pagecount = 0;
		for (int t = 0; t < list.size(); t++) {
				int page = 1;
				int totalPage = 1;
				String Id = list.get(t).get("id").toString();
			    try {
			      int count = 1;
				  for(int i = page ; i <= totalPage; i++){
					page = i;
					String result;
					String actionCode = " ";
					String rspType = " ";
					String rspCode = " ";
					Element rootElt;
					do {
						ht.put("serviceName", "GetSceneryList"); // 调用接口的方法名称GetSceneryList
						String strRequest = assemblyXml(ht,Id,page);
						result = HttpConnectionUtils.doPost(strRequest, url,
								ResponseUtils.REQUEST_TYPE_XML);
						Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
						rootElt = doc.getRootElement(); // 获取根节点
						Iterator header = rootElt.elementIterator("header");
							while(header.hasNext()){
								Element headers = (Element) header.next();
								actionCode = headers.elementTextTrim("actionCode");
								rspType = headers.elementTextTrim("rspType");
								rspCode = headers.elementTextTrim("rspCode");
							}
					} while (!actionCode.equals("1") && !rspType.equals("0") && !rspCode.equals("0000"));{
						Map<String,Integer> map = getScenery(ht,result,count);
						count ++;
						totalPage = map.get("totalPage");
						Pagecount = map.get("totalCount");
					}											
				 }
				  System.out.print("总记录条数："+Pagecount);
				  MongoQuery query =new MongoQuery();
				  List<JSONObject> sceneryList = query.use("yh_scenery").eq("provinceId",Id).find();
				  System.out.println("该省份资源条数："+sceneryList.size());
				  //数量不匹配
				  if(Pagecount != sceneryList.size()){
					  System.out.println("-------------------------------数量不匹配,重新取该省景区资源-------------------------------");
					  List<JSONObject> sceneryLists = query.use("yh_scenery").eq("provinceId",Id).find();
					  for (JSONObject jsonObject : sceneryLists) {
							MongoQuery del = new MongoQuery();
							del.use("yh_image").eq("sceneryId", jsonObject.get("sceneryId")).delete();				
						}
					  MongoQuery del =new MongoQuery();
					  del.use("yh_scenery").eq("provinceId",Id).delete();
					  t = t - 1;
				  }
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("取景区资源出现错误,省份id为"+Id+"!");
				MongoQuery query =new MongoQuery();
				List<JSONObject> sceneryList = query.use("yh_scenery").eq("provinceId",Id).find();
				System.out.println("该省份资源条数："+sceneryList.size());				
					for (JSONObject jsonObject : sceneryList) {
						MongoQuery del = new MongoQuery();
						del.use("yh_image").eq("sceneryId", jsonObject.get("sceneryId")).delete();				
					}
				MongoQuery del =new MongoQuery();
				System.out.println("删除景点数："+del.use("yh_scenery").eq("provinceId",Id).delete());
				System.out.println("已删除该省所记录条数");
				System.out.println("-------------------------------重新取该省景区资源-------------------------------");
				//重新循环该省
				t = t - 1;
			}			  
		}
	}
	/**
	 * 获取景点信息
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String,Integer> getScenery(Hashtable<String, String> ht,String result,int count) throws Exception{
		Map<String,Integer> map=new HashMap<String, Integer>();
		Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
		Element rootElt = doc.getRootElement(); // 获取根节点
		Iterator iter = rootElt.elementIterator("body"); 
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			Iterator iters = recordEle.elementIterator("sceneryList"); 	
			while (iters.hasNext()) {
				Element recordEles = (Element) iters.next();
				
				int page = Integer.parseInt(recordEles.attributeValue("page"));              //当前页数
				map.put("page", page);				
				int totalPage = Integer.parseInt(recordEles.attributeValue("totalPage"));    //总页数
				map.put("totalPage", totalPage);
				String pageSize = recordEles.attributeValue("pageSize");      //分页大小
				String totalCount = recordEles.attributeValue("totalCount");  //总记录数
				map.put("totalCount", Integer.valueOf(totalCount));
				String baseURL = recordEles.attributeValue("imgbaseURL");     //图片URL前缀						
				Iterator iterss = recordEles.elementIterator("scenery");
				
				int t=1;
				while (iterss.hasNext()) {					
					Element recordEless = (Element) iterss.next();
					MongoQuery mongoQuery = new MongoQuery();					
					addMongoByScenery(ht, recordEless,mongoQuery,count,t);	
					t ++;
				}
			}
		}
		return map;
	}
	
	/**
	 * 获取景点详细信息
	 * @param SceneryId
	 */
	@SuppressWarnings("rawtypes")
	public static MongoQuery getSceneryDetail(Hashtable<String, String> ht,String SceneryId,MongoQuery mongoQuery) throws Exception{
		String result;
		String actionCode = " ";
		String rspType = " ";
		String rspCode = " ";
		Element rootElt;
		do{
			ht.put("serviceName", "GetSceneryDetail"); // 调用接口的方法名称GetSceneryDetail
			String strRequest = assemblyXml(ht,SceneryId,0);
	        result = HttpConnectionUtils.doPost(strRequest, url,
				ResponseUtils.REQUEST_TYPE_XML);		
	        Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
			rootElt = doc.getRootElement(); // 获取根节点
			Iterator header = rootElt.elementIterator("header");
				while(header.hasNext()){
					Element headers = (Element) header.next();
					actionCode = headers.elementTextTrim("actionCode");
					rspType = headers.elementTextTrim("rspType");
					rspCode = headers.elementTextTrim("rspCode");
				}
			
		} while (!actionCode.equals("1") && !rspType.equals("0") && !rspCode.equals("0000"));
		{
			Iterator body = rootElt.elementIterator("body"); 
			while(body.hasNext()){
				Element scenery = (Element) body.next();
				Iterator scenerys = scenery.elementIterator("scenery");
				while(scenerys.hasNext()){
					Element iter = (Element) scenerys.next();
					String intro = iter.elementTextTrim("intro");//景点图文简介 - 富文本
					mongoQuery.use("yh_scenery").set("intro", intro);	
					String buyNotice = iter.elementTextTrim("buyNotice"); //购票须知 - 富文本
					mongoQuery.use("yh_scenery").set("buyNotice", buyNotice);	
					String payMode = iter.elementTextTrim("payMode"); //支付类型
					mongoQuery.use("yh_scenery").set("payMode", payMode);	
					String ifUseCard = iter.elementTextTrim("ifUseCard"); // 是否需要证件 0.不需要 1.需要			
					mongoQuery.use("yh_scenery").set("ifUseCard", ifUseCard);	
				}
			}
		}
		return mongoQuery;
	}
	
	/**
	 * 获取景点交通信息
	 * @param SceneryId
	 */
	@SuppressWarnings("rawtypes")
	public static MongoQuery getSceneryTrafficInfo(Hashtable<String, String> ht,String SceneryId,MongoQuery mongoQuery) throws Exception{
		String result;
		String actionCode = " ";
		String rspType = " ";
		String rspCode = " ";
		Element rootElt;
		do{
			ht.put("serviceName", "GetSceneryTrafficInfo"); // 调用接口的方法名称GetSceneryDetail
			String strRequest = assemblyXml(ht,SceneryId,0);	
			result = HttpConnectionUtils.doPost(strRequest, url,
					ResponseUtils.REQUEST_TYPE_XML);
			Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
			rootElt = doc.getRootElement(); // 获取根节点
			Iterator header = rootElt.elementIterator("header");
				while(header.hasNext()){
					Element headers = (Element) header.next();
					actionCode = headers.elementTextTrim("actionCode");
					rspType = headers.elementTextTrim("rspType");
					rspCode = headers.elementTextTrim("rspCode");
				}
		} while (!actionCode.equals("1") && !rspType.equals("0") && !rspCode.equals("0000"));
		{
			Iterator body = rootElt.elementIterator("body"); 
			while(body.hasNext()){
				Element scenery = (Element) body.next();
				Iterator scenerys = scenery.elementIterator("scenery");
				while(scenerys.hasNext()){
					Element iter = (Element) scenerys.next();
					String traffic = iter.elementTextTrim("traffic");//景点交通指南 - 富文本
					mongoQuery.use("yh_scenery").set("traffic", traffic);	
				}
			}
		}
			
			
		return mongoQuery;
	}
	
	/**
	 * 获取景点图片信息
	 * @param SceneryId
	 */
	@SuppressWarnings("rawtypes")
	public static void getSceneryImageList(Hashtable<String, String> ht,String SceneryId) throws Exception{
		String result;
		String actionCode = " ";
		String rspType = " ";
		String rspCode = " ";
		Element rootElt;
		do{
			ht.put("serviceName", "GetSceneryImageList"); // 调用接口的方法名称GetSceneryDetail
			String strRequest = assemblyXml(ht,SceneryId,1);	
			result = HttpConnectionUtils.doPost(strRequest, url,
					ResponseUtils.REQUEST_TYPE_XML);
			Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
			rootElt = doc.getRootElement(); // 获取根节点
			Iterator header = rootElt.elementIterator("header");
				while(header.hasNext()){
					Element headers = (Element) header.next();
					actionCode = headers.elementTextTrim("actionCode");
					rspType = headers.elementTextTrim("rspType");
					rspCode = headers.elementTextTrim("rspCode");
				}
		} while (!actionCode.equals("1") && !rspType.equals("0") && !rspCode.equals("0000"));
		{
			Iterator body = rootElt.elementIterator("body"); 
			while(body.hasNext()){
				Element scenery = (Element) body.next();
				Iterator scenerys = scenery.elementIterator("imageList");
				while(scenerys.hasNext()){
					Element iter = (Element) scenerys.next();
					int page = Integer.parseInt(iter.attributeValue("page"));              //当前页数
					String pageSize = iter.attributeValue("pageSize");      //分页大小
					int totalPage = Integer.parseInt(iter.attributeValue("totalPage"));    //总页数
					String totalCount = iter.attributeValue("totalCount");  //总记录数
					String baseURL = "http://pic3.40017.cn/scenery/destination/";     //图片URL前缀
					Iterator image = iter.elementIterator("image");
					int i = 1;
					while(image.hasNext()){
						MongoQuery imageQuery = new MongoQuery();
						Element images = (Element) image.next();
						String imagePath = images.elementTextTrim("imagePath");  //景点图片
						imageQuery.use("yh_image").set("sceneryId", SceneryId);
						if(imagePath.length() <50){
							imageQuery.use("yh_image").set("imagePath",baseURL + imagePath); //景点图片
						}else{
							imageQuery.use("yh_image").set("imagePath",imagePath);	 //景点图片
						}
						imageQuery.use("yh_image").set("type", 1);
						imageQuery.use("yh_image").set("stor", i);
						imageQuery.use("yh_image").set("source", "TongCheng"); //景点来源于同程?如果从其他网站拿数据，那么这里是不是又需要在改变呢？
						imageQuery.save();
						i++;
					}
				}
			}
		}
			
			
	}
	
	/**
	 * 将景点数据添加到mongodb
	 * @param ht
	 * @param recordEless
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void addMongoByScenery(Hashtable<String, String> ht,Element recordEless,MongoQuery mongoQuery,int count,int t) throws Exception{
		System.out.print("第"+count+"页    ");
		System.out.print("第"+t+"个景点    ");
		String baseURL = "http://pic3.40017.cn/scenery/destination/";     //图片URL前缀
				
		String sceneryId = recordEless.elementTextTrim("sceneryId");      //景点id
		mongoQuery.use("yh_scenery").set("sceneryId", Integer.parseInt(sceneryId));
		System.out.print("景点id："+sceneryId+"    ");
		
		String sceneryName = recordEless.elementTextTrim("sceneryName");  //景点名称
		mongoQuery.use("yh_scenery").set("sceneryName", sceneryName);
		System.out.print("景点名称："+sceneryName+"    ");
		
		String imgPath = baseURL + recordEless.elementTextTrim("imgPath");          //图片地址		
		mongoQuery.use("yh_scenery").set("imgPath", imgPath);
		
		String sceneryAddress = recordEless.elementTextTrim("sceneryAddress"); //景点地址		
		mongoQuery.use("yh_scenery").set("sceneryAddress", sceneryAddress);
		
		String scenerySummary = recordEless.elementTextTrim("scenerySummary"); //景点简介
		mongoQuery.use("yh_scenery").set("scenerySummary", scenerySummary);
		
		String provinceId = recordEless.elementTextTrim("provinceId"); //省份id
		mongoQuery.use("yh_scenery").set("provinceId", Integer.parseInt(provinceId));		
		System.out.print("省份id："+provinceId+"    ");
		
		String provinceName = recordEless.elementTextTrim("provinceName"); //省份名称
		mongoQuery.use("yh_scenery").set("provinceName", provinceName);
		System.out.println("省份名称："+provinceName+"    ");
		
		String cityId = recordEless.elementTextTrim("cityId"); //城市id
		mongoQuery.use("yh_scenery").set("cityId", Integer.parseInt(cityId));
		
		String cityName = recordEless.elementTextTrim("cityName"); //城市名称
		mongoQuery.use("yh_scenery").set("cityName", cityName);
		
		String countyId = recordEless.elementTextTrim("countyId"); //行政区id
		mongoQuery.use("yh_scenery").set("countyId", Integer.parseInt(countyId));
		
		String countyName = recordEless.elementTextTrim("countyName"); //行政区名称
		mongoQuery.use("yh_scenery").set("countyName", countyName);
		
		String gradeId = recordEless.elementTextTrim("gradeId"); //等级id 5星为：AAAAA，4星：AAAA，以此类推
		if(UtilFuns.isNotEmpty(gradeId)){
		   mongoQuery.use("yh_scenery").set("gradeId", gradeId.length());
		}else{
		   mongoQuery.use("yh_scenery").set("gradeId", 0);
		}
		String commentCount = recordEless.elementTextTrim("commentCount"); //点评数
		mongoQuery.use("yh_scenery").set("commentCount", Integer.parseInt(commentCount));
		
		String questionCount = recordEless.elementTextTrim("questionCount"); //问答数
		mongoQuery.use("yh_scenery").set("questionCount", Integer.parseInt(questionCount));
		
		String blogCount = recordEless.elementTextTrim("blogCount"); //博客数量
		mongoQuery.use("yh_scenery").set("blogCount", Integer.parseInt(blogCount));
		
		String viewCount = recordEless.elementTextTrim("viewCount"); //浏览次数
		mongoQuery.use("yh_scenery").set("viewCount", Integer.parseInt(viewCount));
		
		String bookFlag = recordEless.elementTextTrim("bookFlag"); //可预订情况  -1：暂时下线 0：不可预订 1：可预订
		mongoQuery.use("yh_scenery").set("bookFlag", Integer.parseInt(bookFlag));
		
		String amount = recordEless.elementTextTrim("amount"); //门市价
		mongoQuery.use("yh_scenery").set("amount", Double.parseDouble(amount));
		
		String amountAdv = recordEless.elementTextTrim("amountAdv"); //同程价
		mongoQuery.use("yh_scenery").set("amountAdv", Double.parseDouble(amountAdv));
		
		String lon = recordEless.elementTextTrim("lon"); //经度
		mongoQuery.use("yh_scenery").set("amountAdv", amountAdv);//？？？？？
		
		String lat = recordEless.elementTextTrim("lat"); //纬度/*String distance; //距离 和查询标签或坐标的距离(单位:米)*/	
		mongoQuery.use("yh_scenery").set("lat", lat);
		
		mongoQuery.use("yh_scenery").set("source", "TongCheng"); //景点来源于同程
		
		Iterator themeList = recordEless.elementIterator("themeList"); //景点主题列表
		Iterator newThemeList = recordEless.elementIterator("newThemeList"); //新景点主题列表
		Iterator suitherdList = recordEless.elementIterator("suitherdList"); //适合人群列表
		Iterator impressionList = recordEless.elementIterator("impressionList"); //游客印象列表
		Iterator naList = recordEless.elementIterator("naList"); //景区别名列表
		
		String LabelName = "";
		while(themeList.hasNext()){
			Element themes = (Element) themeList.next();
			Iterator theme = themes.elementIterator("theme");
			while(theme.hasNext()){
				Element themess = (Element) theme.next();
				String themeId = themess.elementTextTrim("themeId");  //景点主题id
				String themeName = themess.elementTextTrim("themeName");  //景点主题名称
				LabelName = LabelName + themeName +",";
				addLabel(themeId,themeName,sceneryId);
			}
		}
		
		while(newThemeList.hasNext()){
			Element newthemes = (Element) newThemeList.next();
			Iterator newtheme = newthemes.elementIterator("theme");
			while(newtheme.hasNext()){
				Element newthemess = (Element) newtheme.next();
				String id = newthemess.elementTextTrim("id"); //新主题id
				String name = newthemess.elementTextTrim("name"); //新主题名称
				LabelName = LabelName + name +",";			
				addLabel(id,name,sceneryId);
			}
			labelUtil(mongoQuery, LabelName);
		}
		while(suitherdList.hasNext()){
			Element suitherds = (Element) suitherdList.next();
			Iterator suitherd = suitherds.elementIterator("suitherd");
			while(suitherd.hasNext()){
				Element suitherdss = (Element) suitherd.next();
				String suitherdId = suitherdss.elementTextTrim("suitherdId"); //适合人群id
				String suitherdName = suitherdss.elementTextTrim("suitherdName"); //适合人群名称
			}
		}
		while(impressionList.hasNext()){
			Element impressions = (Element) impressionList.next();
			Iterator impression = impressions.elementIterator("impression");
			while(impression.hasNext()){
				Element impressionss = (Element) impression.next();
				String impressionId = impressionss.elementTextTrim("impressionId"); //游客印象id
				String impressionName = impressionss.elementTextTrim("impressionName"); //游客印象名称
			}
		}
		while(naList.hasNext()){
			Element nas = (Element) naList.next();
			Iterator na = nas.elementIterator("na");
			while(na.hasNext()){
				Element nass = (Element) na.next();
				String name = nass.elementTextTrim("name"); //景区别名
				mongoQuery.use("yh_scenery").set("aliasName", name);
			}
		}
		
		//获取景点详细信息
		getSceneryDetail(ht, sceneryId,mongoQuery);
		//获取景点交通指南
		getSceneryTrafficInfo(ht, sceneryId,mongoQuery);		
		//获取景点图片列表
		getSceneryImageList(ht, sceneryId);		
		mongoQuery.save();
		
	}
	
	public static MongoQuery  labelUtil(MongoQuery mongoQuery,String LabelName){	
		if(UtilFuns.isNotEmpty(LabelName)){			
			LabelName = LabelName.substring(0, LabelName.length() - 1);
			String[] name = LabelName.split(",");
			LabelName = "";
			List<String> list = new ArrayList<String>();  
		    for (int i=0; i<name.length; i++) {  
		       if(!list.contains(name[i])) {
		    	   list.add(name[i].trim());
		    	   LabelName = LabelName + name[i] + ","; 
		        }  
		    }
		    LabelName = LabelName.substring(0, LabelName.length() - 1).trim();
		}
		return mongoQuery.use("yh_scenery").set("labelName", LabelName);	
	}
	
	public static void addLabel(String themeId,String themeName,String sceneryId){
		MongoQuery label=new MongoQuery();
		List<JSONObject> list = label.use("yh_label").eq("themeName", themeName).find();
		if(!UtilFuns.listValid(list)){
			//将标签数据存入标签表
			label.use("yh_label").set("themeId", themeId);
			label.use("yh_label").set("themeName", themeName);
			label.use("yh_label").set("source", "TongCheng");   //来源于同程
			label.use("yh_label").set("heat", "0");     //热度,热度决定首页的显示			
			label.save();
		}
			/*//将标签景点关联存入景点标签关联表
			MongoQuery Scenerylabel=new MongoQuery();
			Scenerylabel.use("yh_scenery_label").set("themeId", themeId);
			Scenerylabel.use("yh_scenery_label").set("sceneryId", sceneryId);
			Scenerylabel.save();*/
		/*else{
			MongoQuery Scenerylabel=new MongoQuery();
			Scenerylabel.use("yh_scenery_label").set("themeId", themeId);
			Scenerylabel.use("yh_scenery_label").set("sceneryId", sceneryId);
			Scenerylabel.save();
		}*/
	}
}	