package com.xworkz.matrimonyApplication;

import static com.xworkz.matrimonyApplication.Constants.Constants.DB_URL;
import static com.xworkz.matrimonyApplication.Constants.Constants.PASSWORD;
import static com.xworkz.matrimonyApplication.Constants.Constants.USER_NAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionManagementApplication {

	public static void main(String[] args) {
		Connection con=null;
		Savepoint savePoint=null;
		//metadata--->assignmenet.
		try {
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			String query1="insert into matrimony.bride values(7,'Rakshitha',22,4.6,45,'B.E','kind hearted','7643654226',300000,'Engineere')";
			String query2="insert into matrimony.bride values(6,'Vaishnavi',22,4.0,40,'B.E','doctor','7369290484',500000,'developer')";
			String query3="update matrimony.bride set expectation='Full Stack' where id=1";
			String query4="delete from matrimony.bride where id=5";
			stmt.executeUpdate(query1);
			//savePoint=con.setSavepoint();
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			stmt.executeUpdate(query4);
			System.out.println("success");
			con.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
			try {
			con.rollback();
			con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
					}	
	finally {
		try {
			con.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
		}
	
}


