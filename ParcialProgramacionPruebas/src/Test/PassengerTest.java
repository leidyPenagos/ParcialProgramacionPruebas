package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import Model.Driver;
import Model.Passenger;

public class PassengerTest {
	private Passenger vehiclePassenger;

    void setup(){
        vehiclePassenger = new Passenger("JIA764","Renault 4",(short)1977,"Verde Militar",(byte)5, 0);
    }

    @Test
    /**
     * Caso de prueba para validar que el número de pasajeros se ha asignado correctamente
     */
    void getNumPassengers() {
        setup();
        assertEquals(5,vehiclePassenger.getNumPassengers());
        vehiclePassenger.setNumPassengers((byte)(vehiclePassenger.getNumPassengers() - 2));
        assertEquals(3,vehiclePassenger.getNumPassengers());
    }

    @Test
    /**
     * Caso de prueba para validar que el método acelerar funciona según la funcionalidad esperada
     */
    void speedUp() {
        setup();
        //Para cada nueva instancia, la velocidad esta en 0.0 (detenido)
        assertEquals(0.0, vehiclePassenger.getSpeed(),0.1);
        //Se asignan 45 unidades de aceleración, la velocidad del vehículo 45 Km/h
        vehiclePassenger.speedUp(45);
        assertEquals(45.0, vehiclePassenger.getSpeed(),0.1);
        //Se asignan 15 unidades de aceleración, la velocidad del vehículo 60 Km/h
        vehiclePassenger.speedUp(15);
        assertEquals(60.0, vehiclePassenger.getSpeed(),0.1);
    }

    @Test
    /**
     * Caso de prueba que valida el método de buscar un conductor
     */
    void findDriver() {
        setup();
        //El conductor no ha sido asignado, el método retorna Null
        assertNull(vehiclePassenger.findDriver("4352352352"));
        //Se agregan dos conductores
        vehiclePassenger.addDriver( new Driver("23424","Jaime", LocalDate.of(1950, Month.APRIL,23)));
        vehiclePassenger.addDriver( new Driver("74656","Diana", LocalDate.of(2000, Month.JULY,11)));
        //El método de búsqueda retorna un valor diferente de null para la búsqueda de los dos conductores
        assertNotNull( vehiclePassenger.findDriver("23424"));
        assertNotNull( vehiclePassenger.findDriver("74656"));
        //Validar que en realidad el conductor agregado corresponde con el que es
        assertEquals("Diana", vehiclePassenger.findDriver("74656").getName());
    }

    @Test
    /**
     * Caso de prueba para validar que se agreguen los conductores, no se puede agregar cuando se repite el ID o porque es menor de edad
     */
    void addDriver() {
        setup();
        //Se agrega el conductor Lorenzo
        assertTrue( vehiclePassenger.addDriver( new Driver("342345","Lorenzo",LocalDate.of(1982,Month.JANUARY,29))));
        //No permite agregar, el ID ya existe
        assertFalse( vehiclePassenger.addDriver( new Driver("342345","Lorenzo",LocalDate.of(1982,Month.JANUARY,29))));
        //No permite agregar, menor de edad
        assertFalse( vehiclePassenger.addDriver( new Driver("53564","Carlos",LocalDate.of(2010,Month.FEBRUARY,5))));
        //Solo se agregó un conductor
        assertEquals(1, vehiclePassenger.getDriver().size());
    }

    @Test
    /**
     * Caso de prueba para validar que se obtiene el arreglo de conductores en forma adecuada.
     */
    void getDrivers(){
        setup();
        vehiclePassenger.addDriver( new Driver("342345","Lorenzo",LocalDate.of(1982,Month.JANUARY,29)));
        vehiclePassenger.addDriver( new Driver("342345","Cesar",LocalDate.of(1954,Month.SEPTEMBER,6)));
        vehiclePassenger.addDriver( new Driver("263648","Lola",LocalDate.of(2005,Month.MARCH,10)));
        vehiclePassenger.addDriver( new Driver("545564","Bernanrdo",LocalDate.of(1991,Month.AUGUST,25)));
        //Solamente se agrgaron dos conducores, en uno se repiete el ID y en el otro caso es menor de edad
        assertEquals(2, vehiclePassenger.getDriver().size());
        //Validar que el arreglo que se retorna sea una copia para que no permita su modificación fuera de la clase
        vehiclePassenger.getDriver().add( new Driver("72647","Reynaldo",LocalDate.of(1961,Month.JULY,20)));
        assertEquals(2, vehiclePassenger.getDriver().size());
    }

    @Test
    /**
     * Caso de prueba para validar el método de frenar
     */
    void breaking(){
        setup();
        //Acelerar tres veces, para una velocidad total de 90 Km/h
        vehiclePassenger.speedUp(35);
        vehiclePassenger.speedUp(40);
        vehiclePassenger.speedUp(15);
        //Se frena con una intensidad del 50%, velocidad resultante 45 Km/h
        assertEquals(45.0, vehiclePassenger.breaking(50),0.1);
        //Se frena con una intensidad del 10%, velocidad resultante 40.5 Km/h
        assertEquals(40.5, vehiclePassenger.breaking(10),0.1);
    }

}
