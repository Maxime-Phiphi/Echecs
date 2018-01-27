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
    	boolean[][] verif = new boolean[8][8];
    	String col = super.getCouleur();

    	//mvts 2 ensuite 1
    	if(getX()>2) {
    		if(getY()<7&&d.getCaseAt(getX()-2, getY()+1).getOccupe()!=col) {
    			verif[getX()-2][getY()+1] = true; 
    		}
    		if(getY()>0&&d.getCaseAt(getX()-2, getY()-1).getOccupe()!=col) {
    			verif[getX()-2][getY() - 1] = true; 
    		}
    	}
    	if(getX()<6) {
    		if(getY()<7&&d.getCaseAt(getX()+2, getY()+1).getOccupe()!=col) {
    			verif[getX()+2][getY() + 1] = true; 
    		}
    		if(getY()>0&&d.getCaseAt(getX()+2, getY()-1).getOccupe()!=col) {
    			verif[getX()+2][getY() - 1] = true; 
    		}
    	}
    	
    	if(getY()>2) {
    		if(getX()<7&&d.getCaseAt(getX()+1, getY()-2).getOccupe()!=col) {
    			verif[getX()+1][getY() - 2] = true; 
    		}
    		if(getX()>0&&d.getCaseAt(getX()-1, getY()-2).getOccupe()!=col) {
    			verif[getX()-1][getY() - 2] = true; 
    		}
    	}
    	if(getY()<6) {
    		if(getX()<7&&d.getCaseAt(getX()+1, getY()+2).getOccupe()!=col) {
    			verif[getX()+1][getY() + 2] = true; 
    		}
    		if(getX()>0&&d.getCaseAt(getX()-1, getY()+2).getOccupe()!=col) {
    			verif[getX()-1][getY() + 2] = true; 
    		}
    	}
    	
    	
    	
    	//mvts 1 ensuite 2 
    	
    	if(getX()>0&&innerBounds(getY())) {
    		if(d.getCaseAt(getX()-1, getY()+2).getOccupe()!=col) {
    			
    			verif[getX()-1][getY() + 2] = true; 
    		}
    		if(d.getCaseAt(getX()-1, getY()-2).getOccupe()!=col) {
    			verif[getX()-1][getY() - 2] = true; 
    		}
    	}
    	if(getX()<7&&innerBounds(getY())) {
    		if(d.getCaseAt(getX()+1, getY()+2).getOccupe()!=col) {
    			verif[getX()+1][getY() + 2] = true; 
    		}
    		if(d.getCaseAt(getX()+1, getY()-2).getOccupe()!=col) {
    			verif[getX()+1][getY() - 2] = true; 
    		}
    	}
    	
    	if(getY()>0&&innerBounds(getX())) {
    		if(d.getCaseAt(getX()+2, getY()-1).getOccupe()!=col) {
    			verif[getX()+2][getY() - 1] = true; 
    		}
    		if(d.getCaseAt(getX()-2, getY()-1).getOccupe()!=col) {
    			verif[getX()-2][getY() - 1] = true; 
    		}
    	}
    	if(getY()<7&&innerBounds(getX())) {
    		if(d.getCaseAt(getX()+2, getY()+1).getOccupe()!=col) {
    			verif[getX()+2][getY() +1] = true; 
    		}
    		if(d.getCaseAt(getX()-2, getY()+1).getOccupe()!=col) {
    			verif[getX()-2][getY() +1] = true; 
    		}
    	}
    	return verif;
    }
}
