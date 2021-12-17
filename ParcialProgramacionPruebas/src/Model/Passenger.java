package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Passenger extends Vehicle{

	private byte numPassengers;
	

	
	public Passenger(String plate, String mark, short model, String color,float Speed, int i) {
		super(plate, mark, model, color, Speed);
	}

	public byte getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(byte numPassengers) {
		this.numPassengers = numPassengers;
	}
	
	public Driver findDriver(String idDriver) {
		
		return null;
		
	}
	
	public boolean addDriver(String idDriver, String name, LocalDate dateBegin) {
		new Driver("123455", "Luis", dateBegin);
		return true;
	}


	public ArrayList<Driver> getDriver() {
		return null;
	}

	@Override
	public String toString() {
		return "Passenger [numPassengers=" + numPassengers + "]";
	}

	@Override
	public boolean speedUp(float speed) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addDriver(Driver driver) {
		new Driver("123455", "Luis", null);
		return true;
	}
	
	
	
	
}
