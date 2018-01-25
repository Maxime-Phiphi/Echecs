package damier;

import java.awt.*;

public class CaseNoire extends Case {


    public CaseNoire( int x, int y) {
        super(Color.gray, x, y);
    }

    @Override
    public void resetCouleur() {
        this.couleur = Color.gray;
    }
}
