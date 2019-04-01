package it.polito.tdp.toto;

public class Espandi {

	public void espandiPronostico(Pronostico p) {
		//dichiarer� una nuova schedina 
		Schedina parziale=new Schedina(p.getN());
		espandi(p,parziale,0);
	}
	
	//il livello della ricorsione � uguale alla singola partita
	//livello=0 schedina con 0 risultati
	//livello=1 schedina con 1 risultato ...
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		
		// parziale contiene gi� (livello -1) valori
		// nelle posizioni 0....livello-1
		// devo determinare schedina parziale[livello] 
		// (cio� la livello +1esima riga)
		// sulla base della previsione nel pronostico corrispondente p[livello]
		
		if(livello==p.getN()) {
			System.out.println(parziale);
			//la soluzione parziale � in realt� la soluzione totale
			return;
		}
		
		Previsione prev = p.get(livello);
		
		//provo le varie alternative
		for(Risultato r:prev.getValori()) {
			//provo ad aggiungere r alla soluzione
			parziale.add(r);
			
			espandi(p,parziale,livello+1);
			
			//backtrack
			parziale.removeLast();
		}
		
	}
	
	
}
