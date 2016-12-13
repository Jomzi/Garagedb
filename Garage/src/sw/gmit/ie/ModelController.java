package sw.gmit.ie;
import javax.faces.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.*;

@ManagedBean

public class ModelController {
	private ArrayList<Model> models;
	private DAO dao;
	
	public ModelController() { }
	
	// Use DAO to retrieve Model from the Model
	public void loadModels() {
		try {
			dao = new DAO();
			models = dao.getModels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Model> getModels() {
		return models;
	}
}