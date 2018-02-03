package piece;

import damier.Case;
import damier.Damier;
import jeu.Jeu;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Piece implements CheckDeplacement{
	private int COTECASE = 75;
	protected Damier d;

	private String nom;
	//    protected Piece[][] tabPiece = new Piece[8][8];
	private String couleur;
	private int coordX;
	private int coordY;
	private BufferedImage img = null;


	public Piece(String nom, int x, int y, String couleur, Damier d) {
		this.nom = nom;
		this.coordX = x;
		this.coordY = y;
		this.couleur = couleur;
		this.d = d;
		//        ajouterTab();
	}
	public void setImg(BufferedImage img){
		this.img = img;
	}

	public String getNom() {
		return nom;
	}


	//    public void ajouterTab() {
	//    	tabPiece[this.coordX][this.coordY]=this;
	//    }

	public int getX() {
		return this.coordX;
	}
	public int getY() {
		return this.coordY;
	}

	public boolean outBounds(int n) {
		if(n<1||n>6) return false;
		return true;
	}

	public boolean innerBounds(int n) {
		if(n<2||n>5) return false; 
		return true;
	}


	public String getCouleur() {
		return couleur;
	}

	public void setPosition(int x, int y) {
		this.coordX = x; 
		this.coordY = y;
	}

	public void paintComponent(Graphics g){
		g.drawImage(this.img, (coordX+1)*COTECASE-10,(coordY+1)*COTECASE-5, null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Piece piece = (Piece) o;

		if (COTECASE != piece.COTECASE) return false;
		if (coordX != piece.coordX) return false;
		if (coordY != piece.coordY) return false;
		if (d != null ? !d.equals(piece.d) : piece.d != null) return false;
		if (nom != null ? !nom.equals(piece.nom) : piece.nom != null) return false;
		if (couleur != null ? !couleur.equals(piece.couleur) : piece.couleur != null) return false;
		return img != null ? img.equals(piece.img) : piece.img == null;
	}

	@Override
	public int hashCode() {
		int result = COTECASE;
		result = 31 * result + (d != null ? d.hashCode() : 0);
		result = 31 * result + (nom != null ? nom.hashCode() : 0);
		result = 31 * result + (couleur != null ? couleur.hashCode() : 0);
		result = 31 * result + coordX;
		result = 31 * result + coordY;
		result = 31 * result + (img != null ? img.hashCode() : 0);
		return result;
	}
	
	public boolean[][] checkDroites(boolean[][] tab){
		boolean[][] verif = tab;
		String col = this.getCouleur();
		int i = getX();
		int j = getX();
		int k = getY();
		int m = getY();
		

		while(i<7) {
			verif[i+1][getY()] = true; 
			if(d.getCaseAt(i+1, getY()).getOccupe()!="") {
				verif[i+1][getY()] = false; 
				if(d.getCaseAt(i+1, getY()).getOccupe()!=col) verif[i+1][getY()] = true;

				break;


			}

			i++;

		}
		while(k<7) {
			verif[getX()][k+1] = true; 
			if(d.getCaseAt(getX(), k+1).getOccupe()!="") {
				verif[getX()][k+1] = false;
				if(d.getCaseAt(getX(), k+1).getOccupe()!=col) verif[getX()][k+1] = true;

				break;

			}
			k++;

		}
		while(j>0) {
			verif[j-1][getY()] = true; 
			if(d.getCaseAt(j-1, getY()).getOccupe()!="") {
				verif[j-1][getY()] = false; 
				if(d.getCaseAt(j-1, getY()).getOccupe()!=col) verif[j-1][getY()] = true;
				break;

			}
			j--;

		}
		while(m>0) {
			verif[getX()][m-1] = true; 
			if(d.getCaseAt(getX(), m-1).getOccupe()!="") {
				verif[getX()][m-1] = false; 
				if(d.getCaseAt(getX(), m-1).getOccupe()!=col) verif[getX()][m-1] = true;
				break;

			}
			m--;

		}
		
		return verif;
	}
	public boolean[][] checkDroites(){
		boolean[][] verif = new boolean[8][8];
		String col = this.getCouleur();
		int i = getX();
		int j = getX();
		int k = getY();
		int m = getY();


		while(i<7) {
			verif[i+1][getY()] = true; 
			if(d.getCaseAt(i+1, getY()).getOccupe()!="") {
				verif[i+1][getY()] = false; 
				if(d.getCaseAt(i+1, getY()).getOccupe()!=col) verif[i+1][getY()] = true;

				break;


			}

			i++;

		}
		while(k<7) {
			verif[getX()][k+1] = true; 
			if(d.getCaseAt(getX(), k+1).getOccupe()!="") {
				verif[getX()][k+1] = false;
				if(d.getCaseAt(getX(), k+1).getOccupe()!=col) verif[getX()][k+1] = true;

				break;

			}
			k++;

		}
		while(j>0) {
			verif[j-1][getY()] = true; 
			if(d.getCaseAt(j-1, getY()).getOccupe()!="") {
				verif[j-1][getY()] = false; 
				if(d.getCaseAt(j-1, getY()).getOccupe()!=col) verif[j-1][getY()] = true;
				break;

			}
			j--;

		}
		while(m>0) {
			verif[getX()][m-1] = true; 
			if(d.getCaseAt(getX(), m-1).getOccupe()!="") {
				verif[getX()][m-1] = false; 
				if(d.getCaseAt(getX(), m-1).getOccupe()!=col) verif[getX()][m-1] = true;
				break;

			}
			m--;

		}
		
		return verif;


	}
	
	public boolean[][] checkDiag(){
		boolean[][] verif = new boolean[8][8];
		String col = this.getCouleur();
		int i = getX();
		int j = getX();
		int k = getY();
		int m = getY();
		int a = getX();
		int b = getY();
		int c = getX();
		int e = getY();
		boolean c1=false, c2=false, c3=false, c4=false;

		while(i<7&&k<7) {
			verif[i+1][k+1] = true; 
			if(d.getCaseAt(i+1, k+1).getOccupe()!="") {
				verif[i+1][k+1] = false; 
				if(d.getCaseAt(i+1, k+1).getOccupe()!=col) verif[i+1][k+1] = true;

				break;


			}

			i++;
			k++;

		}
		while(j<7&&m>0) {
			verif[j+1][m-1] = true; 
			if(d.getCaseAt(j+1, m-1).getOccupe()!="") {
				verif[j+1][m-1] = false;
				if(d.getCaseAt(j+1, m-1).getOccupe()!=col) verif[j+1][m-1] = true;

				break;

			}
			j++;
			m--;

		}
		while(a>0&&b>0) {
			verif[a-1][b-1] = true; 
			if(d.getCaseAt(a-1, b-1).getOccupe()!="") {
				verif[a-1][b-1] = false; 
				if(d.getCaseAt(a-1, b-1).getOccupe()!=col) verif[a-1][b-1] = true;
				break;

			}
			a--;
			b--;

		}
		while(c>0&&e<7) {
			verif[c-1][e+1] = true; 
			if(d.getCaseAt(c-1, e+1).getOccupe()!="") {
				verif[c-1][e+1] = false; 
				if(d.getCaseAt(c-1, e+1).getOccupe()!=col) verif[c-1][e+1] = true;
				break;

			}
			c--;
			e++;

		}
		
		return verif;

	}
	public boolean aucunDeplacementPossible(boolean[][] tab) {
		boolean retour = false; 
		for(boolean[] col: tab) {
			for(boolean b: col) {
				if(b) {
					retour = true; 
				}
			}
			
		}
		return retour;
	}

}
