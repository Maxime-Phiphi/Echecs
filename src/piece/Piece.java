package piece;

import damier.Damier;
import jeu.Jeu;
import java.awt.*;
import java.awt.image.BufferedImage;

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
}
