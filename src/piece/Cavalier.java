package piece;




import damier.Damier;
import sun.security.util.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Cavalier extends Piece {
    public Cavalier(int x, int y, String couleur, Damier d) {
        super("C" + couleur, x, y, couleur, d);
        try {
            if(Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/cb.png")));
            else
                this.setImg(ImageIO.read(new File("img/cn.png")));
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
        // au bord en haut
        if (getY()==0){

        }

        // au bord en bas
        if (getY()==7){

        }

        //au bord a gauche
        if (getX()==0){

        }
        // au bord a droite
        if (getX()==7){
            verif[getX()-1][getY()+2] = true;
            verif[getX()-1][getY()-2] = true;
            verif[getX()-1][getY()-2] = true;
            verif[getX()-2][getY()-1] = true;
            verif[getX()-2][getY()-1] = true;
        }
        // au bord a droite vers le bas
        if (getX()==7 && getY()==6){
            verif[getX()-1][getY()-2] = true;
            verif[getX()-1][getY()-2] = true;
            verif[getX()-2][getY()-1] = true;
            verif[getX()-2][getY()-1] = true;
        }
        // pas au bord
        if (getX()!=0 && getX()!=7 && getY()!=0 && getY()!=7){
            verif[getX()+1][getY()+2] = true;
            verif[getX()-1][getY()+2] = true;
            verif[getX()-1][getY()-2] = true;
            verif[getX()-1][getY()-2] = true;
            verif[getX()+2][getY()+1] = true;
            verif[getX()+2][getY()-1] = true;
            verif[getX()-2][getY()-1] = true;
            verif[getX()-2][getY()-1] = true;
        }
        return verif;
    }
}
