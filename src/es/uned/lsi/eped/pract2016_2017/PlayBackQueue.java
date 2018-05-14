package es.uned.lsi.eped.pract2016_2017;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class PlayBackQueue implements PlayBackQueueIF {

	private Queue<Integer> q;

	private TuneCollectionIF tc;
	
	public PlayBackQueue(TuneCollectionIF tc){
		this.tc = tc;
		q = new Queue<Integer>();
	}
	
	public ListIF<Integer> getContent() {
		List<Integer> l = new List<Integer>();
		int aux = 0;
		IteratorIF<Integer> i = q.iterator();
		while(i.hasNext()){
			l.insert(i.getNext(), aux+1);
			aux++;
		}
		return l;
	}

	public boolean isEmpty() {
		return q.size()==0;
	}

	public int getFirstTune() {
		if(!isEmpty()){
			return q.getFirst();
		}
		return 0;
	}

	public void extractFirstTune() {
		q.dequeue();
	}

	public void addTunes(ListIF<Integer> lT) {
		if(listExists(lT)){
			IteratorIF<Integer> itr = lT.iterator();
			while(itr.hasNext()){
				q.enqueue(itr.getNext());
			}
		}
	}

	public void clear() {
		q.clear();
	}
	
	//Comprueba que todos los identificadores de la lista pertenezcan
	//al repertorio de canciones
	private boolean listExists(ListIF<Integer> list){
		int aux = 0;
		int coincidencias = 0;
		while(aux<list.size()){
			if(list.get(aux+1)>=0 && list.get(aux+1) < tc.size()){
				coincidencias++;
			}
			aux++;
		}
		
		if(coincidencias==list.size()){
			return true;
		}
		return false;
	}

}
