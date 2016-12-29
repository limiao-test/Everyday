package com.miao.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;



public class Demo {
	//1.定义数据库  用户名  密码
	public static final String URL="jdbc:mysql://localhost:3306/addressbook";
	public static final String USER="root";
	public static final String PASSWORD="xg19970612";
	
	public static void main(String[] args) throws Exception{
		//2.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//3.获得数据连接
		Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
		
		//4.操作数据库，实现增删改查
//		String sql ="select * from list where list_ID=?";
		Statement stmt = conn.createStatement();
		String str = "SELECT list_name, list_ID FROM list";
		
		//5.执行请求
		ResultSet rs = stmt.executeQuery(str);
		
		//遍历ResultSet
		while(rs.next()){
            System.out.println(rs.getString("list_name")+
            		" ID："+rs.getInt("list_ID"));
		}
		conn.close();
		stmt.close();
		rs.close();
	}
	
}