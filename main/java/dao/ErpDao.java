package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import constants.Sports;
import service.ErpException;
import dto.ErpDto;

public class ErpDao {
	//추가
	public void register(ErpDto erpdto) {
		
		String sql = "INSERT INTO works (sports, sportNm, workoutSet, workoutNum) VALUES(?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, erpdto.getSports().toString());
				pstmt.setString(2, erpdto.getSportNm().trim());
				pstmt.setInt(3, erpdto.getWorkoutSet());
				pstmt.setInt(4, erpdto.getWorkoutNum());
				
				pstmt.executeUpdate();
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ErpException("등록에 실패하였습니다.");
		}
	}
	
	//수정
	public void update(ErpDto erpdto) {
		
		String sql = "UPDATE works" +
					 " SET " +
					 " 		sports = ? " +
					 " 		sportNm = ? " +
					 "  	workoutSet = ? " +
					 "   	workoutNum = ? " +
					 " WHERE id = ?";
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
						
				pstmt.setString(1, erpdto.getSports().toString());
				pstmt.setString(2, erpdto.getSportNm());
				pstmt.setInt(3, erpdto.getWorkoutSet());
				pstmt.setInt(4, erpdto.getWorkoutNum());
				pstmt.setInt(5, erpdto.getId());
				
				pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ErpException("수정에 실패하였습니다.");
		}
	}
	
	//삭제
	public void delete(ErpDto erpdto) {
		delete(erpdto.getId());
	}
	
	public void delete(int id) {
		String sql ="DELETE FROM works WHERE id = ?";
		
		try(Connection conn = getConnection();
				
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ErpException("삭제에 실패하였습니다.");
		}
	}
	
	//목록 조회
	public List<ErpDto> gets(){
		
		String sql = "SELECT * FROM works ORDER BY id DESC";
		
		List<ErpDto> list = new ArrayList<>();
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			Timestamp _modDt = rs.getTimestamp("modDt");
			while(rs.next()) {
				LocalDateTime modDt = null;
				if(_modDt != null) {
					modDt = _modDt.toLocalDateTime(); 
				}
				
				
			list.add(new ErpDto(
					rs.getInt("id"),
					Enum.valueOf(Sports.class, rs.getString("sports")),
					rs.getString("sportNm"),
					rs.getInt("workoutSet"),
					rs.getInt("workoutNum"),
					rs.getTimestamp("regDt").toLocalDateTime(),
					modDt
					));
			}
			rs.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();	
		}
		return list;
	}
	
	//작업 조회
	public ErpDto get(int id) {
		ErpDto erpdto = null;
		String sql = "SELECT * FROM works WHERE id = ?";
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					LocalDateTime modDt = null;
					Timestamp _modDt = rs.getTimestamp("modDt");
					if(_modDt != null) {
						modDt = _modDt.toLocalDateTime(); 
					}
					erpdto = new ErpDto(
							rs.getInt("id"),
							Enum.valueOf(Sports.class, rs.getString("sports")),
							rs.getString("sportNm"),
							rs.getInt("workoutSet"),
							rs.getInt("workoutNum"),
							rs.getTimestamp("regDt").toLocalDateTime(),
							modDt
							);
					
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();	
		}
		
		return erpdto;
		
	}
	//Connection 객체
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/erp?user=root&password=als@1655119";
		Connection conn = DriverManager.getConnection(url);
		
		return conn;
		
	}
}
