package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

public class MemberAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //ctrl space 누르고 doget
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>회원등록2</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action='add' method='post'>");
		out.println("이름: <input type ='text' name= 'name'><br>");
		out.println("이메일: <input type ='text' name='email'><br>");
		out.println("암호: <input type ='password' name='password'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</form>");
		out.println("</body></html>");
			
}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		Connection conn= null;
		PreparedStatement stmt = null;
		
		try { 
			ServletContext ctx = this.getServletContext(); //crtl shift import
			Class.forName(ctx.getInitParameter("driver"));
			
			// 2.드라이버를 사용하여 MYSQL 서버와 연결하라.
			conn = DriverManager.getConnection(
					ctx.getInitParameter("url"),
					ctx.getInitParameter("username"),
					ctx.getInitParameter("password"));
			
		   /*DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/studydb", //jdbc url
					"root",//dbms 사용자 이름
					"root12"); //dbms 사용자 암호*/
		   
			stmt = conn.prepareStatement(
					"INSERT INTO MEMBERS(EMAIL, PWD, MNAME, CRE_DATE,MOD_DATE)"
					+ "VALUES (?,?,?,NOW(),NOW())");
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("password"));
			stmt.setString(3, request.getParameter("name"));
			stmt.executeUpdate();
			
			response.sendRedirect("list");// 회원 정보를 등록하고 나서 등록 성공을 출력하지 않음
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원등록결과</title>"
				+"<meta http-equiv='Refresh' content='1;url=list'>" //meta방법
				+"</head>");
			out.println("<body>");
			out.println("<p>등록 성공입니다!</p>");
			out.println("</body></html>");
				
			//리플레시 방법 1
			//response.setHeader("Refresh", "1;url=list"); //1초 지난 다음에 url list로 가라 . 덮어쓰는것
			//response.addHeader("Refresh", "1;url=list");// 추가 하는 것
			
		}catch (Exception e) {
			throw new ServletException(e);
		}finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}
