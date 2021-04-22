package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	ParolaDAO paroladao= new ParolaDAO();
	
	//	ParolaDAO paroladao; NOOOOO!!!!
	//NON scrivo solo "ParolaDAO paroladao;" ma creo un nuovo oggetto!!
		
		public Set<String> anagrammi(String parola) {
			
			Set<String> risultato= new HashSet<>();
			
			permuta("", parola, 0, risultato); //lancio la ricorsione
		
			return risultato;	
		}
		
		private void permuta(String parziale, String lettere, int livello, Set<String>risultato) {
			
			if(lettere.length()==0) {
				
				risultato.add(parziale);//ha senso metterle insieme cosi perche non devo lavorare sulla soluzione
			}
			
			else {
				for(int pos=0; pos<lettere.length(); pos++) {
					char tentativo= lettere.charAt(pos);
					
					String Nuovaparziale = parziale + tentativo;			
					String Nuovalettere = lettere.substring(0, pos) + lettere.substring(pos+1);
					
					permuta(Nuovaparziale, Nuovalettere, livello+1, risultato );
			
				}
			}
		}
	
	
	public boolean isCorrect(String anagramma){
		return paroladao.isCorrect(anagramma);
	}
}
