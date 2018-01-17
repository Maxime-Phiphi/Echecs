package piece;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Pion extends Piece {

    public Pion(int x, int y,  String couleur) {
        super("P" + couleur, x, y,couleur);
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
    public boolean[][] checkCase(Piece p, boolean[][] verif) {
        if (p.getCouleur()=="B"){
            if (p.tabPiece[p.getX()][p.getY() - 1] == null) verif[p.getX()][p.getY() - 1] = true;
            else if (p.tabPiece[p.getX() - 1][p.getY() - 1] != null) verif[p.getX() - 1][p.getY() - 1] = true;
            else if (p.tabPiece[p.getX() + 1][p.getY() - 1] != null) verif[p.getX() + 1][p.getY() - 1] = true;
            if (p.getY() == 6) verif[p.getX()][p.getY() - 2] = true;
        }
        else {
            if (p.tabPiece[p.getX()][p.getY() + 1] == null) verif[p.getX()][p.getY() + 1] = true;
            else if (p.tabPiece[p.getX() - 1][p.getY() + 1] != null) verif[p.getX() - 1][p.getY() + 1] = true;
            else if (p.tabPiece[p.getX() + 1][p.getY() + 1] != null) verif[p.getX() + 1][p.getY() + 1] = true;
            if (p.getY() == 1) verif[p.getX()][p.getY() + 2] = true;
        }
        return verif;
    }
}
