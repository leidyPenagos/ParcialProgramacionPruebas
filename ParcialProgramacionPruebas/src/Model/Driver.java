package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Driver {

	private String idDriver;
	private String name;
	private LocalDate dateBirthday;
	
	public Driver(String idDriver, String name, LocalDate dateBegin) {
		super();
		this.idDriver = idDriver;
		this.name = name;
		this.dateBirthday = dateBirthday;
	}

	public String getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(String idDriver) {
		this.idDriver = idDriver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
	}

	public int getAge(LocalDate dateBirthday) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento = LocalDate.parse("08/04/1987", formatter);
		Period edad = Period.between(fechaNacimiento, LocalDate.now());
	     return edad.getYears()+ edad.getMonths() + edad.getDays();
		
	}
	@Override
	public String toString() {
		return "Driver [idDriver=" + idDriver + ", name=" + name + ", dateBegin=" + dateBirthday + "]";
	}
	
	
}
