package com.javatpoint.java.mongo.db;  
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  

import org.bson.Document;  
public class JavaMongoDemo {  
	public static void main(String[] args){  
		try{
			DB db = connectDB.getDatabase();
			
			DBCollection table = db.getCollection("restaurants"); 
			
			//1.display all documents
			DBCursor doclist = table.find();
			while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
			///////////////////////////////////////////////
			
			//2.display specific fields
			BasicDBObject query = new BasicDBObject();
			BasicDBObject fields = new BasicDBObject();
			fields.put("_id", 1);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
			fields.put("cuisine", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
			////////////////////////////////////////////////
	        
	        //3.display specific fields
			query = new BasicDBObject();
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
			fields.put("cuisine", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //4.display specific fields
			query = new BasicDBObject();
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
			fields.put("cuisine", 1);
			fields.put("address.zipcode", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //5.display restaurants in bronx
			query = new BasicDBObject();
			query.put("borough","Bronx");
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //6.display restaurants in bronx
			query = new BasicDBObject();
			query.put("borough","Bronx");
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
	        doclist = table.find(query,fields).limit(5);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //7.display restaurants in bronx
			query = new BasicDBObject();
			query.put("borough","Bronx");
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("borough", 1);
	        doclist = table.find(query,fields).skip(5).limit(5);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //8.display score more than 90
			query = new BasicDBObject();
			query.put("grades.score", new BasicDBObject("$gt",90));
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //9.display score more than 80 less than 100
			query = new BasicDBObject();
			query.put("grades.score", new BasicDBObject("$gt",80).append("$lt", 100));
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("grades.score", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
	        
	        //9.display latitude specific
			query = new BasicDBObject();
			query.put("address.coord", new BasicDBObject("$lt",-95.754168));
			fields = new BasicDBObject();
			fields.put("_id", 0);
			fields.put("restaurant_id", 1);
			fields.put("name", 1);
			fields.put("address.coord", 1);
	        doclist = table.find(query,fields);
	        while(doclist.hasNext()) {
                System.out.println(doclist.next());
            }
	        ////////////////////////////////////////////////
			}catch(Exception e){  
				System.out.println(e);  
			}  
	}  
}  