package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Truck;

public class TruckTest {

	private Truck truck;

    void setup(){
        truck = new Truck("FCD640","Dodge",(short)1980,"Verde Menta",5f,true,90f);
    }

    @Test
    /**
     * Caso de prueba para validar las condiciones iniciales del cami�n creado
     */
    void begin(){
        setup();
        assertTrue( truck.isSingle());
        assertEquals("FCD640",truck.getPlate());
        assertEquals(5.0,truck.getCapacity(),0.1);
        assertEquals(90.0,truck.getMaxSpeed(),0.1);
    }

    @Test
    void load() {
        setup( );
        //El cami�n se encuentra descargado
        assertFalse(truck.isState());
        //Se carga un flete de 2.5 toneladas
        assertTrue(truck.load(2.5f));
        //Se carga otro de 1.5 toneladas
        assertTrue(truck.load(1.5f));
        //La suma de los fletes es de 4 toneladas
        assertEquals(4.0, truck.sumWheight(),0.1);
        //No se puede agregar un flete de m�s de una tonelada porque excede la capacidad de las 5 toneladas
        assertFalse( truck.load( 1.1f ) );
        //Existen dos fletes en el arreglo
        assertEquals(2, truck.getCharters().size());
    }

    @Test
    /**
     * Caso de prueba para validar el comportamiento de descarga de los camiones
     */
    void dump(){
        setup();
        //El cami�n est� descargado, entonces no se puede descargar
        assertFalse( truck.dump( ) );
        //cargar el carro con las 5 toneladas de capacidad
        assertTrue( truck.load(5.0f));
        //Verificar que el estado es cargado
        assertTrue( truck.isState());
        //Descargar Veh�culo
        assertTrue( truck.dump( ) );
        //Ahora el estado es descargado
        assertFalse( truck.dump( ) );
        //El arreglo de fletes se ha reiniciado
        assertEquals(0, truck.getCharters().size());
    }

    @Test
    /**
     * Caso de prueba para validar el comportamiento de acelerar, que en los veh�culos de carga no debe exceder el l�mite de velocidad
     */
    void speedUp(){
        setup();
        //El veh�culo se encuentra detenido, velocidad de 0.0
        assertEquals(0.0, truck.getSpeed(),0.1);
        //Verificar velocidad m�xima dada al momento de instanciar el objeto
        assertEquals(90.0,truck.getMaxSpeed(),0.1);
        //Acelerar a 20 Km/h
        assertTrue( truck.speedUp(20.0f));
        assertEquals( 20.0, truck.getSpeed(),0.1);
        //Aclerar 40 unidades m�s, velocidad final 60 Km/h
        assertTrue( truck.speedUp(40.0f));
        assertEquals( 60.0, truck.getSpeed(),0.1);
        //No es posible acelerar m�s de 40 porque se pasar�a de la velocidad m�xima
        assertFalse( truck.speedUp( 41.0f ) );
        assertEquals( 60.0, truck.getSpeed(),0.1);
    }

    @Test
    /**
     * Caso de prueba para revisar el comportamiento de frenar de los veh�culos de carga, 5% m�s de la intensidad de frenado con respecto a los de pasajeros
     */
    void breaking(){
        setup();
        //Acelerar a la velocidad m�xima
        assertTrue( truck.speedUp( 90.0f ) );
        //Frenar a un 45% + 5% para veh�culos de carga, entonces la velocidad debe ser de 45 Km/h
        assertEquals(45.0,truck.breaking(45.0f),0.1);
        //Frenar a un 95% - detiene el veh�culo
        assertEquals(0.0, truck.breaking(95.0f));
    }

}
