package piece;

import damier.Case;
import damier.Damier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Fou extends Piece {
    public Fou(int x, int y, String couleur, Damier d) {
        super("F" + couleur, x, y, couleur, d);
        try {
            if (Objects.equals(couleur, "B"))
                this.setImg(ImageIO.read(new File("img/fb.png")));
            else
                this.setImg(ImageIO.read(new File("img/fn.png")));
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

        Map<String, Case> memeDiago1 = new HashMap<>();

        for (int i = 0; i < d.getListCase().size(); i++) {
            Case c = d.getListCase().get(i);
            if (this.getY() != c.getY() && this.getX() != c.getX()) {
                float b = (float) (this.getY() - c.getY()) / (this.getX() - c.getX());
                if (Math.abs(b) == 1f) {
                    memeDiago1.put(""+c.getX()+c.getY(), c);
                }
            }
        }

        TreeMap<String,Case> memeColByKeys = new TreeMap<>(memeDiago1);
        boolean isBreak = false;
        for (int i = this.getX(); i > 0; i--) {
            for (int j = this.getY(); j > 0; j--) {
                if (memeColByKeys.get(""+i+j) != null)
                {
                    Case c = memeColByKeys.get(""+i+j);
                    if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
                    {
                        if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece))) {
                            verif[c.getX()][c.getY()] = true;
                        }
                        System.out.println("break");
                        isBreak = true;
                        break;
                    }
                    else
                    {
                        verif[c.getX()][c.getY()] = true;
                    }
                }
                if(isBreak)
                    break;
            }
        }

        isBreak = false;
        for (int i = this.getX(); i > 0; i--) {
            for (int j = this.getY(); j < 8; j++) {
                if (memeColByKeys.get(""+i+j) != null)
                {
                    Case c = memeColByKeys.get(""+i+j);
                    if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
                    {
                        if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece))) {
                            verif[c.getX()][c.getY()] = true;
                        }
                        System.out.println("break");
                        isBreak = true;
                        break;
                    }
                    else
                    {
                        verif[c.getX()][c.getY()] = true;
                    }
                }
                if(isBreak)
                    break;
            }
        }

        isBreak = false;
        for (int i = this.getX(); i < 8; i++) {
            for (int j = this.getY(); j < 8; j++) {
                if (memeColByKeys.get(""+i+j) != null)
                {
                    Case c = memeColByKeys.get(""+i+j);
                    if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
                    {
                        if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece))) {
                            verif[c.getX()][c.getY()] = true;
                        }
                        System.out.println("break");
                        isBreak = true;
                        break;
                    }
                    else
                    {
                        verif[c.getX()][c.getY()] = true;
                    }
                }
                if(isBreak)
                    break;
            }
        }

        isBreak = false;
        for (int i = this.getX(); i < 8; i++) {
            for (int j = this.getY(); j > 0; j--) {
                if (memeColByKeys.get(""+i+j) != null)
                {
                    Case c = memeColByKeys.get(""+i+j);
                    if (d.getCaseAt(c.getX(),c.getY()).isOccupe())
                    {
                        if (!Objects.equals(this.getCouleur(), d.getCouleurPieceAt(c.getX(), c.getY(), listPiece))) {
                            verif[c.getX()][c.getY()] = true;
                        }
                        System.out.println("break");
                        isBreak = true;
                        break;
                    }
                    else
                    {
                        verif[c.getX()][c.getY()] = true;
                    }
                }
                if(isBreak)
                    break;
            }
        }

        return verif;
    }


//        if (Objects.equals(p.getCouleur(), "B")) {
//            int x = p.getX();
//            int y = p.getY();
//            int g = 0;
//            //Diagonale à gauche
//            while (x > 0 && g == 0){
//                if (p.tabPiece[x-1][y+1] == null) {
//                    x--;
//                    y++;
//                }
//                else {
//                    x--;
//                    y++;
//                    g = 1;
//                }
//            }
//            verif[x][y] = true;
//            //Diagonale à droite
//            while (x<7 && g==0){
//                if (p.tabPiece[x+1][y+1] == null) {
//                    x++;
//                    y++;
//                }
//                else {
//                    x++;
//                    y++;
//                    g = 1;
//                }
//            }
//            verif [x][y] = true;
//        }

}
