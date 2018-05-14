package uned.practica;

import es.uned.lsi.eped.pract2016_2017.Query;
import es.uned.lsi.eped.pract2016_2017.Tune;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TuneMatchTest extends TestCase{

	/**
     * Crea el test
     *
     * @param testName nombre de la prueba
     */
	public TuneMatchTest(String testName){
		super(testName);
	}
	
	/**
     * @return Suite del test
     */
    public static Test suite(){
        return new TestSuite( TuneMatchTest.class );
    }
	
    /**
     * Comprueba si el método match de la clase Tune funciona correctamente
     */
    public void testBusquedaCancion(){
    	Tune t = new Tune("Rising Up", "The Beatles", "Rock", "Visual Wheel of Life",
    			1997, 343);
    	Tune t2 = new Tune("SandStorm", "Darude", "Electronic", "Failure of Unknown System", 2012, 415);
    	Tune t3 = new Tune("prueba", "test", "dayum", "hola", 2000, 300);
    	
    	Query q = new Query("Rising Up", "The Beatles", "Rock", "Visual Wheel of Life",
    			1997, 2010,  0, 500);
    	Query q2 = new Query("", "", "", "Failure of Unknown System",
    			2016, 2017,  0, 500);
    	Query q3 = new Query("prueba", "test", "dayum", "hola", 1999, 2010, 0, 400);
    	
    	assertEquals(true, t.match(q));
    	assertEquals(false, t2.match(q2));
    	assertEquals(true, t3.match(q3));
    }
    
    
}
