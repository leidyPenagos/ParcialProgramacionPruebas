package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.DumpTruck;

public class DumpTruckTest {

	private DumpTruck dt;

    void setup(){
        dt = new DumpTruck("JRH674","International",(short)2010,"Blanco",14,false,80.0f,440f);
    }

    @Test
    /**
     * Validar las condiciones iniciales.
     */
    void begin(){
        setup();
        assertFalse( dt.isSingle());
        assertEquals( 440, dt.getPower());
    }

    @Test
    /**
     * Caso de prueba para verificar el comportamiento de carga de las volquetas.
     */
    void load() {
        setup();
        //Veh�culo descargado
        assertFalse(dt.isState());
        //No se puede cargar m�s de la capacidad
        assertFalse( dt.load( 14.01f));
        //Cargar con la m�xima capacidad
        assertTrue( dt.load(14.0f));
        //Veh�culo ahora cargado
        assertTrue( dt.isState());
    }


    @Test
    /**
     * Caso de prueba para validar el comportamiento de la descarga de las volquetas
     */
    void dump() {
        setup();
        //No se puede descargar el veh�culo, se encuyentra descargado
        assertFalse( dt.dump());
        //Cargar Veh�culo
        assertTrue( dt.load(10.0f));
        //Descargar Veh�culo
        assertTrue( dt.dump());
    }

}
