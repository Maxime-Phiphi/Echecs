package jeu;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import damier.Case;
import damier.Damier;
import piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

import static damier.Damier.TAILLE;

public class JeuControleur extends JPanel implements MouseListener {
    Jeu jeu;
    private String currentPlayer = "B";

    public JeuControleur(Jeu jeu) {
        setOpaque(false);
        setLayout(new BorderLayout());
        this.addMouseListener(this);
        this.jeu = jeu;
    }

    public void paintComponent(Graphics g) {
        jeu.getD().paintComponent(g);
        for (Piece p : jeu.getListPiece()) {
            p.paintComponent(g);
            repaint();
        }
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void paintDeplacement(boolean[][] verif) {
        for (int i = 0; i< TAILLE; i++){
            for(int j = 0; j< TAILLE; j++){
                if(verif[i][j]){
                    Case c = jeu.getD().getCaseAt(i,j);
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
            Case c = jeu.getD().getCaseAt(x,y);

            if (c.isOccupe() && jeu.isaClickPiece()) { // Si on clique sur une piece
                if (Objects.equals(currentPlayer, jeu.getPieceAt(x, y).getCouleur())){ //Si la piece est de la meme couleur que le joueur actuel
                    jeu.setP(jeu.getPieceAt(x, y));
                    jeu.setVerif(jeu.getP().checkCase(jeu.getListPiece()));
                    for (int i = 0; i < TAILLE; i++) {
                        for (int j = 0; j < TAILLE; j++) {
                            System.out.println(i + " " + j + " " + jeu.getVerif()[i][j]);
                        }
                    }
                    paintDeplacement(jeu.getVerif());
                    jeu.setaClickPiece(false);
                }
            } else if (!c.isOccupe() && jeu.getVerif()[x][y]) { // si on clique sur une case verte vide
                jeu.getP().setPosition(x, y);
                jeu.getD().setCasesOccupees(jeu.getListPiece());
                paintDeplacement(jeu.getVerif());
                repaint();
                jeu.setaClickPiece(true);
                echangerJoueur();
            } else if (c.isOccupe() && jeu.getVerif()[x][y]) { // si on mange (donc on clique sur une case verte avec quelqu'un dedans)
                jeu.getListPiece().remove(jeu.getPieceAt(x, y));
                jeu.getP().setPosition(x, y);
                jeu.getD().setCasesOccupees(jeu.getListPiece());
                paintDeplacement(jeu.getVerif());
                repaint();
                jeu.setaClickPiece(true);
                echangerJoueur();
            }
        }

    }

    private void echangerJoueur() {
        if(Objects.equals(currentPlayer, "B"))
            currentPlayer="N";
        else
            currentPlayer="B";
    }

    public void deserialize(File file){
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.addPermission(AnyTypePermission.ANY);
        try {
            FileInputStream fis = new FileInputStream(file);
            jeu = (Jeu) xstream.fromXML(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

