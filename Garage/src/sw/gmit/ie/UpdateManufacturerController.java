package sw.gmit.ie;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UpdateManufacturerController {
	private Manufacturer updatingManufacturer = new Manufacturer();
	private DAO dao;
	
	public UpdateManufacturerController() { }
	
	// Add a new manufacturer to the list of manufacturers
	
	
	public String loadManufacturer(String manuCode) {
		try {
			dao = new DAO();
			updatingManufacturer = dao.getManufacturer(manuCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String update(){
		try {
			dao = new DAO();			
			dao.updateManufacturer(updatingManufacturer);
			return "manufacturers";
		} catch (SQLException e) {
			String errorMessage;
			
			switch(e.getErrorCode()) {
			case 1062:
				errorMessage = "Error: Manufacturer code " + updatingManufacturer.getManuCode() + " already exists";
				break;
			default:
				errorMessage = "[" + e.getErrorCode() + "]" + e.getMessage();
			}
			
			
			FacesMessage message = new FacesMessage(errorMessage);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			System.out.println("[" + e.getErrorCode() + "]" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Manufacturer getUpdateManufacturer() {
		return updatingManufacturer;
	}

	public void setUpdateManufacturer(Manufacturer updateManufacturer) {
		this.updatingManufacturer = updateManufacturer;
	}
}
