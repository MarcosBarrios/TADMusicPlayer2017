package es.uned.lsi.eped.pract2016_2017;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF {

	private List<Integer> playList;
	
	private String playListID;
	
	public PlayList(String playListID){
		playList = new List<Integer>();
		this.playListID = playListID;
	}
	
	public ListIF<Integer> getPlayList() {
		return playList;
	}

	public void addListOfTunes(ListIF<Integer> lT) {
		for(int i = 0; i < lT.size(); i++){
			getPlayList().insert(lT.get(i+1), getPlayList().size()+1);
		}
	}

	public void removeTune(int tuneID) {
		List<Integer> l = new List<Integer>();
		IteratorIF<Integer> itr = getPlayList().iterator();
		while(itr.hasNext()){
			int temp = itr.getNext();
			if(temp!=tuneID){
				l.insert(temp, l.size()+1);
			}
		}
		
		playList = l;
	}

	public String getPlayListID() {
		return playListID;
	}

}
