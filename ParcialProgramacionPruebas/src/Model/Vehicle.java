package Model;

public abstract class Vehicle {

	protected String plate;
	protected String mark;
	protected short model;
	protected String color;
	protected float speed;
	
	
	public Vehicle(String plate, String mark, short model, String color, float speed) {
		super();
		this.plate = plate;
		this.mark = mark;
		this.model = model;
		this.color = color;
		this.speed = speed;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public short getModel() {
		return model;
	}


	public void setModel(short model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public abstract boolean speedUp(float speed);

	
	public float breaking(float speed) {
		if (speed>=80) {
			speed=40;
			return speed;
		}else {
		return speed;
		}
	}
	
	@Override
	public String toString() {
		return "Vehicle [plate=" + plate + ", mark=" + mark + ", model=" + model + ", color=" + color + ", speed="
				+ speed + "]";
	}
	

}
