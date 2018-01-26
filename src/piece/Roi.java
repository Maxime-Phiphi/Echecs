package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Roi extends Piece {
    public Roi(int x, int y, String couleur, Damier d) {
        super("R" + couleur, x, y, couleur, d);

        try {
            if (Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/Rb.png")));
            else
                this.setImg(ImageIO.read(new File("img/Rn.png")));
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
        // S'il est au bord en bas
        if (getY()==7){
            if (!d.getCaseAt(getX(),getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()-1,listPiece))
                verif[getX()][getY()-1]=true;
            if (!d.getCaseAt(getX()-1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY(),listPiece))
                verif[getX()-1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY(),listPiece))
                verif[getX()+1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()-1,listPiece))
                verif[getX()+1][getY()-1]=true;
            if (!d.getCaseAt(getX()-1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()-1,listPiece))
                verif[getX()-1][getY()-1]=true;
        }

        //S'il est au bord en haut
        if (getY()==0){
            if (!d.getCaseAt(getX(),getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()+1,listPiece))
                verif[getX()][getY()+1]=true;
            if (!d.getCaseAt(getX()-1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY(),listPiece))
                verif[getX()-1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY(),listPiece))
                verif[getX()+1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()+1,listPiece))
                verif[getX()+1][getY()+1]=true;
            if (!d.getCaseAt(getX()-1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()+1,listPiece))
                verif[getX()-1][getY()+1]=true;
        }
        // S'il est au bord a gauche et qu'y personne ou une piece d'une autre couleur
        if (getX()==0){
            if (!d.getCaseAt(getX(),getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()-1,listPiece))
                verif[getX()][getY() - 1] = true;

            if (!d.getCaseAt(getX(),getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()+1,listPiece))
                verif[getX()][getY()+1]=true;

            if (!d.getCaseAt(getX()+1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY(),listPiece))
                verif[getX()+1][getY()]=true;

            if (!d.getCaseAt(getX()+1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()+1,listPiece))
                verif[getX()+1][getY()+1]=true;

            if (!d.getCaseAt(getX()+1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()-1,listPiece))
                verif[getX()+1][getY()-1]=true;
        }
        //S'il est au bord a droite et personne ou autre couleur
        if (getX()==7){
            if (!d.getCaseAt(getX(),getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()-1,listPiece))
                verif[getX()][getY()-1]=true;

            if (!d.getCaseAt(getX(),getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()+1,listPiece))
                verif[getX()][getY()+1]=true;

            if (!d.getCaseAt(getX()-1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY(),listPiece))
            verif[getX()-1][getY()]=true;

            if (!d.getCaseAt(getX()-1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()+1,listPiece))
            verif[getX()-1][getY()+1]=true;

            if (!d.getCaseAt(getX()-1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()-1,listPiece))
            verif[getX()-1][getY()-1]=true;
        }
        // else
        if (getY()!=0 && getY()!=7 && getX()!=0 && getX()!=7){

            if (!d.getCaseAt(getX(),getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()-1,listPiece))
                verif[getX()][getY()-1]=true;
            if (!d.getCaseAt(getX(),getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX(),getY()+1,listPiece))
                verif[getX()][getY()+1]=true;
            if (!d.getCaseAt(getX()-1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY(),listPiece))
                verif[getX()-1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY(),listPiece))
                verif[getX()+1][getY()]=true;
            if (!d.getCaseAt(getX()+1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()+1,listPiece))
                verif[getX()+1][getY()+1]=true;
            if (!d.getCaseAt(getX()-1,getY()+1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()+1,listPiece))
                verif[getX()-1][getY()+1]=true;
            if (!d.getCaseAt(getX()+1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()+1,getY()-1,listPiece))
                verif[getX()+1][getY()-1]=true;
            if (!d.getCaseAt(getX()-1,getY()-1).isOccupe() || d.getCouleurPieceAt(getX(),getY(),listPiece)!= d.getCouleurPieceAt(getX()-1,getY()-1,listPiece))
                verif[getX()-1][getY()-1]=true;
        }

        return verif;
    }
}