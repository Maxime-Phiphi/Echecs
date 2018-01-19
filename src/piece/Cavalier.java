package piece;




import damier.Damier;
import sun.security.util.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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
    public boolean[][] checkCase() {
        return new boolean[0][];
    }
}
