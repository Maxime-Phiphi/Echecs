package jeu;

import damier.Case;
import damier.Damier;
import piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static damier.Damier.TAILLE;

public class Jeu extends JPanel implements MouseListener {
	

    private ArrayList<Piece> listPiece = new ArrayList<>();
    private Damier d = new Damier();
    private Piece p;
    boolean[][] verif= new boolean[8][8];
    boolean aClickPiece = true;


    public Jeu() {
        setOpaque(false);
        setLayout(new BorderLayout());
        this.addMouseListener(this);
        Initialiser();
        d.setCasesOccupees(listPiece);
    }

	public void Initialiser(){

        for(int i = 0; i< Grille.getTaille(); i++) {
        	
            Pion pionn = new Pion(i, 1, "N",d);
            Pion pionb = new Pion(i, 6, "B",d);
          listPiece.add(pionn);
          listPiece.add(pionb);

        }

        for (int i = 0; i< Grille.getTaille(); i+=7){
            Tour tourb = new Tour(i, 7, "B",d);
            Tour tourn = new Tour(i, 0, "N",d);
            listPiece.add(tourb);
            listPiece.add(tourn);
        }

        for (int i = 1; i< Grille.getTaille(); i+=5){
            Cavalier cavalierb = new Cavalier(i, 7, "B",d);
            Cavalier cavaliern = new Cavalier(i, 0, "N",d);
            listPiece.add(cavalierb);
            listPiece.add(cavaliern);

        }

        for (int i = 2; i< Grille.getTaille(); i+=3){
            Fou foub = new Fou(i, 7, "B",d);
            Fou foun = new Fou(i, 0, "N",d);
            listPiece.add(foub);
            listPiece.add(foun);
        }

        Roi roib = new Roi(4, 7,"B",d);
        Roi roin = new Roi(4, 0,"N",d);
        listPiece.add(roib);
        listPiece.add(roin);

        Reine reineb = new Reine(3, 7, "B",d);
        Reine reinen = new Reine(3, 0,"N",d);
        listPiece.add(reineb);
        listPiece.add(reinen);

    }

    public void paintComponent(Graphics g) {
	    d.paintComponent(g);
        for (Piece p : getListPiece()) {
            p.paintComponent(g);
            repaint();
        }
    }

    public ArrayList<Piece> getListPiece() {
        return listPiece;
    }



    public Piece getPieceAt (int x, int y){
        for (Piece p: listPiece) {
            if (p.getY()==y && p.getX()==x){
                return p;
            }
        }
        return null;
    }
    public void paintDeplacement(boolean[][] verif) {
        for (int i = 0; i< TAILLE; i++){
            for(int j = 0; j< TAILLE; j++){
             if(verif[i][j]){
                 Case c = d.getCaseAt(i,j);
                 c.changeCouleur();
                 repaint();
             }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1){

            int x = (e.getX()-50)/75;
            int y = (e.getY()-50)/75;
            Case c = d.getCaseAt(x,y);


            if (c.isOccupe() && aClickPiece) { // Si on clique sur une piece
                p = getPieceAt(x, y);
                verif = p.checkCase();
                for (int i = 0; i <TAILLE ; i++) {
                    for (int j = 0; j < TAILLE ; j++) {
                        //System.out.println(i + " "+ j + " "+  verif[i][j]);
                    }

                }
                paintDeplacement(verif);
                aClickPiece = false;
            }

            else if (!c.isOccupe() && verif[x][y]){ // si on clique sur une case verte vide
                  p.setPosition(x,y);
                  d.setCasesOccupees(listPiece);
                  paintDeplacement(verif);
                  repaint();
                  aClickPiece = true;
            }
            else if (c.isOccupe() && verif[x][y]){ // si on mange (donc on lcique sur une case verte avec quelqu'un dedans)
                listPiece.remove(getPieceAt(x,y));
                System.out.println("manger!!!!!!!!!!!!");
                p.setPosition(x,y);
                d.setCasesOccupees(listPiece);
                paintDeplacement(verif);
                repaint();
                aClickPiece = true;
                
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

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
