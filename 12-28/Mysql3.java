package com.miao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql3 {
	private static final String URL="jdbc:mysql://localhost:3306/addressbook";
	private static final String USER="root";
	private static final String PASSWORD="xg19970612";
	
	public static void main(String[] args) {
		int uid = 8;
		
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. 获得数据库连接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		    
			//3.假设bFlag值是true的 继续执行下一步
			boolean bFlag = true;
			
			//4.操作数据库 实现增删改查
			String strSql = "select * from list where list_ID=?";
			PreparedStatement stmt = conn.prepareStatement(strSql);
			//5.绑定数据
			stmt.setInt( 1, uid);
			//6.执行请求
			ResultSet rs = stmt.executeQuery();
		    //7.如果有下一个  输出
			if(rs.next()){
				System.out.println("list is exists.");
			}else {
				System.out.println("list is not exists.");
			}
			//当bFlag值为false时  返回。
			if(bFlag == false){
				System.out.println("Check not pass.");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
