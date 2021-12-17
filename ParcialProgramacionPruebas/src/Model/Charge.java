package Model;

public abstract class Charge extends Vehicle implements ActionsCharge{

	protected float capacity;
	protected boolean single;
	protected float maxSpeed;
	protected boolean state;
	
	

	public Charge(String plate, String mark, short model, String color, float speed, boolean single, float capacity) {
		super(plate, mark, model, color, speed);
	}



	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}
	

	public float getMaxSpeed() {
		return maxSpeed;
	}



	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}



	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public float breaking(float maxSpeed) {
		return maxSpeed;
	}
	
	@Override
	public String toString() {
		return "Charge [capacity=" + capacity + ", single=" + single + ", maxSpeed=" + maxSpeed + "]";
	}

}
