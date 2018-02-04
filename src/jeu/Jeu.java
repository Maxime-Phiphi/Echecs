package jeu;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import damier.Damier;
import piece.*;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@XStreamAlias("jeu")
public class Jeu {
    @XStreamOmitField
    private ArrayList<Piece> listPiece = new ArrayList<>();
    private Damier d = new Damier();
    private Piece p;
    boolean[][] verif= new boolean[8][8];
    boolean aClickPiece = true;

    public Jeu() {
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

    public Damier getD() {
        return d;
    }

    public Piece getP() {
        return p;
    }

    public boolean[][] getVerif() {
        return verif;
    }

    public boolean isaClickPiece() {
        return aClickPiece;
    }

    public void setListPiece(ArrayList<Piece> listPiece) {
        this.listPiece = listPiece;
    }

    public void setD(Damier d) {
        this.d = d;
    }

    public void setP(Piece p) {
        this.p = p;
    }

    public void setVerif(boolean[][] verif) {
        this.verif = verif;
    }

    public void setaClickPiece(boolean aClickPiece) {
        this.aClickPiece = aClickPiece;
    }

    public void serialize(File file){
        // Instanciation de la classe XStream
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        // Convertion du contenu de l'objet article en XML
        String xml = xstream.toXML(this);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(xml);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
