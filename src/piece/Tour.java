package piece;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Tour extends Piece {

    public Tour(int x, int y, String couleur) {
        super("T" + couleur, x, y, couleur);

        try {
            if(Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/tb.png")));
            else
                this.setImg(ImageIO.read(new File("img/tn.png")));
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
        return new boolean[0][];
    }
}
