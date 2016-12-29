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
		
		//1.��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2. ������ݿ�����
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		    
			//3.����bFlagֵ��true�� ����ִ����һ��
			boolean bFlag = true;
			
			//4.�������ݿ� ʵ����ɾ�Ĳ�
			String strSql = "select * from list where list_ID=?";
			PreparedStatement stmt = conn.prepareStatement(strSql);
			//5.������
			stmt.setInt( 1, uid);
			//6.ִ������
			ResultSet rs = stmt.executeQuery();
		    //7.�������һ��  ���
			if(rs.next()){
				System.out.println("list is exists.");
			}else {
				System.out.println("list is not exists.");
			}
			//��bFlagֵΪfalseʱ  ���ء�
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
