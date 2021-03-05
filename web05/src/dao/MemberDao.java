package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spms.vo.Member;

public class MemberDao {
	Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;	
	}
	public List<Member> selectList() throws Exception {
		Statement stmt=null;
		ResultSet rs = null;
		
		try {
		stmt = connection.createStatement();
		rs = stmt.executeQuery(
			"SELECT MNO,NMAME,EMAIL,CRE_DATE"+
				"FROM MEMBERS"+
					"ORDER BY MNO ASC");
		ArrayList<Member> members = new ArrayList<Member>();
		
		while (rs.next()) {
			members.add(new Member()
					.setNo(rs.getInt("MNO"))
					.setName(rs.getString("MNAME"))
					.setEmail(rs.getString("EMAIL"))
					.setCreatedDate(rs.getDate("CRE_DATE"))  );
		}
		return members;
		
		}catch (Exception e) {
			throw e;
			
		}finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public int insert(Member member) throws Exception { //회원등록
		PreparedStatement stmt = null;
		
		try {
		      stmt = connection.prepareStatement(
		          "INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE)"
		              + " VALUES (?,?,?,NOW(),NOW())");
		      stmt.setString(1, member.getEmail());
		      stmt.setString(2, member.getPassword());
		      stmt.setString(3, member.getName());
		      return stmt.executeUpdate();

		    } catch (Exception e) {
		      throw e;

		    } finally {
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    }
		  }
		
	public int delete(int no) throws Exception { //회원삭제
	 Statement stmt = null;
	
	try {
		 stmt = connection.createStatement();
	      return stmt.executeUpdate(
	          "DELETE FROM MEMBERS WHERE MNO=" + no);
	} catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	    }
	  }
	
	public Member selectOne(int no)throws Exception { //회원 상세 정보 조회
		Statement stmt =null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
				"SELECT MNO,EMAIL,MNAME,CRE_DATE FROM MEMBERS" + 
				              " WHERE MNO=" + no); 
			if (rs.next()) {
		        return new Member()
		        .setNo(rs.getInt("MNO"))
		        .setEmail(rs.getString("EMAIL"))
		        .setName(rs.getString("MNAME"))
		        .setCreatedDate(rs.getDate("CRE_DATE"));

		      } else {
		        throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
		      }

		    } catch (Exception e) {
		      throw e;
		    } finally {
		      try {if (rs != null) rs.close();} catch(Exception e) {}
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    }
		  }
		
	}
	
	

