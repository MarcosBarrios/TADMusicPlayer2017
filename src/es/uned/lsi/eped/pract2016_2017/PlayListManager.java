package es.uned.lsi.eped.pract2016_2017;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayListManager implements PlayListManagerIF {

	private List<PlayList> list;

	public PlayListManager(){
		list = new List<PlayList>();
	}
	
	private List<PlayList> getList(){
		return list;
	}
	
	public boolean contains(String playListID) {
		if(notEmptyString(playListID)){
			//recorre cada elemento de la lista y comprueba su ID
			for(int i = 0; i < getList().size(); i++){
				PlayList p = getList().get(i+1);
				if(p.getPlayListID().equals(playListID)){
					return true;
				}
			}
		}
		return false;
	}

	public PlayList getPlayList(String playListID) {
		int aux = StringToIntID(playListID);
		PlayList pl = getList().get(aux);
		
		return pl;
	}

	public ListIF<String> getIDs() {
		List<String> l = new List<String>();
		
		//recorre todas las listas de reproduccion y añade su id a la lista de IDs
		for(int i = 1; i <= getList().size(); i++){
			l.insert(getList().get(i).getPlayListID(), i);
		}
		
		return l;
	}

	public void createPlayList(String playListID) {
		if(notEmptyString(playListID) && !contains(playListID)){
			PlayList pl = new PlayList(playListID);
			getList().insert(pl, getList().size()+1);
		}
	}

	public void removePlayList(String playListID) {
		if(notEmptyString(playListID) && contains(playListID)){
			int aux = StringToIntID(playListID);
			getList().remove(aux);
		}
	}
	
	//Coge el nombre de una lista de reproducción y devuelve 
	//su posición en la lista del gestionador | Devuelve 0 si es invalido
	private int StringToIntID(String playListID){
		int aux = 1;
		boolean encontrado = false;
		if(notEmptyString(playListID) && contains(playListID)){
			while(!encontrado){
				if(getList().get(aux).getPlayListID().equals(playListID)){
					return aux;
				}
				aux++;
			}
		}
		return 0;
	}
	
	//Comprueba si la cadena del parámetro está vacía o no
	private boolean notEmptyString(String in){
		if(in.length()>0){
			return true;
		}else{
			return false;
		}
	}

}
