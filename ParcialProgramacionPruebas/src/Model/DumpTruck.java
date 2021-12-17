package Model;

public class DumpTruck extends Charge {

	private float power;
	

	public DumpTruck(String plate, String mark, short model, String color, float speed, boolean single, float power, float capacity) {
		super(plate, mark, model, color, speed, single, capacity);
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}
	
	public boolean load(float capacity) {
		return true;
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
