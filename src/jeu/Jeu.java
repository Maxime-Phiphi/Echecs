package jeu;

import piece.*;

public class Jeu {
	

	protected static Piece[][] tabPiece = new Piece[8][8];

    public Jeu() {

        Initialiser();
    }

	
	public void Initialiser(){

        for(int i = 0; i< Grille.getTaille(); i++) {
        	
            Pion pionn = new Pion(i, 1, "N");
            Pion pionb = new Pion(i, 6, "B");
            tabPiece[i][1] = pionn;
            tabPiece[i][6] = pionb;
        }

        for (int i = 0; i< Grille.getTaille(); i+=7){
            Tour tourb = new Tour(i, 7, "B");
            Tour tourn = new Tour(i, 0, "N");
            tabPiece[i][7]=tourb;
            tabPiece[i][0]=tourn;
        }

        for (int i = 1; i< Grille.getTaille(); i+=5){
            Cavalier cavalierb = new Cavalier(i, 7, "B");
            Cavalier cavaliern = new Cavalier(i, 0, "N");
            tabPiece[i][7]=cavalierb;
            tabPiece[i][0]=cavaliern;
        }

        for (int i = 2; i< Grille.getTaille(); i+=3){
            Fou foub = new Fou(i, 7, "B");
            Fou foun = new Fou(i, 0, "N");
            tabPiece[i][7]=foub;
            tabPiece[i][0]=foun;
            
        }

        Roi roib = new Roi(4, 7,"B");
        Roi roin = new Roi(4, 0,"N");
        tabPiece[4][7]=roib;
        tabPiece[4][0]=roin;

        Reine reineb = new Reine(3, 7, "B");
        Reine reinen = new Reine(3, 0,"N");
        tabPiece[3][7]=reineb;
        tabPiece[3][0]=reinen;

    }
	
	public Piece getPiece(int x, int y){
		return tabPiece[x][y];
	}
	
//	public void setPieceVide(int x, int y){
//		tabPiece[x][y]=null;
//	}
//
//	public void setPiece(int x, int y, Piece p) {
//		tabPiece[x][y]=p;
//	}
//
//	public static Piece[][] getTabPiece(){
//		return tabPiece;
//	}

}
