package com.xworkz.matrimonyApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.matrimonydao.MatrimonyDAO;
import com.xworkz.matrimonydao.MatrimonyDAOImpl;
import com.xworkz.matrimonydto.BrideDTO;
import com.xworkz.matrimonyservice.MatrimonyService;
import com.xworkz.matrimonyservice.MatrimonyServiceImpl;

public class MatrimonyApplication {

	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");// this is responosible for load and register//
//			System.out.println("driver loaded successfully");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	//}
//		Connection connection=null;
//		try {
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Lakshmi");
//			System.out.println("connected with data base");
//			Statement stmt=connection.createStatement();
//			ResultSet resultSet=stmt.executeQuery("select * from matrimony.bride where id=1;");
//			BrideDTO bride=new BrideDTO();
//			resultSet.next();
//				bride.setId(resultSet.getInt(1));
//				bride.setName(resultSet.getNString(2));
//				bride.setAge(resultSet.getInt(3));
//				bride.setHeight(resultSet.getDouble(4));
//				bride.setWeight(resultSet.getDouble(5));
//				bride.setQualification(resultSet.getString(6));
//				bride.setExpectation(resultSet.getString(7));
//				bride.setPhone_number(resultSet.getString(8));
//				bride.setSalary(resultSet.getInt(9));
//				bride.setOccupatation(resultSet.getString(10));
//				//bride.setAddress(resultSet.getString(11));
//			
//			System.out.println(bride);
//		} 
//		catch (SQLException e) {  //e contains discreption of exception its tell where is the mistake
//			System.out.println("Failed to connect to data base");
//			e.printStackTrace();
//		}
//	
//	finally {
//		try {
//			connection.close();
//			System.out.println("connection closed");
//		} catch (SQLException e) {
//			System.out.println("connection not closed");
//			e.printStackTrace();
//		}
//	}
//
//	}
		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
		BrideDTO brideDTO=matrimonyService.getBride(1);
		if(brideDTO!=null) {
		System.out.println(brideDTO);
		}
		matrimonyService.getAllBride();
}
}	
