package sw.gmit.ie;
import javax.faces.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.*;

@ManagedBean

public class VehicleController {
	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	
	public VehicleController() { }
	
	// Use DAO to retrieve vehicle from the database
	public void loadVehicles() {
		try {
			dao = new DAO();
			vehicles = dao.getVehicles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}