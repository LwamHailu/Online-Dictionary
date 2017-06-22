package com.mezgebekalat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mezgebekalat.model.Word;

public class DictDao {
	public static Connection connection;

	public DictDao() {
		connection = DbConnection.getDBConnection();
	}

	public static Connection getConnection() {
		return connection;
	}

	public  List<Word> findByWord(String word) {
		List<Word> results = new ArrayList<>();
		if (connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from entries where word = '" + word +"'");

				while (rs.next()) {
					results.add(new Word(rs.getString(1), rs.getString(2), rs.getString(3)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}
	
//	public static void main(String[] args){
//		DictDao dao = new DictDao();
//		for(Word w : dao.findByWord("Test")){
//			System.out.println(w.toString());
//		}
//	}
}