package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Fou extends Piece {
    public Fou(int x, int y, String couleur, Damier d) {
        super("F" + couleur, x, y, couleur, d);
        try {
            if (Objects.equals(couleur, "B"))
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
    public boolean[][] checkCase() {
    	
    		return checkDiag();


    }
}
