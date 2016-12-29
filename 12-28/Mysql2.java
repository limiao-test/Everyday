package com.miao.demo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * ��ɾ�Ĳ�
 */
public class Mysql2 {
	//1.�������ݿ�  �û���  ����
    private static final String URL="jdbc:mysql://localhost:3306/addressbook";
	private static final String USER="root";
	private static final String PASSWORD="xg19970612";
	
	//��װ��Ҫ��ǰ�������������غͻ�����ݿ�����
	public static Connection getCon() throws Exception{
		//1.��������
		Class.forName("com.mysql.jdbc.Driver");
		//2.������ݿ�����
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	/**
	 * ��
	 */
	public void test1() throws Exception{
		//ͨ��ֱ�ӵ���getCon()����
		Connection conn = getCon();
		//3.�������ݿ�  ʵ������
		String sql = "insert into list(list_ID,list_name,list_sex,"
				+ "list_mobile_number,list_birthday,list_address)"+
				"values(?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.������
		ptmt.setInt(1, 8);
		ptmt.setString(2, "xiaojiang");
		ptmt.setString(3, "man");
		ptmt.setString(4, "1332453978");
		ptmt.setString(5, "2015-3-12");
		ptmt.setString(6, "Beilin");
		
		int resultCount = ptmt.executeUpdate();
		//�ж��Ƿ����ӳɹ�
		if (resultCount == 1) {
			System.out.println("Article add success");
		} else {
			System.out.println("Article add fail");
		}
	}
	
	/**
	 * ɾ
	 */
	public void test2() throws Exception{
		Connection conn = getCon();
		//3.�������ݿ�  ʵ��ɾ��
		String sql = "delete from list where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.�󶨲���
		ptmt.setInt(1, 8);
		//5.ִ���޸�
		int update = ptmt.executeUpdate();
		//6.�ж��Ƿ�ɾ��
		if (1==update) {
			System.out.println("update success");
		} else {
            System.out.println("update fail");
		}
	}
	
	/**
	 * ��
	 */
	public void test3() throws Exception{
		//���getCon()�����Ķ���
		Connection conn = getCon();
		//3.�������ݿ� ʵ���޸�
		String sql = "update list set list_name=?,list_sex=?,"
				+ "list_mobile_number=?,list_birthday=?,list_address=?"+
				"where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//4.�󶨲���
		ptmt.setString(1, "Srroa");
		ptmt.setString(2, "woman");
		ptmt.setString(3, "12344556777");
		ptmt.setString(4, "1999-4-3");
		ptmt.setString(5, "shanxi");
		ptmt.setInt(6, 8);
		//5.ִ������
		int result = ptmt.executeUpdate();
		//6.�ж��Ƿ��޸ĳɹ�
		if (1 == result) {
			System.out.println("update success");
		} else {
			System.out.println("update fail");
		}
	}
	
	/**
	 * ��
	 */
	public void test4() throws Exception{
	
		//���getCon()�����Ķ���
		Connection conn = getCon();
		
		//3.�������ݿ� ʵ�ֲ�
		String sql = "select * from list where list_ID=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//4.�󶨲���
		ptmt.setInt(1, 3);
		
		//5.ִ������
		ResultSet rs = ptmt.executeQuery();
		
		//6.��������������ݣ�����ResultSet��ӡ
		while (rs.next()) {
			System.out.println("list_ID:" + rs.getString("list_ID") 
			+"\nlist_name:" +rs.getString("list_name"));
		}
	}
	
}
