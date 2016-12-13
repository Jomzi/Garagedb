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
	
	public Manufacturer getManufacturer(String manuCode) throws Exception {
		
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * " +
														"FROM manufacturer " + 
														"WHERE manu_code = ? ");
		
		myStmt.setString(1, manuCode);
		
		ResultSet rs = myStmt.executeQuery();
		
		if(rs.next()) {
			String code = rs.getString("manu_code");
			String name = rs.getString("manu_name");
			String details = rs.getString("manu_details");	
			
			return new Manufacturer(code, name, details);
		} else {
			return null;
		}	
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
		PreparedStatement myStmt = conn.prepareStatement("DELETE FROM manufacturer WHERE " +
															"manu_code= '" + code + "'");
		
		myStmt.executeUpdate();
		
		conn.close();
	}
	
	public void updateManufacturer(Manufacturer manufacturer) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("UPDATE manufacturer " +
														"SET  manu_name = ?, manu_details = ? " +
														"WHERE manu_code = '"+ manufacturer.getManuCode() + "'");  
		
		myStmt.setString(1, manufacturer.getManuName());
		myStmt.setString(2, manufacturer.getManuDetails());
		
		myStmt.executeUpdate();
		
		conn.close();
	}
	
	// Model helper methods
	public ArrayList<Model> getModels() throws Exception {
		ArrayList<Model> models = new ArrayList<Model>();
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * " +
														"FROM model");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()) {
			String manucode = rs.getString("manu_code");
			String modelcode = rs.getString("model_code");
			String modelname = rs.getString("model_name");
			String modeldesc = rs.getString("model_desc");
			
			models.add(new Model(manucode, modelcode, modelname, modeldesc));
		}
		
		return models;
	}	
	
	public void addModel(Model model) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO model " +
														"VALUES (?, ?, ?, ?)");
		
		myStmt.setString(1, model.getManuCode());
		myStmt.setString(2, model.getModelCode());
		myStmt.setString(3, model.getModelName());
		myStmt.setString(4, model.getModelDesc());
		
		myStmt.executeUpdate();
		
		conn.close();
	}	
	
	// Vehicle helper methods
	public ArrayList<Vehicle> getVehicles() throws Exception {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * " +
														"FROM vehicle");
		
		ResultSet rs = myStmt.executeQuery();
		
		while(rs.next()) {
			String reg = rs.getString("reg");
			String manucode = rs.getString("manu_code");
			String modelcode = rs.getString("model_code");
			double Mileage = rs.getDouble("mileage");
			double Price = rs.getDouble("price");
			String Colour = rs.getString("colour");
			String Fuel = rs.getString("fuel");
			
			vehicles.add(new Vehicle(reg, manucode, modelcode, Mileage, Price, Colour, Fuel));
		}
		
		return vehicles;
	}
	
	public void addVehicle(Vehicle vehicle) throws Exception {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO vehicle " +
														"VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		myStmt.setString(1, vehicle.getReg());
		myStmt.setString(2, vehicle.getManuCode());
		myStmt.setString(3, vehicle.getModelCode());
		myStmt.setDouble(4, vehicle.getMilage());
		myStmt.setDouble(5, vehicle.getPrice());
		myStmt.setString(6, vehicle.getColour());
		myStmt.setString(7, vehicle.getFuel());		
		
		myStmt.executeUpdate();
		
		conn.close();
	}		
	
}