package damier;

import java.awt.*;

public class CaseBlanche extends Case {


    public CaseBlanche(int x, int y) {
        super(Color.white, x, y);
    }

    @Override
    public void resetCouleur() {
        this.couleur = Color.white;
    }
}
