package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.List;

import constants.Status;
import dto.KanbanDto;
import service.KanbanException;

import java.sql.*;
import java.util.ArrayList;

public class KanbanDao {
	
	// 추가
	public void register(KanbanDto kanban) {

		String sql = "INSERT INTO works (status, workNm) VALUES(?,?)";
		
		try (Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, kanban.getStatus().toString());
			pstmt.setString(2, kanban.getWorkNm().trim());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new KanbanException("등록에 실패하였습니다.");
		}

	}

	// 수정
	public void update(KanbanDto kanban) {

		String sql = "UPDATE works" + " SET" + "	status = ?, " + "	workNm = ? " + " WHERE id = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, kanban.getStatus().toString());
			pstmt.setString(2, kanban.getWorkNm());
			pstmt.setInt(3, kanban.getId());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new KanbanException("수정에 실패하였습니다.");
		}

	}


	// 삭제
	public void delete(KanbanDto kanban) {
		delete(kanban.getId());
	}

	public void delete(int id) {
		String sql =  "DELETE FROM works WHERE id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new KanbanException("삭제에 실패하였습니다.");
		}
	}

	// 목록 조희
	public List<KanbanDto> gets() {
		
		List<KanbanDto> list = new ArrayList<>();
		
		String sql = "SELECT * FROM works ORDER BY id DESC";
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LocalDateTime modDt = null;
				Timestamp _modDt = rs.getTimestamp("modDt");
				
				if(_modDt != null) {
					modDt = _modDt.toLocalDateTime();
				}
				list.add(new KanbanDto(
				rs.getInt("id"),
				Enum.valueOf(Status.class, rs.getString("status")),
				rs.getString("workNm"),
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
	public KanbanDto get(int id) {
		KanbanDto kanban = null;
		
		String sql = "SELECT * FROM works WHERE id = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					LocalDateTime modDt = null;
					Timestamp _modDt = rs.getTimestamp("modDt");
					if(_modDt != null) {
						modDt = _modDt.toLocalDateTime();
					}
					kanban = new KanbanDto(
							rs.getInt("id"),
							Enum.valueOf(Status.class, rs.getString("status")),
							rs.getString("workNm"),
							rs.getTimestamp("regDt").toLocalDateTime(),
							modDt
							);
				}
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return kanban;
	}

	// Connection 객체
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/kanban?user=root&password=als@1655119";
		Connection conn = DriverManager.getConnection(url);

		return conn;
	}
}
