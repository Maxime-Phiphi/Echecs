package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Pion extends Piece {

    public Pion(int x, int y,  String couleur, Damier d) {
        super("P" + couleur, x, y,couleur, d);
        try {
            if(Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/pb.png")));
            else
                this.setImg(ImageIO.read(new File("img/pn.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.getNom();
    }


    @Override
    public boolean[][] checkCase(List<Piece> listPiece) {
        boolean[][] verif = new boolean[8][8];
        if (Objects.equals(getCouleur(), "B")){

            if (!d.getCaseAt(getX(),getY()-1).isOccupe()) // si y a personne au dessus de lui
                verif[getX()][getY() - 1] = true; //il peut y aller
            if (d.getCaseAt(getX()-1,getY()-1) != null && d.getCaseAt(getX()-1,getY()-1).isOccupe() && Objects.equals(d.getCouleurPieceAt(getX() - 1, getY() - 1, listPiece), "N")) //si y a quelqu'un dans la diagonale a gauche,
                verif[getX() - 1][getY() - 1] = true;
            if (d.getCaseAt(getX()+1,getY()-1) != null && d.getCaseAt(getX()+ 1,getY()-1).isOccupe() && Objects.equals(d.getCouleurPieceAt(getX() + 1, getY() - 1, listPiece), "N")) // diago droite
                verif[getX() + 1][getY() - 1] = true;
            if (getY() == 6) // si c'est son premier coup il peut avancer de 2
                verif[getX()][getY() - 2] = true;
        }
        else {
            if (!d.getCaseAt(getX(),getY()+1).isOccupe()) // si y a personne au dessus de lui
                verif[getX()][getY() + 1] = true; //il peut y aller
            if (d.getCaseAt(getX()-1,getY()+1) != null && d.getCaseAt(getX()-1,getY()+1).isOccupe() && Objects.equals(d.getCouleurPieceAt(getX() - 1, getY() + 1, listPiece), "B")) //si y a quelqu'un dans la diagonale a gauche
                verif[getX() - 1][getY() + 1] = true;
            if (d.getCaseAt(getX()+1,getY()+1) != null && d.getCaseAt(getX()+1,getY()+ 1).isOccupe() && Objects.equals(d.getCouleurPieceAt(getX() + 1, getY() + 1, listPiece), "B")) // diago droite
                verif[getX() + 1][getY() + 1] = true;
            if (getY() == 1) // si c'est son premier coup il peut avancer de 2
                verif[getX()][getY() + 2] = true;
        }
        return verif;
    }
}
