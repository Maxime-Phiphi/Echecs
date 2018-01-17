package piece;




import sun.security.util.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Cavalier extends Piece {
    public Cavalier(int x, int y, String couleur) {
        super("C" + couleur, x, y, couleur);
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
    public boolean[][] checkCase(Piece p, boolean[][] verif) {
        return new boolean[0][];
    }
}
