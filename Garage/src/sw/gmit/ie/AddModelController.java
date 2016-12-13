package sw.gmit.ie;


	import java.sql.SQLException;

	import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.context.FacesContext;

	@ManagedBean
	public class AddModelController {
		private Model newModel = new Model();
		private DAO dao;
		
		public AddModelController() { }
		
		// Add a new Model to the list of Model
		public String addModel() {
			try {
				dao = new DAO();
				dao.addModel(newModel);
				return "models";
			} catch (SQLException e) {
				String errorMessage;
				
				switch(e.getErrorCode()) {
				case 1062:
					errorMessage = "Error: Manu Code " + newModel.getManuCode() + " already exists";
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

		public Model getNewModel() {
			return newModel;
		}

		public void setNewModel(Model newModel) {
			this.newModel = newModel;
		}
	}
