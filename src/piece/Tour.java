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
        boolean c1=false, c2=false, c3=false, c4=false;
        
        while(i<7) {
        	verif[i+1][getY()] = true; 
        	if(d.getCaseAt(i+1, getY()).getOccupe()!="") {
        		verif[i+1][getY()] = false; 
        		System.out.println("stop1");
        		break;
        		
        		
        	}
        	
        	i++;
        	
        }
        while(k<7) {
        	verif[getX()][k+1] = true; 
        	if(d.getCaseAt(getX(), k+1).getOccupe()!="") {
        		verif[getX()][k+1] = false;
        		System.out.println("stop2");
        		break;
        		
        	}
        	k++;
        	
        }
        while(j>0) {
        	verif[j-1][getY()] = true; 
        	if(d.getCaseAt(j-1, getY()).getOccupe()!="") {
        		verif[j-1][getY()] = false; 
        		System.out.println("stop3");
        		break;
        		
        	}
        	j--;
        	
        }
        while(m>0) {
        	verif[getX()][m-1] = true; 
        	if(d.getCaseAt(getX(), m-1).getOccupe()!="") {
        		verif[getX()][m-1] = false; 
        		System.out.println("stop4");
        		break;
        		
        	}
        	m--;
        	
        }
        for(boolean[] b : verif){
        	for(boolean bb:b)
        	System.out.println(bb);
        }
        return verif;
        
        
    }
}
