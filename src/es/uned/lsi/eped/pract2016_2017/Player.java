package es.uned.lsi.eped.pract2016_2017;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {

	private TuneCollectionIF T;
	
	private PlayListManager plm;
	private PlayBackQueue pbq;
	private RecentlyPlayed rp;
	
	 /* Constructor de la clase que implementa PlayerIF
	 * @param -una colección de canciones como un objeto TuneCollectionIF
	 * 		  -un entero representando el número máximo de canciones
	 * 		  reproducidas que se pueden almacenar
	 */
	public Player(TuneCollectionIF T, int maxRecentlyPlayed){
		this.T = T;
		plm = new PlayListManager();
		pbq = new PlayBackQueue(T);
		rp = new RecentlyPlayed(maxRecentlyPlayed);
	}
	
	public ListIF<String> getPlayListIDs() {
		ListIF<String> l = plm.getIDs();
		return l;
	}

	public ListIF<Integer> getPlayListContent(String playListID) {
		if(plm.contains(playListID)){
			return plm.getPlayList(playListID).getPlayList();
		}else{
			List<Integer> nl = new List<Integer>();
			return nl;
		}
	}

	public ListIF<Integer> getPlayBackQueue() {
		return pbq.getContent();
	}

	public ListIF<Integer> getRecentlyPlayed() {
		return rp.getContent();
	}

	public void createPlayList(String playListID) {
		plm.createPlayList(playListID);
	}

	public void removePlayList(String playListID) {
		plm.removePlayList(playListID);
	}

	public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
		boolean tuneContent = true;
		IteratorIF<Integer> i = lT.iterator();
		while(i.hasNext()){
			Integer u = i.getNext();
			if(u<0||u>T.size()){
				tuneContent = false;
			}
		}
		
		if(tuneContent && plm.contains(playListID)){
			plm.getPlayList(playListID).addListOfTunes(lT);
		}
	}

	public void addSearchToPlayList(String playListID, String t, String a, String g, String al, int min_y, int max_y,
			int min_d, int max_d) {
		List<Integer> l = new List<Integer>();
		
		if(plm.contains(playListID)){
			for(int i = 0; i < T.size(); i++){
				if(T.getTune(i).match(new Query(t, a, g, al, min_y, max_y, min_d, max_d))){
					l.insert(i, l.size()+1);
				}
			}
			
			plm.getPlayList(playListID).addListOfTunes(l);
		}
	}

	public void removeTuneFromPlayList(String playListID, int tuneID) {
		if(plm.contains(playListID)){
			plm.getPlayList(playListID).removeTune(tuneID);
		}
	}

	@Override
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		boolean idValidos = true;
		
		IteratorIF<Integer> i = lT.iterator();
		while(i.hasNext()){
			int temp = i.getNext();
			if(temp<0 || temp>T.size()){
				idValidos = false;
			}
		}
		
		if(idValidos){
			pbq.addTunes(lT);
		}
	}

	public void addSearchToPlayBackQueue(String t, String a, String g, String al, int min_y, int max_y, int min_d,
			int max_d) {
		List<Integer> l = new List<Integer>();
		
		Query q = new Query(t,a,g,al,min_y,max_y,min_d,max_d);
		
		for(int i = 0; i < T.size(); i++){
			if(T.getTune(i).match(q)){
				l.insert(i, l.size()+1);
			}
		}
		
		pbq.addTunes(l);
	}

	public void addPlayListToPlayBackQueue(String playListID) {
		if(plm.contains(playListID)){
			pbq.addTunes(plm.getPlayList(playListID).getPlayList());
		}
	}

	public void clearPlayBackQueue() {
		pbq.clear();
	}

	public void play() {
		if(!pbq.isEmpty()){
			int siguiente = pbq.getFirstTune();
			pbq.extractFirstTune();
			
			rp.addTune(siguiente);
		}
	}

}
