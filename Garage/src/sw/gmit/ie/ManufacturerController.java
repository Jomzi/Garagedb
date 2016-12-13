package sw.gmit.ie;
import javax.faces.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.*;

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
	
	public void deleteManufacturer(String manuCode){
		try {
			dao = new DAO();
			dao.deleteManufacturer(manuCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	try {
		FacesContext.getCurrentInstance().getExternalContext().redirect("manufacturers.xhtml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return;
	}
	
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}
}
