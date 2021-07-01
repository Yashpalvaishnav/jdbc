package com.te.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

public class IntsertQuery {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			FileInputStream fileio = new FileInputStream("File.properties");

			Properties pro = new Properties();

			pro.load(fileio);
			Class.forName(pro.getProperty("Driver"));

			con = DriverManager.getConnection(pro.getProperty("dburl"));

			stmt = con.createStatement();

			int result = stmt.executeUpdate(pro.getProperty("query"));
			if (result != 0) {
				System.out.println(result + "no of rows effected");
				System.out.println("Data inserted succesfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}
