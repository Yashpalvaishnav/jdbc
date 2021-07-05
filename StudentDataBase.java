package com.te.assignment;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class StudentDataBase {
	Connection con = null;
	Statement stmt = null;

	public void update() {
		try {
			FileInputStream fileio = new FileInputStream("File.properties");

			Properties pro = new Properties();

			pro.load(fileio);
			Class.forName(pro.getProperty("Driver"));

			con = DriverManager.getConnection(pro.getProperty("dburl"));

			stmt = con.createStatement();

			int result = stmt.executeUpdate(pro.getProperty("query3"));
			if (result != 0) {
				System.out.println(result + "no of rows effected");
				System.out.println("the row deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void Select() {
		try {
			FileInputStream fileio = new FileInputStream("File.properties");

			Properties pro = new Properties();

			pro.load(fileio);
			Class.forName(pro.getProperty("Driver"));

			con = DriverManager.getConnection(pro.getProperty("dburl"));

			stmt = con.createStatement();

			ResultSet result = stmt.executeQuery("query4");
			while (result.next()) {
				System.out.println("id:" + result.getInt(1));
				System.out.println("name:" + result.getString(2));
				System.out.println("marks" + result.getDouble(3));
				System.out.println("Address"+result.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Delete() {
		try {
			FileInputStream fileio = new FileInputStream("File.properties");

			Properties pro = new Properties();

			pro.load(fileio);
			Class.forName(pro.getProperty("Driver"));

			con = DriverManager.getConnection(pro.getProperty("dburl"));

			stmt = con.createStatement();

			int result = stmt.executeUpdate(pro.getProperty("query2"));
			if (result != 0) {
				System.out.println(result + "no of rows effected");
				System.out.println("the row deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void Insert() {
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

