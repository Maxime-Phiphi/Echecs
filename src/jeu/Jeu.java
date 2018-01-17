package jeu;

import piece.*;

public class Jeu {
	
	private Grille grille = new Grille();
	protected static Piece[][] tabPiece = new Piece[8][8];

    public Jeu(Grille grille) {
    	
  //  	initTabPiece();
        this.grille = grille;
        
    }
    
//    public void initTabPiece() {
//    	for(int i=0;i<8;i++) {
//    		for(int j=0;j<8;j++) {
//    			tabPiece[i][j]=null;
//    		}
//    	}
//    }
	
	public void Initialiser(){

        for(int i = 0; i< Grille.getTaille(); i++) {
        	
            Pion pionn = new Pion(i, 1, "N");
            Pion pionb = new Pion(i, 6, "B");
            grille.getTabGrille()[i][1] = pionn.toString();
            grille.getTabGrille()[i][6] = pionb.toString();
            tabPiece[i][1] = pionn;
            tabPiece[i][6] = pionb;
        }

        for (int i = 0; i< Grille.getTaille(); i+=7){
            Tour tourb = new Tour(i, 7, "B");
            Tour tourn = new Tour(i, 0, "N");
            grille.getTabGrille()[i][7]= tourb.toString();
            grille.getTabGrille()[i][0] = tourn.toString();
            tabPiece[i][7]=tourb;
            tabPiece[i][0]=tourn;
            tabPiece[5][5]=tourb;
        }

        for (int i = 1; i< Grille.getTaille(); i+=5){
            Cavalier cavalierb = new Cavalier(i, 0, "B");
            Cavalier cavaliern = new Cavalier(i, 7, "N");
            grille.getTabGrille()[i][7] = cavalierb.toString();
            grille.getTabGrille()[i][0] = cavaliern.toString();
            tabPiece[i][7]=cavalierb;
            tabPiece[i][0]=cavaliern;
        }

        for (int i = 2; i< Grille.getTaille(); i+=3){
            Fou foub = new Fou(i, 7, "B");
            Fou foun = new Fou(i, 0, "N");
            grille.getTabGrille()[i][7] = foub.toString();
            grille.getTabGrille()[i][0] = foun.toString();
            tabPiece[i][7]=foub;
            tabPiece[i][0]=foun;
            
        }

        Roi roib = new Roi(4, 7,"B");
        Roi roin = new Roi(4, 0,"N");
        grille.getTabGrille()[4][7] = roib.toString();
        grille.getTabGrille()[4][0] = roin.toString();
        tabPiece[4][7]=roib;
        tabPiece[4][0]=roin;

        Reine reineb = new Reine(3, 7, "B");
        Reine reinen = new Reine(3, 0,"N");
        grille.getTabGrille()[3][7] = reineb.toString();
        grille.getTabGrille()[3][0] = reinen.toString();
        tabPiece[3][7]=reineb;
        tabPiece[3][0]=reinen;

    }
	
	public Piece getPiece(int x, int y){
		return tabPiece[x][y];
	}
	
	public void setPieceVide(int x, int y){
		tabPiece[x][y]=null;
	}
	
	public void setPiece(int x, int y, Piece p) {
		tabPiece[x][y]=p;
	}
	
	public static Piece[][] getTabPiece(){
		return tabPiece;
	}

}
