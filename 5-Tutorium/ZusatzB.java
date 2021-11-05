public class ZusatzB {
    public static boolean isRookPositionValid(int x, int y, boolean[][] field) {
        for (int i = 0; i < field.length; i++) {
            if(i != x && field[y][i]) return false;
            if(i != y && field[i][x]) return false;
        }
        return true;
    }

    public static boolean checkField(boolean[][] field) {
        for(int y = 0; y < field.length; y++) {
            for(int x = 0; x < field.length; x++) {
                if(field[y][x] && !isRookPositionValid(x, y, field))
                    return false;
            }
        }
        return true;
    }
}
