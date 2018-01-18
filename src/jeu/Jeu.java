package jeu;

import piece.*;

import java.util.ArrayList;

public class Jeu {
	

    private ArrayList<Piece> listPiece = new ArrayList<>();

    public Jeu() {

        Initialiser();
    }

	
	public void Initialiser(){

        for(int i = 0; i< Grille.getTaille(); i++) {
        	
            Pion pionn = new Pion(i, 1, "N");
            Pion pionb = new Pion(i, 6, "B");
          listPiece.add(pionn);
          listPiece.add(pionb);
        }

        for (int i = 0; i< Grille.getTaille(); i+=7){
            Tour tourb = new Tour(i, 7, "B");
            Tour tourn = new Tour(i, 0, "N");
            listPiece.add(tourb);
            listPiece.add(tourn);
        }

        for (int i = 1; i< Grille.getTaille(); i+=5){
            Cavalier cavalierb = new Cavalier(i, 7, "B");
            Cavalier cavaliern = new Cavalier(i, 0, "N");
            listPiece.add(cavalierb);
            listPiece.add(cavaliern);

        }

        for (int i = 2; i< Grille.getTaille(); i+=3){
            Fou foub = new Fou(i, 7, "B");
            Fou foun = new Fou(i, 0, "N");
            listPiece.add(foub);
            listPiece.add(foun);
        }

        Roi roib = new Roi(4, 7,"B");
        Roi roin = new Roi(4, 0,"N");
        listPiece.add(roib);
        listPiece.add(roin);

        Reine reineb = new Reine(3, 7, "B");
        Reine reinen = new Reine(3, 0,"N");
        listPiece.add(reineb);
        listPiece.add(reinen);

    }

    public ArrayList<Piece> getListPiece() {
        return listPiece;
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
