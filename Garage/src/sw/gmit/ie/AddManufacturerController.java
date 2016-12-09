package sw.gmit.ie;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class AddManufacturerController {
	private Manufacturer newManufacturer = new Manufacturer();
	private DAO dao;
	
	public AddManufacturerController() { }
	
	// Add a new manufacturer to the list of manufacturers
	public String addManufacturer() {
		try {
			dao = new DAO();
			dao.addManufacturer(newManufacturer);
			return "manufacturers";
		} catch (SQLException e) {
			String errorMessage;
			
			switch(e.getErrorCode()) {
			case 1062:
				errorMessage = "Error: Manufacturer code " + newManufacturer.getManuCode() + " already exists";
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

	public Manufacturer getNewManufacturer() {
		return newManufacturer;
	}

	public void setNewManufacturer(Manufacturer newManufacturer) {
		this.newManufacturer = newManufacturer;
	}
}
