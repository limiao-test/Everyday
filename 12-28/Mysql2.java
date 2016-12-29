package com.miao.demo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * 增删改查
 */
public class Mysql2 {
	//1.定义数据库  用户名  密码
    private static final String URL="jdbc:mysql://localhost:3306/addressbook";
	private static final String USER="root";
	private static final String PASSWORD="xg19970612";
	
	//包装必要的前两步：驱动加载和获得数据库连接
	public static Connection getCon() throws Exception{
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	/**
	 * 增
	 */
	public void test1() throws Exception{
		//通过直接调用getCon()方法
		Connection conn = getCon();
		//3.操作数据库  实现增加
		String sql = "insert into list(list_ID,list_name,list_sex,"
				+ "list_mobile_number,list_birthday,list_address)"+
				"values(?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.绑定数据
		ptmt.setInt(1, 8);
		ptmt.setString(2, "xiaojiang");
		ptmt.setString(3, "man");
		ptmt.setString(4, "1332453978");
		ptmt.setString(5, "2015-3-12");
		ptmt.setString(6, "Beilin");
		
		int resultCount = ptmt.executeUpdate();
		//判断是否增加成功
		if (resultCount == 1) {
			System.out.println("Article add success");
		} else {
			System.out.println("Article add fail");
		}
	}
	
	/**
	 * 删
	 */
	public void test2() throws Exception{
		Connection conn = getCon();
		//3.操作数据库  实现删除
		String sql = "delete from list where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.绑定参数
		ptmt.setInt(1, 8);
		//5.执行修改
		int update = ptmt.executeUpdate();
		//6.判断是否删除
		if (1==update) {
			System.out.println("update success");
		} else {
            System.out.println("update fail");
		}
	}
	
	/**
	 * 改
	 */
	public void test3() throws Exception{
		//获得getCon()方法的对象
		Connection conn = getCon();
		//3.操作数据库 实现修改
		String sql = "update list set list_name=?,list_sex=?,"
				+ "list_mobile_number=?,list_birthday=?,list_address=?"+
				"where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//4.绑定参数
		ptmt.setString(1, "Srroa");
		ptmt.setString(2, "woman");
		ptmt.setString(3, "12344556777");
		ptmt.setString(4, "1999-4-3");
		ptmt.setString(5, "shanxi");
		ptmt.setInt(6, 8);
		//5.执行请求
		int result = ptmt.executeUpdate();
		//6.判断是否修改成功
		if (1 == result) {
			System.out.println("update success");
		} else {
			System.out.println("update fail");
		}
	}
	
	/**
	 * 查
	 */
	public void test4() throws Exception{
	
		//获得getCon()方法的对象
		Connection conn = getCon();
		
		//3.操作数据库 实现查
		String sql = "select * from list where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.绑定参数
		ptmt.setInt(1, 3);
		
		//5.执行请求
		ResultSet rs = ptmt.executeQuery();
		
		//6.如果对象中有数据，遍历ResultSet打印
		while (rs.next()) {
			System.out.println("list_ID:" + rs.getString("list_ID") 
			+"\nlist_name:" +rs.getString("list_name"));
		}
	}
	
}
