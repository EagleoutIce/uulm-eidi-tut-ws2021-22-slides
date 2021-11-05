/**
 * Zusatz
 */
public class Zusatz {

    public static void main(String[] args) {
        boolean[][] field = {
            { false, false,  true, false, false, false, false, false },
            { false, false, false, false, false,  true, false, false },
            { false, false, false, false, false, false, false,  true },
            {  true, false, false, false, false, false, false, false },
            { false, false, false,  true, false, false, false, false },
            { false, false, false, false, false, false,  true, false },
            { false, false, false, false,  true,  true, false, false },
            { false,  true, false, false, false, false, false, false }
        };

        boolean validField = true;
        for (int i = 0; i < field.length; i++) {
            int rooksHorizontal = 0;
            int rooksVertical = 0;
            for (int j = 0; j < field.length; j++) { // w = h
                if(field[i][j])
                    rooksHorizontal += 1;
                if(field[j][i])
                    rooksVertical += 1;
            }
            if(rooksHorizontal > 1 || rooksVertical > 1) {
                validField = false;
                break;
            }
        }

        if(validField)
            System.out.println("Feld korrekt");
        else
            System.out.println("Feld inkorrekt");

    }
}