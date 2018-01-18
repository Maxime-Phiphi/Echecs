package damier;

import java.awt.*;
import java.util.Objects;

public abstract class Case {
    private static final int COTECASE = 75;
    private String couleur;
    private boolean occupe;
    private int x, y;

    public Case(String couleur, int x , int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g ) {
        if (Objects.equals(couleur, "B")) {
            g.setColor(Color.white);
        }
        else {
            g.setColor(Color.gray);
        }
        g.fillRect(50+(x)*COTECASE, 50+(y)*COTECASE, COTECASE, COTECASE);
    }

    public boolean isOccupe() {
        return occupe;
    }
}
