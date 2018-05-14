package uned.practica;

import java.io.IOException;

import es.uned.lsi.eped.pract2016_2017.TuneCollection;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TuneCollectionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TuneCollectionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TuneCollectionTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testCancionesNumApp() throws IOException
    {
    	TuneCollection tc = new TuneCollection("src/main/resource/Repository.tsv");
    	assertEquals("El numero de canciones no es correcto", tc.size(), new Integer(11373).intValue());
    }
    
    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testJesuJoyApp() throws IOException
    {
    	TuneCollection tc = new TuneCollection("src/main/resource/Repository.tsv");
    	assertEquals("La canción Jesu Joy no está en el orden correcto", tc.getTune(300).getTitulo(), "Jesu, Joy Of Man's Desiring");
    }    
}
