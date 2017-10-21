package org.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.cat.domain.Kot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCCatDAO {

	Connection conn;
	
	@Autowired
	private DataSource dataSource;
	
	public void insert(Kot kot) {
		String sql = "INSERT INTO KDK.KOTY (ID, IMIE, WAGA, IMIEOPIEKUNA) VALUES ('4', 'Balas', '11,00', 'Marek')";
		conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, customer.getCustId());
//			ps.setString(2, customer.getName());
//			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Kot findCatbyName(String imie) {
		
		String sql = "SELECT * FROM koty WHERE imie = ?";
		
		conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, imie);
			Kot kot = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				kot = new Kot();
				kot.getAllIfnomration();
			}
			rs.close();
			ps.close();
			return kot;
		}catch (SQLException e){
			System.out.println("B³¹d: " + e);
			throw new RuntimeException(e);
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					
				}
			}
		}
		
	}
}
