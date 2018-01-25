package piece;

import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Tour extends Piece {

    public Tour(int x, int y, String couleur, Damier d) {
        super("T" + couleur, x, y, couleur, d);

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
    public boolean[][] checkCase() {
    	boolean[][] verif = new boolean[8][8];
        String col = super.getCouleur();
        int i = getX();
        int j = getX();
        int k = getY();
        int m = getY();
       
        
        while(i<8) {
        	verif[i][getY()] = true; 
        	if(d.getCaseAt(i, getY()).getOccupe()!="") {
        		verif[i][getY()] = false; 
        		
        		
        		
        	}
        	
        	i++;
        	
        }
        while(k<8) {
        	verif[getX()][k] = true; 
        	if(d.getCaseAt(getX(), k).getOccupe()!="") {
        		verif[getX()][k] = false; 
        		
        		
        	}
        	k++;
        	
        }
        while(j>=0) {
        	verif[j][getY()] = true; 
        	if(d.getCaseAt(j, getY()).getOccupe()!="") {
        		verif[j][getY()] = false; 
        		
        		
        	}
        	j--;
        	
        }
        while(m>=0) {
        	verif[getX()][m] = true; 
        	if(d.getCaseAt(getX(), m).getOccupe()!="") {
        		verif[getX()][m] = false; 
        		
        		
        	}
        	m--;
        	
        }
        return verif;
        
        
    }
}
