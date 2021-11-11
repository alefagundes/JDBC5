package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;
import db.DbIntegrityExeption;

public class Program {

	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "id = ?");// o interrogacao sera substiruido pelo valor setado no st.setInt(1 sendo o "?" e 5 o valor);
			
			st.setInt(1, 5);
			
			int rowAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected:" + rowAffected);
			
		}catch(SQLException e) {
			throw new DbIntegrityExeption(e.getMessage());
		
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
