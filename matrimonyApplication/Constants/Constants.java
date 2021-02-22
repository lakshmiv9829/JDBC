package com.xworkz.matrimonyApplication.Constants;

public class Constants {
public static final String DB_URL="jdbc:mysql://localhost:3306";
public static final String USER_NAME="root";
public static final String PASSWORD="Lakshmi"; 
public static final String INSERT_QUERY="insert into matrimony.bride values(%s,'%s',%s,%s,%s,'%s','%s','%s',%s,'%s')";
public static final String UPDATE_QUERY="update matrimony.bride set qualification=?,salary=? where id=?";
public static final String DELETE_QUERY="delete from matrimony.bride where id=?";
}
