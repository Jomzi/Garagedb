package sw.gmit.ie;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ManufacturerController {
	private ArrayList<Manufacturer> manufacturers;
	private DAO dao;
	
	public ManufacturerController() { }
	
	// Use DAO to retrieve manufacturers from the database
	public void loadManufacturers() {
		try {
			dao = new DAO();
			manufacturers = dao.getManufacturers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}
}
