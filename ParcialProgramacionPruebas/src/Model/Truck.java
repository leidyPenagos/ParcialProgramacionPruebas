package Model;

import java.util.ArrayList;

public class Truck extends Charge{
	
	public Charter charter;

	public Truck(String plate, String mark, short model, String color, float speed, boolean single, float capacity) {
		super(plate, mark, model, color, speed, single, capacity);
	}
	
	public ArrayList<Charter> getCharters() {
		return null;
		
	}
	
	public boolean load(float capacity) {
		return true;
		
	}

	public float sumWheight() {
		return 0;
	}
	
	public boolean dump() {
		return true;
	}

	@Override
	public boolean speedUp(float speed) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
