package com.mongodbUtil;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人:T-baby
 * 创建日期: 16/4/15
 * 文件描述:MongoDB操作工具类
 */
public class MongoKit {


    private static MongoClient client;
    private static MongoDatabase defaultDb;


    public static void init(MongoClient client, String database) {
        MongoKit.client = client;
        MongoKit.defaultDb = client.getDatabase(database);
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return defaultDb.getCollection(collectionName);
    }

    public static long insert(String collectionName, List<Document> docs) {
        long before = getCollection(collectionName).count();
        getCollection(collectionName).insertMany(docs);
        return getCollection(collectionName).count() - before;
    }


    public static long insert(String collectionName, Document doc) {
        long before = getCollection(collectionName).count();
        getCollection(collectionName).insertOne(doc);
        return getCollection(collectionName).count() - before;
    }


    public static List<JSONObject> find(String collectionName,Bson projection) {
        return find(collectionName, new BsonDocument(), projection, new BsonDocument(), 0, 0);
    }

    public static List<JSONObject> find(String collectionName, int limit, Bson sort,Bson projection) {
        return find(collectionName, new BsonDocument(), projection, sort, limit, 0);
    }

    public static List<JSONObject> find(String collectionName, Bson query,Bson projection) {
        return find(collectionName, query, projection, new BsonDocument(), 0, 0);
    }


    public static long count(String collectionName, Bson query) {
        return getCollection(collectionName).count(query);
    }

    public static long count(String collectionName) {
        return getCollection(collectionName).count();
    }

	public static List<JSONObject> find(String collectionName, Bson query, Bson sort, Bson projection) {
        return find(collectionName, query, projection, sort, 0, 0);
    }


    public static List<JSONObject> find(String collectionName, Bson query, Bson projection, Bson sort, int limit) {
        return find(collectionName, query, projection, sort, limit, 0);
    }

    public static List<JSONObject> find(String collectionName, Bson query, Bson projection, Bson sort, int limit, int skip) {

        final List<JSONObject> list = new ArrayList<JSONObject>();

        Block<Document> block = new Block<Document>() {

            public void apply(final Document document) {
                document.put("_id", document.get("_id").toString());
                list.add(JSONObject.parseObject(document.toJson()));
            }
        };

        getCollection(collectionName).find(query).projection(projection).sort(sort).limit(limit).skip(skip).forEach(block);

        return list;

    }


    public static long update(String collectionName, Bson queue, Bson data) {
        UpdateResult updateResult = getCollection(collectionName).updateMany(queue, data);
        return updateResult.getModifiedCount();
    }


    public static long delete(String collectionName, Bson queue) {
        DeleteResult deleteResult = getCollection(collectionName).deleteMany(queue);
        return deleteResult.getDeletedCount();
    }


}




