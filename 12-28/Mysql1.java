package com.miao.demo;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 * java�������ݿ�ʵ����ɾ�Ĳ�
 * 1.��
 *
 */
public class Mysql1 {
	//1.�������ݿ�  �û���  ����
	private static final String URL="jdbc:mysql://localhost:3306/addressbook";
	private static final String USER="root";
	private static final String PASSWORD="xg19970612";
	
	public static void main(String[] args){
		//2.������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//3.������ݿ�����
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//4.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
			Statement stmt = conn.createStatement();
			String str = "select list_name,list_sex from list";
			
			//5.ִ������
			ResultSet rs = stmt.executeQuery(str);
			
			//6.��������������ݣ�����ResultSet��ӡ
			while (rs.next()) {
				System.out.println(rs.getString("list_name") 
						+ rs.getString("list_sex"));
			}
			
			//�ر�
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
