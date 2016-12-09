package sw.gmit.ie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	public ArrayList<Manufacturer> getManufacturers() throws Exception {
		ArrayList<Manufacturer> manufacturer = new ArrayList<Manufacturer>();
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * " +
														"FROM manufacturer");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()) {
			String code = rs.getString("manu_code");
			String name = rs.getString("manu_name");
			String details = rs.getString("manu_details");
			
			manufacturer.add(new Manufacturer(code, name, details));
		}
		
		return manufacturer;
	}
	
	public void addManufacturer(Manufacturer manufacturer) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO manufacturer " +
														"VALUES (?, ?, ?)");
		
		myStmt.setString(1, manufacturer.getManuCode());
		myStmt.setString(2, manufacturer.getManuName());
		myStmt.setString(3, manufacturer.getManuDetails());
		
		myStmt.executeUpdate();
		
		conn.close();
	}
	
	public void deleteManufacturer(String code) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("DELETE...");
		
		myStmt.executeUpdate();
		
		conn.close();
	}
	
	public void updateManufacturer(Manufacturer manufacturer) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("UPDATE manufacturer " +
														"SET manu_code = ?, manu_name = ?, manu_details = ?" +
														"WHERE manu_code = "+ manufacturer.getManuCode());  
		
		myStmt.setString(1, manufacturer.getManuCode());
		myStmt.setString(2, manufacturer.getManuName());
		myStmt.setString(3, manufacturer.getManuDetails());
		
		myStmt.executeUpdate();
		
		conn.close();
}
}