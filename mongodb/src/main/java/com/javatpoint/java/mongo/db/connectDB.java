package com.javatpoint.java.mongo.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class connectDB {
	static DB db=null;
	@SuppressWarnings({ "resource", "deprecation" })
	public static DB getDatabase(){
		try{  
			//---------- Connecting DataBase -------------------------//  
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
			//---------- Creating DataBase ---------------------------//  
			db = mongoClient.getDB("myDB"); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return db;
	}
	 	
}
