package piece;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Roi extends Piece {
    public Roi(int x, int y, String couleur) {
        super("R" + couleur, x, y, couleur);

        try {
            if(Objects.equals(couleur, "B"))
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
    public boolean[][] checkCase(Piece p, boolean[][] verif) {
        return new boolean[0][];
    }
}
