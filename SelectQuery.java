package com.te.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectQuery {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt=null;
		try {
			FileInputStream fileio = new FileInputStream("File.properties");

			Properties pro = new Properties();

			pro.load(fileio);
			Class.forName(pro.getProperty("Driver"));

			con = DriverManager.getConnection(pro.getProperty("dburl"));

			stmt = con.createStatement();

			ResultSet result = stmt.executeQuery("query4");
			while(result.next()) {
				System.out.println("id:"+result.getInt(1));
				System.out.println("name:"+result.getString(2));
				System.out.println("address:"+result.getString(3));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
