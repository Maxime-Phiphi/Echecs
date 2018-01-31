package piece;

import damier.Damier;
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

        if (getX()+1<8 && getY()+2<8)
            verif[getX()+1][getY()+2] = true;

        if (getX()-1>=0 && getY()+2<8)
            verif[getX()-1][getY()+2] = true;

        if (getX()+1<8 && getY()-2>=0)
            verif[getX()+1][getY()-2] = true;

        if (getX()-1>=0 && getY()-2>0)
            verif[getX()-1][getY()-2] = true;

        if (getX()+2<8 && getY()+1<8)
            verif[getX()+2][getY()+1] = true;

        if (getX()-2>=0 && getY()+1<8)
            verif[getX()-2][getY()+1] = true;

        if (getX()+2<8 && getY()-1>=0)
            verif[getX()+2][getY()-1] = true;

        if (getX()-2>=0 && getY()-1>=0)
            verif[getX()-2][getY()-1] = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (d.getCaseAt(i,j).isOccupe() && Objects.equals(d.getCouleurPieceAt(i, j, listPiece), this.getCouleur()))
                    verif[i][j] = false;
            }
        }
        return verif;
    }
}
