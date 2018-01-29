package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Roi extends Piece {
    public Roi(int x, int y, String couleur, Damier d) {
        super("R" + couleur, x, y, couleur, d);

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
    public boolean[][] checkCase() {
        boolean[][] verif = new boolean[8][8];
        String col = super.getCouleur();
        
        if(getY()>0&&d.getCaseAt(getX(), getY()-1).getOccupe()!=col) 	
        if(getY()<7&&d.getCaseAt(getX(), getY()+1).getOccupe()!=col) verif[getX()][getY() + 1] = true;
        if(getX()>0&&d.getCaseAt(getX()-1, getY()).getOccupe()!=col) verif[getX()-1][getY()] = true; 
        if(getX()<7&&d.getCaseAt(getX()+1, getY()).getOccupe()!=col) verif[getX()+1][getY()] = true;
        if(getX()>0&&getY()>0&&d.getCaseAt(getX()-1, getY()-1).getOccupe()!=col) verif[getX()-1][getY() - 1] = true; 
        if(getX()<7&&getY()>0&&d.getCaseAt(getX()+1, getY()-1).getOccupe()!=col) verif[getX()+1][getY() - 1] = true;
        if(getX()<7&&getY()<7&&d.getCaseAt(getX()+1, getY()+1).getOccupe()!=col) verif[getX()+1][getY() + 1] = true; 
        if(getX()>0&&getY()<7&&d.getCaseAt(getX()-1, getY()+1).getOccupe()!=col)  verif[getX()-1][getY() + 1] = true;
            
        //roque   

        
        return verif;
    }
}
