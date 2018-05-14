package es.uned.lsi.eped.pract2016_2017;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class RecentlyPlayed implements RecentlyPlayedIF {

	private Queue<Integer> cola;
	
	private int maxTunes;
	
	public RecentlyPlayed(int maxTunes){
		cola = new Queue<Integer>();
		this.maxTunes = maxTunes;
	}
	
	public ListIF<Integer> getContent() {
		List<Integer> l = new List<Integer>();
		List<Integer> rl = new List<Integer>();
		int aux = 0;
		IteratorIF<Integer> itr = cola.iterator();
		while(itr.hasNext()){
			l.insert(itr.getNext(), aux+1);
			aux++;
		}
		
		for(int i = 0; i < l.size(); i++){
			rl.insert(l.get(l.size()-i), rl.size()+1);
		}
		
		return rl;
	}

	public void addTune(int tuneID) {
		if(cola.size()<maxTunes){
			cola.enqueue(tuneID);
		}else{
			cola.dequeue();
			cola.enqueue(tuneID);
		}
	}

}
