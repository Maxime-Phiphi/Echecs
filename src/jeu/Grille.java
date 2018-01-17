package jeu;

public class Grille {


    private static final int taille = 8;
    private String[][] tabGrille = new String[taille][taille];

    public Grille (){
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                this.tabGrille[i][j] = "";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   A   B   C   D   E   F   G  H\n");
        for (int i = 0; i < taille; i++) {
            stringBuilder.append(i + 1).append(" ");
            for (int j = 0; j < taille; j++) {
                if (j != taille - 1)
                    stringBuilder.append(tabGrille[j][i]).append("  ");
                else
                    stringBuilder.append(tabGrille[j][i]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static int getTaille() {
        return taille;
    }

    public String[][] getTabGrille() {
        return tabGrille;
    }
}
