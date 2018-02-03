package piece;

import damier.Damier;
import jeu.Jeu;

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
        
        if(getY()>0&&d.getCaseAt(getX(), getY()-1).getOccupe()!=col) verif[getX()][getY() - 1] = true;	
        if(getY()<7&&d.getCaseAt(getX(), getY()+1).getOccupe()!=col) verif[getX()][getY() + 1] = true;
        if(getX()>0&&d.getCaseAt(getX()-1, getY()).getOccupe()!=col) verif[getX()-1][getY()] = true; 
        if(getX()<7&&d.getCaseAt(getX()+1, getY()).getOccupe()!=col) verif[getX()+1][getY()] = true;
        if(getX()>0&&getY()>0&&d.getCaseAt(getX()-1, getY()-1).getOccupe()!=col) verif[getX()-1][getY() - 1] = true; 
        if(getX()<7&&getY()>0&&d.getCaseAt(getX()+1, getY()-1).getOccupe()!=col) verif[getX()+1][getY() - 1] = true;
        if(getX()<7&&getY()<7&&d.getCaseAt(getX()+1, getY()+1).getOccupe()!=col) verif[getX()+1][getY() + 1] = true; 
        if(getX()>0&&getY()<7&&d.getCaseAt(getX()-1, getY()+1).getOccupe()!=col)  verif[getX()-1][getY() + 1] = true;
            
        roque(verif, col); 

        
        return verif;
    }
    
    public void roque(boolean[][] tab, String col){
    		
    		
    		if(col=="B"&&!Jeu.getMoveRB()) {
    			if(!Jeu.getRoqueB()&&getY()==7&&getX()==4) {
    				if(d.getCaseAt(getX()-1, getY()).getOccupe()==""&&d.getCaseAt(getX()-2, getY()).getOccupe()==""&&d.getCaseAt(getX()-3, getY()).getOccupe()=="") {
    					tab[getX()-2][getY()] = true;
    				}
    				if(d.getCaseAt(getX()+1, getY()).getOccupe()==""&&d.getCaseAt(getX()+2, getY()).getOccupe()=="") {
    					tab[getX()+2][getY()] = true;
    				}
    			}
    		}
    		else if(col=="N"&&!Jeu.getMoveRN()){
    			
    			if(!Jeu.getRoqueN()&&getY()==0&&getX()==4) {
    				if(d.getCaseAt(getX()-1, getY()).getOccupe()==""&&d.getCaseAt(getX()-2, getY()).getOccupe()==""&&d.getCaseAt(getX()-3, getY()).getOccupe()=="") {
    					tab[getX()-2][getY()] = true;
    				}
    				if(d.getCaseAt(getX()+1, getY()).getOccupe()==""&&d.getCaseAt(getX()+2, getY()).getOccupe()=="") {
    					tab[getX()+2][getY()] = true;
    				}
    			}
    		}
    		
    }
}
