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
        //Vehículo descargado
        assertFalse(dt.isState());
        //No se puede cargar más de la capacidad
        assertFalse( dt.load( 14.01f));
        //Cargar con la máxima capacidad
        assertTrue( dt.load(14.0f));
        //Vehículo ahora cargado
        assertTrue( dt.isState());
    }


    @Test
    /**
     * Caso de prueba para validar el comportamiento de la descarga de las volquetas
     */
    void dump() {
        setup();
        //No se puede descargar el vehículo, se encuyentra descargado
        assertFalse( dt.dump());
        //Cargar Vehículo
        assertTrue( dt.load(10.0f));
        //Descargar Vehículo
        assertTrue( dt.dump());
    }

}
