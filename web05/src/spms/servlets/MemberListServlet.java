package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//ctrl shift O 자동 임포트 됨
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.vo.Member;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
	//UI 출력 코드를 제거하고, UI 생성 및 출력을 JSP에게 위임한다.
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1.사용할 JDBC 드라이버를 등록하라.
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//ServletConfig config = this.getServletConfig();
			//Class.forName(config.getInitParameter("driver")); 
			
			//클래스 로딩 못 했다. jdbc 드라이버가  없어서 로딩을 못 하면 ..classnotfound예외처리 아래 try catch 문..
			//Class.forName(this.getInitParameter("driver")); //config로 우회해서 호출하지 않고 바로 호출하는 클래스 
			
			ServletContext sc = this.getServletContext(); //crtl shift import
			Class.forName(sc.getInitParameter("driver"));
			// 2.드라이버를 사용하여 MYSQL 서버와 연결하라.
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
		    //con = DriverManager.getConnection("jdbc:mysql://localhost/studydb", "root", "root12");
			//자바 소스에 구체적으로 적혀있는 jdbs 관련 정보를 바깥으로 분리, 자바에서 참조하도록, web.xml만 수정하면 됨
					
			// 3.커넥션 객체로부터 SQL을 던질 객체를 준비하라. 
			stmt = conn.createStatement();
			
			// 4.SQL을 던지는 객체를 사용하여 서버에 질의하라.
			rs = stmt.executeQuery
			("select MNO,MNAME,EMAIL,CRE_DATE"+" from MEMBERS"+" order by MNO ASC");//회원번호를 작은 숫자에서 큰 숫자로 커지도록, 띄어쓰기 
			
			// 5.서버에 가져온 데이터를 사용하여 HTML을 만들어서 웹 브라우저로 출력하라. 
			response.setContentType("text/html; charset=UTF-8"); 
			ArrayList<Member> members = new ArrayList<Member>();//웹브라우저에게 출력할게 무엇인지 , 추억할때 사용할 인코딩은 어떤 형식으로 코드화 시켜서 웹 브라우저에 전달할지
			//데이터베이스에 회원정보를 가져와 Member에 담는다.
			//그리고 Member 객체를 ArrayList에 추가한다.
			while(rs.next()) {
				members.add(new Member()
										.setNo(rs.getInt("MNO"))
										.setName(rs.getString("MNAME"))
										.setEmail(rs.getString("EMAIL"))
										.setCreatedDate(rs.getDate("CRE_DATE")) );
										
			}
			
			//request에 회원 목록 데이터를 보관한다.
			request.setAttribute("members",members);
			
			//JSP로 출력을 위임한다.
			RequestDispatcher rd = request.getRequestDispatcher(
					"/member/MemberList.jsp");
			rd.include(request,response);
			
		
			
			/* UI 출력 코드를 제거하고, UI생성 및 출력을 JSP에게 위임한다. 
			 * PrintWriter out = response.getWriter();
			out.println("<html><head><title>회원목록</title></head><body>");
			out.println("<h1> 회원 목록 </h1>");
			out.println("<p><a href='add'>신규 회원 </a></p>");
			
			Member member = new Member();
			member.getNo();
			
			while (rs.next()) {//반복문을 돌면서 가져옴
				out.println(
						rs.getInt("MNO") + "," +
						"<a href='update?no=" + rs.getInt("MNO") + "'>" +
						rs.getString("MNAME") + "</a>," +
						rs.getString("EMAIL") + "," + 
						rs.getDate("CRE_DATE") + "<br>"
					);
			}
			out.println("</body></html>");*/
		 
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
			try{if(rs != null) rs.close();} catch(Exception e) {}
			try{if(stmt != null) stmt.close();} catch(Exception e) {}
			try{if(conn != null) conn.close();} catch(Exception e) {}
			
		
//ctrl+i 정렬
		}
		 
	}
	
	
	

}
