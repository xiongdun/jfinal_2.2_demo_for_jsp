package com.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.demo.bean.yhCountry.yhCountry;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.util.HttpConnectionUtils;
import com.util.ResponseUtils;
import com.util.TongChengSignUtil;

public class ClientDemo {
	/**
	 * 启动数据库连接
	 */
	static{
		PropKit.use("a_little_config.txt");	
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		c3p0Plugin.start();
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql",c3p0Plugin);
		arpMysql.addMapping("yh_country","id",yhCountry.class);
		arpMysql.start();
	}
	
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
		String url = "http://tcopenapi.17usoft.com/Handlers/General/AdministrativeDivisionsHandler.ashx"; // 正式服务器地址
		getProvince(ht, url);		
	}
	
	/**
	 * 组装xml
	 * @param ht
	 * @param provinceId
	 * @param cityId
	 * @return
	 */
	public static String assemblyXml(Hashtable<String, String> ht,
			String provinceId,String cityId) {
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
		if (StringUtils.isNotBlank(provinceId)) {
			strRequest = strRequest + "<provinceId>" + provinceId + "</provinceId>";
		}
		if (StringUtils.isNotBlank(cityId)) {
			strRequest = strRequest + "<cityId>" + cityId + "</cityId>";
		}
		strRequest = strRequest + "</body>";
		strRequest = strRequest + "</request>";
		return strRequest;
	}
	
	/**
	 * 获取省份列表
	 * @param ht
	 * @param url
	 */
	@SuppressWarnings("rawtypes")
	public static void getProvince(Hashtable<String, String> ht,String url){
		ht.put("serviceName", "GetProvinceList"); // 调用接口的方法名称GetSceneryList
		//获取省份信息
		String strRequest = assemblyXml(ht,null,null);
		try {
			String result = HttpConnectionUtils.doPost(strRequest, url,
					ResponseUtils.REQUEST_TYPE_XML);
			Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("body"); 
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator iters = recordEle.elementIterator("provinceList"); 	
				while (iters.hasNext()) {
					Element recordEles = (Element) iters.next();
					String item = recordEles.attributeValue("totalCount");  //获取子节点属性
					System.out.println(item);
					Iterator iterss = recordEles.elementIterator("province");
					while (iterss.hasNext()) {
						Element recordEless = (Element) iterss.next();
						//增加到数据库并返回id
						String provinceId = add(recordEless,null,1);
						
						System.out.println(recordEless.elementTextTrim("name"));
						
					    //根据省份id获取城市
						getCity(ht, provinceId, url);
			}
			System.out.println(result);
		}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
    /**
     * 根据省份id获取城市
     * @param ht
     * @param provinceId  省份id
     * @param url
     */
	@SuppressWarnings("rawtypes")
	public static void getCity(Hashtable<String, String> ht,String provinceId,String url){
		ht.put("serviceName", "GetCityListByProvinceId");
		String strRequestCity = assemblyXml(ht,provinceId,null);
		try{
		String resultCity = HttpConnectionUtils.doPost(strRequestCity, url,
				ResponseUtils.REQUEST_TYPE_XML);
		System.out.println(resultCity);
		Document docCity = DocumentHelper.parseText(resultCity); // 将字符串转为XML
		Element rootEltCity = docCity.getRootElement(); // 获取根节点
		Iterator itercity = rootEltCity.elementIterator("body"); 
		while (itercity.hasNext()) {
			Element rootEltCitys = (Element) itercity.next();
			Iterator itercitys = rootEltCitys.elementIterator("cityList"); 
			while (itercitys.hasNext()) {
				Element rootEltCityss = (Element) itercitys.next();
				Iterator itercityss = rootEltCityss.elementIterator("city");
				while (itercityss.hasNext()) {
					Element rootEltCitysss = (Element) itercityss.next();
					//增加到数据库并返回id
					String cityId = add(rootEltCitysss,provinceId,2);
					System.out.println(rootEltCitysss.elementTextTrim("name"));
					getCounty(ht, cityId, url);
				}
	          }
            }
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	/**
	 *  根据城市id获取区域信息
	 * @param ht
	 * @param cityId 城市id
	 * @param url
	 */
	@SuppressWarnings("rawtypes")
	public static void getCounty(Hashtable<String, String> ht,String cityId,String url){
		
		ht.put("serviceName", "GetCountyListByCityId");
		String strRequestCity = assemblyXml(ht,null,cityId);
		try{
		String resultCity = HttpConnectionUtils.doPost(strRequestCity, url,
				ResponseUtils.REQUEST_TYPE_XML);
		System.out.println(resultCity);
		Document docCity = DocumentHelper.parseText(resultCity); // 将字符串转为XML
		Element rootEltCity = docCity.getRootElement(); // 获取根节点
		Iterator itercity = rootEltCity.elementIterator("body"); 
		while (itercity.hasNext()) {
			Element rootEltCitys = (Element) itercity.next();
			Iterator itercitys = rootEltCitys.elementIterator("countyList"); 
			while (itercitys.hasNext()) {
				Element rootEltCityss = (Element) itercitys.next();
				Iterator itercityss = rootEltCityss.elementIterator("county");
				while (itercityss.hasNext()) {
					Element rootEltCitysss = (Element) itercityss.next();
					//增加到数据库
					add(rootEltCitysss,cityId,3);
					System.out.println(rootEltCitysss.elementTextTrim("name"));
				}
	          }
            }
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	
	/**
	 * 通过Jfinal添加到数据库	
	 * @param recordEless
	 * @param parentId
	 * @param level
	 * @return
	 */
	public static String add(Element recordEless,String parentId,int level){
		String provinceId = recordEless.elementTextTrim("id");
		String provinceName = recordEless.elementTextTrim("name");
		String prefixLetter = recordEless.elementTextTrim("prefixLetter");
		String ename = recordEless.elementTextTrim("enName");
							
		yhCountry country = new yhCountry();
		country.use("mysql").set("id", provinceId);
		country.use("mysql").set("name", provinceName);
		if(StringUtils.isNotBlank(parentId)){
		   country.use("mysql").set("parent_id",Long.parseLong(parentId));
		}else{
		country.use("mysql").set("parent_id", 0l);
		}
		country.use("mysql").set("level", level);
		country.use("mysql").set("prefix_letter", prefixLetter);
		country.use("mysql").set("ename", ename);
		country.save();
		return country.get("id");
	}
}
