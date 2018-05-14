package uned.practica;


import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.pract2016_2017.PlayListManager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PlayListManagerTest extends TestCase{

	public PlayListManagerTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite(PlayListManagerTest.class);
	}
	
	public void testContainsPlayList(){
		PlayListManager plm = new PlayListManager();
		
		plm.createPlayList("Canciones de rock");
		plm.createPlayList("Canciones de dubstep");
		plm.createPlayList("Future Rising");
		
		assertEquals(true, plm.contains("Canciones de rock"));
		assertEquals(true, plm.contains("Future Rising"));
		assertEquals(true, plm.contains("Canciones de dubstep"));
		assertEquals(false, plm.contains("Canciones navideñas"));
		assertEquals(false, plm.contains(""));
	}
	
	public void testRemovePlayList(){
		PlayListManager plm = new PlayListManager();
		
		plm.createPlayList("Canciones de rock");
		plm.createPlayList("Canciones de dubstep");
		plm.removePlayList("Canciones de rock");
		plm.removePlayList("Canciones de dubstep");
		plm.removePlayList("");
		
		assertEquals(false, plm.contains("Canciones de rock"));
		assertEquals(false, plm.contains("Canciones de dubstep"));
	}
	
	public  void testGetIDs(){
		PlayListManager plm = new PlayListManager();
		
		plm.createPlayList("Canciones de rock");
		plm.createPlayList("Canciones de dubstep");
		plm.createPlayList("Future Rising");
		
		List<String> sl = new List<String>();
		sl.insert(new String("Canciones de rock"), 1);
		sl.insert(new String("Canciones de dubstep"), 2);
		sl.insert(new String("Future Rising"), 3);
		
		assertEquals(sl.get(1), plm.getIDs().get(1));
		assertEquals(sl.get(2), plm.getIDs().get(2));
		assertEquals(sl.get(3), plm.getIDs().get(3));
	}
	
}
