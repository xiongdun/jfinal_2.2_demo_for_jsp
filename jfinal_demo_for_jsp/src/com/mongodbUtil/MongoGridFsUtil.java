package com.mongodbUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.bson.types.ObjectId;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

/**
 * mongoDB GridFs操作类
* @author  chenguanghai
* @version 创建时间：2016年5月30日 下午6:10:12
*
 */
public class MongoGridFsUtil {
	
	/**
	 * 添加图片到mongodb
	 * @param imgs
	 * @param db
	 * @return
	 */
	public static String addFile(File imgs,DB db){
		String key = null;
		try {		
			InputStream img = new FileInputStream(imgs);
			GridFS fs = new GridFS(db, "yh_images");
			GridFSFile mongofile = fs.createFile(img,imgs.getName());
			mongofile.save();
			key = mongofile.getId().toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return key;
	}
	
	/**
	 * 查询图片
	 * @param key
	 * @param db
	 * @return
	 * @throws Exception
	 */
	public static FileBean getFileBean(String key,DB db)
			throws Exception {
		FileBean bean=new FileBean();
		GridFS gridFS = new GridFS(db, "yh_images");
		GridFSDBFile file=gridFS.find(new ObjectId(key));
		bean.setFileName(file.getFilename());
		bean.setInputStream(file.getInputStream());
		bean.setFileType(file.getContentType());
		return bean;
	}
	
	/**
	 * 删除图片
	 * @param key
	 * @param fileType
	 * @throws Exception
	 */
	public static void deleteFile(String key, DB db){
		GridFS gridFS = new GridFS(db, "yh_images");
		gridFS.remove(key);
	}

}
