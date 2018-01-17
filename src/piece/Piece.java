package piece;

import jeu.Jeu;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Piece implements CheckDeplacement{
    private int COTECASE = 75;


    private String nom;
    protected Piece[][] tabPiece = new Piece[8][8]; 
    private String couleur;
    private int coordX;
    private int coordY;
    private BufferedImage img = null;


    public Piece(String nom, int x, int y, String couleur) {
        this.nom = nom;
        this.coordX = x;
        this.coordY = y;
        this.couleur = couleur;
        ajouterTab();
    }
    public void setImg(BufferedImage img){
        this.img = img;
    }

    public String getNom() {
        return nom;
    }


    public void ajouterTab() {
    	tabPiece[this.coordX][this.coordY]=this;
    }

    public int getX() {
    	return this.coordX;
    }
    public int getY() {
    	return this.coordY;
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

}
