package sw.gmit.ie;


	import java.sql.SQLException;

	import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.context.FacesContext;

	@ManagedBean
	public class AddVehicleController {
		private Vehicle newVehicle = new Vehicle();
		private DAO dao;
		
		public AddVehicleController() { }
		
		// Add a new vehicle to the list of vehicle
		public String addVehicle() {
			try {
				dao = new DAO();
				dao.addVehicle(newVehicle);
				return "vehicles";
			} catch (SQLException e) {
				String errorMessage;
				
				switch(e.getErrorCode()) {
				case 1062:
					errorMessage = "Error: Reg " + newVehicle.getReg() + " already exists";
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

		public Vehicle getNewVehicle() {
			return newVehicle;
		}

		public void setNewVehicle(Vehicle newVehicle) {
			this.newVehicle = newVehicle;
		}
	}
