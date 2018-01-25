package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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
    public boolean[][] checkCase() {
        boolean[][] verif = new boolean[8][8];
        if (Objects.equals(getCouleur(), "B")){

            if (outBounds(getY())&&d.getCaseAt(getX(),getY()-1).getOccupe()=="") // si y a personne au dessus de lui
                verif[getX()][getY() - 1] = true; //il peut y aller
            if (outBounds(getY())&&outBounds(getX())&&d.getCaseAt(getX()-1,getY()-1).getOccupe()=="N") //si y a quelqu'un dans la diagonale a gauche
                verif[getX() - 1][getY() - 1] = true;
            if (outBounds(getY())&&outBounds(getX())&&d.getCaseAt(getX()+ 1,getY()-1).getOccupe()=="N") // diago droite
                verif[getX() + 1][getY() - 1] = true;
            if (getY() == 6&&!d.getCaseAt(getX(),getY()-2).isOccupe()) // si c'est son premier coup il peut avancer de 2
                verif[getX()][getY() - 2] = true;
        }
        else {
            if (outBounds(getY())&&d.getCaseAt(getX(),getY()+1).getOccupe()=="") // si y a personne au dessus de lui
                verif[getX()][getY() + 1] = true; //il peut y aller
            if (outBounds(getY())&&outBounds(getX())&&d.getCaseAt(getX()-1,getY()+1).getOccupe()=="B") //si y a quelqu'un dans la diagonale a gauche
                verif[getX() - 1][getY() + 1] = true;
            if (outBounds(getY())&&outBounds(getX())&&d.getCaseAt(getX()+1,getY()+ 1).getOccupe()=="B") // diago droite
                verif[getX() + 1][getY() + 1] = true;
            if (getY() == 1&&!d.getCaseAt(getX(),getY()+2).isOccupe()) // si c'est son premier coup il peut avancer de 2
                verif[getX()][getY() + 2] = true;
        }
        return verif;
    }
}
