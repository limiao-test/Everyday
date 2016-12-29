package com.miao.demo;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 * java连接数据库实现增删改查
 * 1.查
 *
 */
public class Mysql1 {
	//1.定义数据库  用户名  密码
	private static final String URL="jdbc:mysql://localhost:3306/addressbook";
	private static final String USER="root";
	private static final String PASSWORD="xg19970612";
	
	public static void main(String[] args){
		//2.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//3.获得数据库连接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//4.通过数据库的连接操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			String str = "select list_name,list_sex from list";
			
			//5.执行请求
			ResultSet rs = stmt.executeQuery(str);
			
			//6.如果对象中有数据，遍历ResultSet打印
			while (rs.next()) {
				System.out.println(rs.getString("list_name") 
						+ rs.getString("list_sex"));
			}
			
			//关闭
			conn.close();
			stmt.close();
			rs.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
