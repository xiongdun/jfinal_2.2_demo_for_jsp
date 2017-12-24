package com.demo.common;

import com.demo.bean.yhCountry.yhCountry;
import com.demo.bean.yhCountry.yhCountryController;
import com.demo.bean.yhItinerary.yhItineraryController;
import com.demo.bean.yhLabel.yhLabelController;
import com.demo.bean.yhScenery.yhSceneryController;
import com.demo.bean.yhUser.yhUser;
import com.demo.bean.yhUser.yhUserController;
import com.demo.index.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.mongodbUtil.MongoJFinalPlugin;
import com.util.MyHandler;

/**
 * API引导式配置
 */
public class DemoConfig extends JFinalConfig {

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		PropKit.use("a_little_config.txt"); // 加载少量必要配置，随后可用PropKit.get(...)获取值
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setViewType(ViewType.JSP); // 设置视图类型为Jsp，否则默认为FreeMarker
		me.setFreeMarkerTemplateUpdateDelay(0); // 设置不缓存
	}

	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", IndexController.class, "/index"); // 第三个参数为该Controller的视图存放路径
		me.add("/country", yhCountryController.class);
		me.add("/user", yhUserController.class);
		me.add("/label", yhLabelController.class);
		me.add("itinerary", yhItineraryController.class);
		me.add("/scenery", yhSceneryController.class);
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置redis
		Prop redis = PropKit.use("redis_config.txt");
		RedisPlugin redispRedis = new RedisPlugin(redis.get("cacheName"),
				redis.get("host"), redis.getInt("port"));
		me.add(redispRedis);

		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),
				PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arpMysql = new ActiveRecordPlugin("mysql",
				c3p0Plugin);
		me.add(arpMysql);
		arpMysql.addMapping("yh_country", yhCountry.class);
		arpMysql.addMapping("yh_user", yhUser.class);

		// 配置mongodb
		Prop p = PropKit.use("mongodb_config.txt");
		MongoJFinalPlugin jFinalPlugin = new MongoJFinalPlugin();
		jFinalPlugin.add(p.get("mongodb.host"),
				Integer.parseInt(p.get("mongodb.config")));
		jFinalPlugin.setDatabase(p.get("mongodb.name"));
		jFinalPlugin.auth(p.get("mongodb.username"), p.get("mongodb.password"));
		me.add(jFinalPlugin);

		me.add(new EhCachePlugin());
	}

	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {

	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new MyHandler());
	}

	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目 运行此 main
	 * 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 50002, "/", 0);
	}
}
