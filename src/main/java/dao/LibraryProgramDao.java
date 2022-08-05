package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.LibaryProgramDto;
import service.LibException;

public class LibraryProgramDao {

	
	public void register(LibaryProgramDto lib) {
		
		String sql = "INSERT INTO works(status, workNm) VALUES(?,?)";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, lib.getStatus().toString());
				pstmt.setString(2, lib.getWorkNm().trim());
				pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new LibException("도서대출 등록에 실패하였습니다.")
		}
	}
	
public void update(LibaryProgramDto lib) {
		
		String sql = "INSERT INTO works(status, workNm) VALUES(?,?)";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, lib.getStatus().toString());
				pstmt.setString(2, lib.getWorkNm().toString());
				pstmt.setInt(3, lib.getId());
				pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new LibException("도서 변경에 실패하였습니다..");
		}
	}

	private Connection getConnection() throws  ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/LibraryPgram?user=root&password=als@1655119";
				Connection conn = DriverManager.getConnection(url);
		return conn;
	}
		
		
	
}
