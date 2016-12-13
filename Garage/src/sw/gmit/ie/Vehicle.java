package sw.gmit.ie;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Vehicle {
	private String reg;
	private String manuCode;
	private String modelCode;
    private double milage;
    private double price;
    private String colour;
    private String fuel;
    
	public Vehicle() { }

	public Vehicle(String reg, String manuCode, String modelCode, double milage, double price, String colour, String fuel) {
		super();
		this.reg = reg;
		this.manuCode = manuCode;
		this.modelCode = modelCode;
		this.milage = milage;
		this.price = price;
		this.colour = colour;
		this.fuel = fuel;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getManuCode() {
		return manuCode;
	}

	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


}
