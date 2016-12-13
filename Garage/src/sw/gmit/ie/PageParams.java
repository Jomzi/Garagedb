package sw.gmit.ie;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@SessionScoped

public class PageParams {

	private String manuCode;

	public String getManuCode() {
		return manuCode;
	}

	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}
	
	public String testLink(){
		return "testLink";
	}
	
	public String updateManufacturer() {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		
	    this.manuCode = params.get("manuCode");
	    return "updateManufacturer";
	}
}
