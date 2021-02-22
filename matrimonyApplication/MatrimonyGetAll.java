package com.xworkz.matrimonyApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimonydto.BrideDTO;

public class MatrimonyGetAll {

	public static void main(String[] args) {
	Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "Lakshmi");
			System.out.println("driver is connected to database");
			Statement stmt=connection.createStatement();
			ResultSet resultSet=stmt.executeQuery("Select * from matrimony.bride");
			List<BrideDTO> list=new ArrayList<BrideDTO>();
			while(resultSet.next()) {
				BrideDTO bride=new BrideDTO();
				bride.setId(resultSet.getInt(1));
				bride.setName(resultSet.getString(2));
				bride.setAge(resultSet.getInt(3));
				bride.setHeight(resultSet.getDouble(4));
				bride.setWeight(resultSet.getDouble(5));
				bride.setQualification(resultSet.getString(6));
				bride.setExpectation(resultSet.getString(7));
				bride.setPhone_number(resultSet.getString(8));
				bride.setSalary(resultSet.getInt(9));
				bride.setOccupatation(resultSet.getString(10));
				list.add(bride);
				}
			
			list.forEach(e->System.out.println(e));
			
		} catch (SQLException e) {
			System.out.println("driver is not connected to database");
			e.printStackTrace();
		}
	}

}
