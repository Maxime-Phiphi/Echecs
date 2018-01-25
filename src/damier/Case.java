package damier;

import java.awt.*;
import java.util.Objects;

public abstract class Case {
    private static final int COTECASE = 75;
    protected Color couleur;
    private String occupe;
    private int x, y;

    public Case(Color couleur, int x , int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
        this.occupe = "";
    }

    public void paintComponent(Graphics g ) {
        g.setColor(couleur);
        g.fillRect(50+(x)*COTECASE, 50+(y)*COTECASE, COTECASE, COTECASE);
    }

    public boolean isOccupe() {
        if(this.occupe=="") return false; 
        return true; 
    }
    
    public String getOccupe() {
    	return occupe;
    }

    public void setOccupe(String occupe) {
        this.occupe = occupe;
    }

    public void changeCouleur () {
        if (this.couleur != Color.green) {
            this.couleur = Color.green;
        }
        else {
        this.resetCouleur();
        }
    }
    public abstract void resetCouleur ();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
