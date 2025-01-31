import java.util.List;
import java.util.ArrayList;

public class NQueen {


    static boolean isSafe(int row, int col,char [][] chess){
       // checking horizontally 
        // i = row, j = column
        for(int j = 0; j<chess.length; j++){
            if(chess [row] [j] == 'Q'){
                return false;
            }
        }

        // checking vertically
        for(int i = 0; i<chess.length;i++){
            if(chess[i] [col] == 'Q'){
                return false;
            }
        }

        // checking upward left(diagonally)
        int i = row;
        for(int j = col; i>= 0&& j>=0; i--, j--){
            if(chess[i] [j] == 'Q'){
                return false;
            }
        }

        // checking downward right(diagonally)
        i = row;
        for(int j = col; i<chess.length && j<chess.length; i++, j++){
            if(chess[i] [j] == 'Q'){
                return false;
            }
        }

        // checking upward right(diagonally)
        i = row;
        for(int j = col; i>= 0&& j<chess.length; i--, j++){
            if(chess[i] [j] == 'Q'){
                return false;
            }
        }

        // checking downward left(diagonally)
        i = row;
        for(int j = col; i<chess.length&& j>=0; i++, j--){
            if(chess[i] [j] == 'Q'){
                return false;
            }
        }
        
    return true;
    }

    public static void saveBoard(char chess[][],List<List<String>>allboard){
        // 1 list string
        //travel each row of chess
        //add each value to list of string that you have craeted 1
        //add list (1) to allboard
    }

    public static void helper(char chess[][],int column,List<List<String>> allboard){
        if (column==chess.length) {
            //save board on allboard list
            //saveBoard(chess,allboard);
            return;
        }
        //i=row
        for (int i = 0; i < chess.length; i++) {
            if (isSafe(i,column,chess)) {
                chess[i][column]='Q';
                helper(chess, column+1, allboard);
                chess [i][column]='.';
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> allboard= new ArrayList<>();
        helper(new char[4][4],0,allboard);
    }
}
