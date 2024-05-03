package com.besant;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentDetails extends HttpServlet {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	String url="jdbc:mysql://localhost:3306/rollnumber";
	String un="root";
	String ps="bhargavi@1";
	String qry="insert into result values(?,?,?,?,?)";
	
	
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded successfully");
			
			con=DriverManager.getConnection(url,un,ps);
			System.out.println("Connection Established");
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			pstmt=con.prepareStatement(qry);
			
			String name=req.getParameter("n");
//			System.out.println(name);
			
			String pr=req.getParameter("rn");
//			System.out.println(pr);
			
			
			int rollnumber=Integer.parseInt(pr);
//			System.out.println(rollnumber);
			
			String fr=req.getParameter("f");
//			System.out.println(fr);
			
			int frontend=Integer.parseInt(fr);
//			System.out.println(frontend);
			
			String jr=req.getParameter("j");
//			System.out.println(jr);
			
			int java=Integer.parseInt(jr);
//			System.out.println(java);
			
			String sr=req.getParameter("s");
//			System.out.println(sr);
			
			int sql=Integer.parseInt(sr);
//			System.out.println(sql);
			
			System.out.println(name+"  "+rollnumber+"  "+frontend+"  "+java+"  "+sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, rollnumber);
			pstmt.setInt(3, frontend);
			pstmt.setInt(4, java);
			pstmt.setInt(5, sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
		}
		
	}



}
