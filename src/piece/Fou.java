package piece;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Fou extends Piece {
    public Fou(int x, int y, String couleur) {
        super("F" + couleur, x, y, couleur);
        try {
            if(Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/fb.png")));
            else
                this.setImg(ImageIO.read(new File("img/fn.png")));
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
        if (Objects.equals(p.getCouleur(), "B")) {
            int x = p.getX();
            int y = p.getY();
            int g = 0;
            //Diagonale à gauche
            while (x > 0 && g == 0){
                if (p.tabPiece[x-1][y+1] == null) {
                    x--;
                    y++;
                }
                else {
                    x--;
                    y++;
                    g = 1;
                }
            }
            verif[x][y] = true;
            //Diagonale à droite
            while (x<7 && g==0){
                if (p.tabPiece[x+1][y+1] == null) {
                    x++;
                    y++;
                }
                else {
                    x++;
                    y++;
                    g = 1;
                }
            }
            verif [x][y] = true;
        }
        return verif;
    }
}
