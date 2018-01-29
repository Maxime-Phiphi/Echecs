package piece;

import damier.Case;
import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public boolean[][] checkCase(List<Piece> listPiece) {
        boolean[][] verif = new boolean[8][8];

        Map<Integer, Case> memeCol = new HashMap<>();
        Map<Integer, Case> memeLigne = new HashMap<>();

        for (Case c : d.getListCase()) {
            if ((c.getX() == this.getX()))
                memeCol.put(c.getY(),c);
            if (c.getY() == this.getY())
                memeLigne.put(c.getX(),c);
        }

        TreeMap<Integer,Case> memeColByKeys = new TreeMap<>(memeCol);
        memeColByKeys.remove(this.getY());
        for (int i = this.getY(); i < memeColByKeys.size(); i++) {
            Case c = memeColByKeys.get(i+1);
            if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
            {
                if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece)))
                    verif[c.getX()][c.getY()] = true;
                break;
            }
            else
            {
                verif[c.getX()][c.getY()] = true;
            }
        }
        for (int i = this.getY(); i > 0; i--) {
            Case c = memeColByKeys.get(i-1);
            if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
            {
                if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece)))
                    verif[c.getX()][c.getY()] = true;
                break;
            }
            else
            {
                verif[c.getX()][c.getY()] = true;
            }
        }

        TreeMap<Integer,Case> memeLigneByKeys = new TreeMap<>(memeLigne);
        memeLigneByKeys.remove(this.getX());
        for (int i = this.getX(); i < memeLigneByKeys.size(); i++) {
            Case c = memeLigneByKeys.get(i+1);
            if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
            {
                if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece)))
                    verif[c.getX()][c.getY()] = true;
                break;
            }
            else
            {
                verif[c.getX()][c.getY()] = true;
            }
        }

        for (int i = this.getX(); i > 0; i--) {
            Case c = memeLigneByKeys.get(i-1);
            if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
            {
                if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece)))
                    verif[c.getX()][c.getY()] = true;
                break;
            }
            else
            {
                verif[c.getX()][c.getY()] = true;
            }
        }

        return verif;
    }
}
