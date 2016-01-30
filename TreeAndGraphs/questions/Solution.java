public class Solution {
    public static void main(String[] args){
      char[][] input = {{'5','4','7','6','.','.','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'}
      ,{'4','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'}
      ,{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
      Solution s = new Solution();
      //s.isValidSudoku(input);
      System.out.println(s.isValidSudoku2(input));
    }

    public boolean isValidSudoku2(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] blocks = new int[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int mask = board[i][j]=='.'?0:(1<<(board[i][j]-'0'));
                System.out.println(Integer.toBinaryString(mask));
                if(mask==0) continue;
                if((rows[i]&mask)!=0) return false;
                if((columns[j]&mask)!=0) return false;
                if((blocks[i/3*3+j/3]&mask)!=0) return false;
                rows[i] |= mask;
                columns[j] |= mask;
                blocks[i/3*3+j/3] |= mask;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            boolean[] check = new boolean[9];
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];
                if(c=='.')
                    continue;
                int index = c-'1';
                if(check[index])
                    return false;
                check[index]=true;
            }
        }
        for(int i=0;i<board.length;i++){
            boolean[] check = new boolean[9];
            for(int j=0;j<board[0].length;j++){
                char c = board[j][i];
                if(c=='.')
                    continue;
                int index = c-'1';
                if(check[index])
                    return false;
                check[index]=true;
            }
        }

        int ro = 3;
        while(ro>0){
            ro--;
            int co = 3;
            while(co>0){
                co--;
                boolean[] check = new boolean[9];
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        int br = (ro*3);
                        int bc = (co*3);
                        System.out.print(br+" : ");
                        System.out.println(bc);
                        char c = board[br+i][bc+j];
                        if(c=='.')
                            continue;
                        int index = c-'1';
                        if(check[index])
                            return false;
                        check[index]=true;
                    }
                }

            }
        }
        return true;
    }
}
