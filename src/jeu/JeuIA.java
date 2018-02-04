package jeu;

import damier.Case;
import damier.Damier;
import piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static damier.Damier.TAILLE;

public class JeuIA extends JPanel implements MouseListener {
	

    private ArrayList<Piece> listPiece = new ArrayList<>();
    private Damier d = new Damier();
    private Piece p;
    boolean[][] verif= new boolean[8][8];
    boolean aClickPiece = true;
    private static boolean echecNoir = false; 
    private static boolean echecBlanc = false; 
    private static boolean roqueB = false; 
    private static boolean roqueN = false; 
    private static boolean moveRB = false; 
    private static boolean moveRN = false; 
    private static int yPrec = 0;
    private static int xPrec = 0;
    private static String playerColor = "B";


    public JeuIA() throws IOException{
        setOpaque(false);
        setLayout(new BorderLayout());
        this.addMouseListener(this);
        Initialiser();
        
        d.setCasesOccupees(listPiece);
    }
    
    public JeuIA(String s) throws IOException{
    	
        setOpaque(false);
        setLayout(new BorderLayout());
        this.addMouseListener(this);
        Initialiser(s);
        
        d.setCasesOccupees(listPiece);
    }

    public void Initialiser(String fichier) throws IOException {
    	try {
    		String[] placement = new String[34];
    		String[] placementBlanc= new String[16];
    		String[] placementNoir = new String[16];
    		Scanner fileIn = new Scanner(new File(fichier));
    		int i = 0;
			while(fileIn.hasNextLine()) {
				placement[i]=fileIn.nextLine();
				i++;
			}
			
				for(int j = 0; j<16;j++) {
					placementBlanc[j]=placement[j+1];
				}
				for(int k = 0; k<16;k++) {
					placementNoir[k]=placement[k+18];
				}
			
				
			
			
			
			for(String s : placementBlanc) {
				int x=-1, y=-1;
				String[] piece = s.split("\t");
				switch(piece[1].charAt(0)) {
				case 'a':
					x = 0;
					break;
				case 'b':
					x=1;
					break;
				case 'c':
					x=2;
					break;
				case 'd':
					x=3;
					break;
				case 'e':
					x=4;
					break;
				case 'f':
					x=5;
					break;
				case 'g':
					x=6;
					break;
				case 'h':
					x=7;
					break;
					}
				try {
					switch(piece[1].charAt(1)) {
				
				case '8':
					y = 0;
					break;
				case '7':
					y=1;
					break;
				case '6':
					y=2;
					break;
				case '5':
					y=3;
					break;
				case '4':
					y=4;
					break;
				case '3':
					y=5;
					break;
				case '2':
					y=6;
					break;
				case '1':
					y=7;
					break;
				}
				}catch(Exception e) {
					
				}
				switch(piece[0].charAt(0)) {
				case 'p':
					Pion pionb1 = new Pion(x,y,"B", d);
					listPiece.add(pionb1);
					break;
				case 't':
					Tour tourb = new Tour(x,y,"B",d);
					listPiece.add(tourb);
					break;
				case 'b':
					Fou foub = new Fou(x,y,"B", d);
					listPiece.add(foub);
					break;
				case 'q':
					Reine reineb = new Reine(x,y,"B", d);
					listPiece.add(reineb);
					break;
				case 'k':
					if(piece[0].charAt(1)!=' ') {
						Cavalier cavalierb1= new Cavalier(x, y, "B",d);
						listPiece.add(cavalierb1);
					}else {
						Roi roib = new Roi(x,y,"B", d);
						listPiece.add(roib);
					}
				
				}
				
			}
			for(String s : placementNoir) {
				int x=-1, y=-1;
				String[] piece = s.split("\t");
				switch(piece[1].charAt(0)) {
				case 'a':
					x = 0;
					break;
				case 'b':
					x=1;
					break;
				case 'c':
					x=2;
					break;
				case 'd':
					x=3;
					break;
				case 'e':
					x=4;
					break;
				case 'f':
					x=5;
					break;
				case 'g':
					x=6;
					break;
				case 'h':
					x=7;
					break;
					}
				try {
					switch(piece[1].charAt(1)) {
				
				case '8':
					y = 0;
					break;
				case '7':
					y=1;
					break;
				case '6':
					y=2;
					break;
				case '5':
					y=3;
					break;
				case '4':
					y=4;
					break;
				case '3':
					y=5;
					break;
				case '2':
					y=6;
					break;
				case '1':
					y=7;
					break;
				}
				}catch(Exception e) {
					
				}
				switch(piece[0].charAt(0)) {
				case 'p':
					Pion pionn1 = new Pion(x,y,"N", d);
					listPiece.add(pionn1);
					break;
				case 't':
					Tour tourn = new Tour(x,y,"N",d);
					listPiece.add(tourn);
					break;
				case 'b':
					Fou foun = new Fou(x,y,"N", d);
					listPiece.add(foun);
					break;
				case 'q':
					Reine reinen = new Reine(x,y,"N", d);
					listPiece.add(reinen);
					break;
				case 'k':
					if(piece[0].charAt(1)!=' ') {
						Cavalier cavaliern1= new Cavalier(x, y, "N",d);
						listPiece.add(cavaliern1);
					}else {
						Roi roin = new Roi(x,y,"N", d);
						listPiece.add(roin);
					}
				
				}
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
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

    public boolean checkEchec() {

    	for(Piece p : listPiece) {
    	
    		if(p.getNom().equals("RN"))
    			for(Piece p1 : listPiece) {
    				boolean[][] tabCases = p1.checkCase();
    				if(tabCases[p.getX()][p.getY()]) {
    					JOptionPane.showMessageDialog(this, "Roi noir en échec");
    					echecNoir = true; 
    				}
    				
    			}
    		if(p.getNom().equals("RB")) {
    			for(Piece p2 :listPiece) {
    				boolean[][] tabCasesBis = p2.checkCase();
    				if(tabCasesBis[p.getX()][p.getY()]) {
    					JOptionPane.showMessageDialog(this, "Roi blanc en échec");
    					echecBlanc = true;
    				}
    				
    			}
    		}
    	}
    	return false;
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
    
    public void checkRoi(Piece p) {
    	if(p.getNom().equals("RN"))
    		moveRN = true; 
    	if(p.getNom().equals("RB"))
    		moveRB = true;
    }
    
    public static boolean getMoveRB() {
    	return moveRB;
    }
    
    public static boolean getMoveRN() {
    	return moveRN;
    }
    
    public static boolean getEchecBlanc() {
    	return echecBlanc;
    }
    
    public static boolean getEchecNoir() {
    	return echecNoir;
    }
    
    public static boolean getRoqueB() {
    	return roqueB;
    }
    
    public static boolean getRoqueN() {
    	return roqueN;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	
        if(e.getButton()==1){

            int x = (e.getX()-50)/75;
            int y = (e.getY()-50)/75;
            Case c = d.getCaseAt(x,y);
            
            //System.out.println("Blanc commence");
            System.out.println(playerColor);
           
            if (c.isOccupe() && aClickPiece ) { // Si on clique sur une piece
            	if(getPieceAt(x,y).getCouleur()=="B") {
            	yPrec = y;
            	xPrec = x;
            	p = getPieceAt(x, y);
                verif = p.checkCase();
                for (int i = 0; i <TAILLE ; i++) {
                    for (int j = 0; j < TAILLE ; j++) {
                        //System.out.println(i + " "+ j + " "+  verif[i][j]);
                    }

                }
                paintDeplacement(verif);
                aClickPiece = false;
                
                if(!p.aucunDeplacementPossible(verif)) {
                	JOptionPane.showMessageDialog(this, "Cette pièce ne peut aller nulle part");
                	aClickPiece = true;
                }
            	}else
            		JOptionPane.showMessageDialog(this, "Ce n'est pas a toi de jouer");
            		
            }

            else if (!c.isOccupe() && verif[x][y]){ // si on clique sur une case verte vide
            	
            	
            	if(p.getNom().equals("RB")) {
            		
            		if(x==p.getX()-2) {
            			
            			listPiece.remove(getPieceAt(0,7));
            			Tour tourb = new Tour(3, 7, "B",d);
            			listPiece.add(tourb);
            			roqueB = true; 
            		}
            		if(x==p.getX()+2) {
            			
            			listPiece.remove(getPieceAt(7,7));
            			Tour tourb = new Tour(5, 7, "B",d);
            			listPiece.add(tourb);
            			roqueB = true; 
            		}
            	}
            	if(p.getNom().equals("RN")) {
            		
            		if(x==p.getX()-2) {
            			
            			listPiece.remove(getPieceAt(0,0));
            			Tour tourn = new Tour(3, 0, "N",d);
            			listPiece.add(tourn);
            			roqueN = true; 
            		}
            		if(x==p.getX()+2) {
            			
            			listPiece.remove(getPieceAt(7,0));
            			Tour tourn = new Tour(5, 0, "N",d);
            			listPiece.add(tourn);
            			roqueN = true; 
            		}
            	}
            	
            	p.setPosition(x,y);
            	d.setCasesOccupees(listPiece);
            	paintDeplacement(verif);
            	repaint();
            	aClickPiece = true;
            	checkEchec();
            	checkRoi(p);
            	changeColor(playerColor);
            	checkPromotion(p, x, y);
            	tourOrdi();
            	
            	if(p.getNom().equals("PB")&&y==4&&yPrec==6) {
            		
            		if(x<7&&getPieceAt(x+1, y)!=null&&getPieceAt(x+1, y).getNom().equals("PN")) {
            			double rd = Math.random();
            			if(rd<0.5) {
            				listPiece.remove(getPieceAt(x+1,y));
            				listPiece.remove(getPieceAt(x,y));
            				Pion pionn = new Pion(x, y+1, "N",d);
            				listPiece.add(pionn);
            				d.setCasesOccupees(listPiece);
                            repaint();
                            aClickPiece = true;
                            checkEchec();
                            checkRoi(p);
            			}
            		}
            		if(x>0&&getPieceAt(x-1, y)!=null&&getPieceAt(x-1, y).getNom().equals("PN")) {
            			double result = Math.random();
            			if(result<0.5) {
            				listPiece.remove(getPieceAt(x-1,y));
            				listPiece.remove(getPieceAt(x,y));
            				Pion pionn = new Pion(x, y+1, "N",d);
            				listPiece.add(pionn);
            				d.setCasesOccupees(listPiece);
                            repaint();
                            aClickPiece = true;
                            checkEchec();
                            checkRoi(p);
            			}
            		}
            	}
            	if(p.getNom().equals("PN")&&y==3&&yPrec==1) {
            		
            		if(x<7&&getPieceAt(x+1, y)!=null&&getPieceAt(x+1, y).getNom().equals("PB")) {
            			int result = JOptionPane.showConfirmDialog((Component) null, "Voulez-vous le prendre en passant","alert", JOptionPane.YES_NO_CANCEL_OPTION);
            			if(result==0) {
            				listPiece.remove(getPieceAt(x+1,y));
            				listPiece.remove(getPieceAt(x,y));
            				Pion pionb = new Pion(x, y-1, "B",d);
            				listPiece.add(pionb);
            				d.setCasesOccupees(listPiece);
                            repaint();
                            aClickPiece = true;
                            checkEchec();
                            checkRoi(p);
            			}
            		}
            		if(x>0&&getPieceAt(x-1, y)!=null&&getPieceAt(x-1, y).getNom().equals("PB")) {
            			int result = JOptionPane.showConfirmDialog((Component) null, "Voulez-vous le prendre en passant","alert", JOptionPane.YES_NO_CANCEL_OPTION);
            			if(result==0) {
            				listPiece.remove(getPieceAt(x-1,y));
            				listPiece.remove(getPieceAt(x,y));
            				Pion pionb = new Pion(x, y-1, "B",d);
            				listPiece.add(pionb);
            				d.setCasesOccupees(listPiece);
                            repaint();
                            aClickPiece = true;
                            checkEchec();
                            checkRoi(p);
            			}
            		}
            	}
            }
            else if (c.isOccupe() && verif[x][y]){ // si on mange (donc on lcique sur une case verte avec quelqu'un dedans)
            	
                listPiece.remove(getPieceAt(x,y));
                p.setPosition(x,y);
                d.setCasesOccupees(listPiece);
                paintDeplacement(verif);
                checkPromotion(p, x, y);
                repaint();
                aClickPiece = true;
                checkEchec();
                checkRoi(p);
                changeColor(playerColor);
                tourOrdi();
                
                
            }
     
        }	
        

    }
    
    public void tourOrdi() {
    	boolean move = false;
    	while(!move) {
    	for(Piece p: listPiece) {
    		
    		if(p.getCouleur()=="N") {
    			
    			double rd = Math.random();
    			if(rd<0.05) {
    				System.out.println(p.getNom());
    				verif=p.checkCase();
    				for(int i = 0;i<verif[0].length;i++) {
    					for(int j = 0; j<verif[0].length;j++) {
    						double rd2 = Math.random();
    						if(verif[j][i]&&rd2<0.05&&!move) {
    							/*if(getPieceAt(j,i)) {
    								listPiece.remove(getPieceAt(j,i));
    							}*/
    							System.out.println("hello");
    			                	p.setPosition(j,i);
    			                	d.setCasesOccupees(listPiece);
    			                	//paintDeplacement(verif);
    			                	checkPromotion(p, j, i);
    			                	repaint();
    			                	
    			                	checkEchec();
    			                	checkRoi(p);
    			                	move = true;
    			                	break;
    						}
    					}
    				}
    			}
    		}
    	}
    	}
    }
    
    
    
    
    public void checkPromotion(Piece p, int x, int y) {
    	String couleur = null;
    	if(p.getNom().equals("PB")&&y==0) {
    		System.out.println("prom");
    		couleur = "B";
    		promotionPion(x,y,couleur);
    	}
    	if(p.getNom().equals("PN")&&y==7) {
    		couleur = "N";
    		promotionPion(x,y);
    	}
    }
    public void changeColor(String s) {
    	if(s=="B")
    		playerColor="N";
    	if(s=="N")
    		playerColor="B";
    }
    public void promotionPion(int x, int y) {
    	listPiece.remove(getPieceAt(x,y));
		Reine reinen = new Reine(x,y,"N", d);
		listPiece.add(reinen);
    }
    public void promotionPion(int x, int y, String couleur) {
    	
    	Object[] options = {"Reine",
                "Tour",
                "Fou",
                "Cavalier"};
		int choix = JOptionPane.showOptionDialog(this,
			    "En quelle pièce voulez vous promouvoir votre pion ?",
			    "Promotion du pion",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options, null);
		switch(choix) {
		case 0:
			listPiece.remove(getPieceAt(x,y));
			Reine reinen = new Reine(x,y,couleur, d);
			listPiece.add(reinen);
			break;
		case 1: 
			listPiece.remove(getPieceAt(x,y));
			Tour tourn = new Tour(x,y,couleur, d);
			listPiece.add(tourn);
			break;
		case 2:
			listPiece.remove(getPieceAt(x,y));
			Fou foun = new Fou(x,y,couleur, d);
			listPiece.add(foun);
			break;
		case 3: 
			listPiece.remove(getPieceAt(x,y));
			Cavalier cavaliern = new Cavalier(x,y,couleur, d);
			listPiece.add(cavaliern);
			break;
		default: 
			listPiece.remove(getPieceAt(x,y));
			Reine rn = new Reine(x,y,couleur, d);
			listPiece.add(rn);
			break;
		}
		
		d.setCasesOccupees(listPiece);
        repaint();
        checkEchec();
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
