package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 //ctrl shift O 자동 임포트 됨


public class MemberListServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1.사용할 JDBC 드라이버를 등록하라.
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//ServletConfig config = this.getServletConfig();
			//Class.forName(config.getInitParameter("driver")); 
			
			//클래스 로딩 못 했다. jdbc 드라이버가  없어서 로딩을 못 하면 ..classnotfound예외처리 아래 try catch 문..
			//Class.forName(this.getInitParameter("driver")); //config로 우회해서 호출하지 않고 바로 호출하는 클래스 
			
			ServletContext ctx = this.getServletContext(); //crtl shift import
			Class.forName(ctx.getInitParameter("driver"));
			
			// 2.드라이버를 사용하여 MYSQL 서버와 연결하라.
			con = DriverManager.getConnection(
					ctx.getInitParameter("url"),
					ctx.getInitParameter("username"),
					ctx.getInitParameter("password"));
		    //con = DriverManager.getConnection("jdbc:mysql://localhost/studydb", "root", "root12");
			//자바 소스에 구체적으로 적혀있는 jdbs 관련 정보를 바깥으로 분리, 자바에서 참조하도록, web.xml만 수정하면 됨
					
			// 3.커넥션 객체로부터 SQL을 던질 객체를 준비하라. 
			stmt = con.createStatement();
			
			// 4.SQL을 던지는 객체를 사용하여 서버에 질의하라.
			rs = stmt.executeQuery
			("select MNO,MNAME,EMAIL,CRE_DATE"+" from MEMBERS"+" order by MNO ASC");//회원번호를 작은 숫자에서 큰 숫자로 커지도록, 띄어쓰기 
			
			// 5.서버에 가져온 데이터를 사용하여 HTML을 만들어서 웹 브라우저로 출력하라. 
			response.setContentType("text/html; charset=UTF-8"); //웹브라우저에게 출력할게 무엇인지 , 추억할때 사용할 인코딩은 어떤 형식으로 코드화 시켜서 웹 브라우저에 전달할지
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원목록</title></head><body>");
			out.println("<h1> 회원 목록 </h1>");
			out.println("<p><a href='add'>신규 회원 </a></p>");
			
			while (rs.next()) {//반복문을 돌면서 가져옴
				out.println(
						rs.getInt("MNO") + "," +
						"<a href='update?no=" + rs.getInt("MNO") + "'>" +
						rs.getString("MNAME") + "</a>," +
						rs.getString("EMAIL") + "," + 
						rs.getDate("CRE_DATE") + "<br>"
					);
			}
			out.println("</body></html>");
		 
		/*try{rs.close(); //해제 시켜주는 객체 con>stmt>rs 거꾸로 순서 ,예외가 발생하더라도 무시하자
		}catch(Exception e) {}
		try{stmt.close();} catch(Exception e) {}
		try{con.close();} catch(Exception e) {}
		}catch (SQLException e) {
		throw new ServletException(e); //예외가 뜨면 톰캣에 던짐 */
		
		} catch(Exception e ) {
			throw new ServletException(e);
		
		// ^ classnotfound, sql Exception을 한꺼번에 몰아 준 것 
		/*
		}catch (ClassNotFoundException e ) {
			throw new ServletException(e);
		
		
		} catch (SQLException e) {
			throw new ServletException(e);
		*/ 
			
		}finally { 
			//밑에 가기 전 예외가 뜬다면 중간의 /*try catch*/ 문은 실행할 기회조차 없다. 
			//finally는 에러가 뜨나 정상수행되나 무조건 자원해지를 수행한다. 
			//try블록에 있는 변수는 finally 블록에서 적응할 수 없다.
			try{rs.close();} catch(Exception e) {}
			try{stmt.close();} catch(Exception e) {}
			try{con.close();} catch(Exception e) {}
			
		
//ctrl+i 정렬
		}
		 
	}
	
	
	

}