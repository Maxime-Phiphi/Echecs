package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Reine extends Piece {
    public Reine(int x, int y, String couleur, Damier d) {
        super("r" + couleur, x, y , couleur, d);

        try {
            if(Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/reb.png")));
            else
                this.setImg(ImageIO.read(new File("img/ren.png")));
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
        return new boolean[0][];
    }
}
