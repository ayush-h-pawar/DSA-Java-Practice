import java.util.*;

public class SudokuSolverOptimized {

    static Set<Character>[] rows = new HashSet[9];
    static Set<Character>[] cols = new HashSet[9];
    static Set<Character>[] boxes = new HashSet[9];

    static void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Initialize sets
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.') {
                    char val = board[r][c];
                    rows[r].add(val);
                    cols[c].add(val);
                    boxes[(r / 3) * 3 + (c / 3)].add(val);
                }
            }
        }

        backtrack(board);
    }

    static boolean backtrack(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        int box = (r / 3) * 3 + (c / 3);

                        if (!rows[r].contains(num) &&
                            !cols[c].contains(num) &&
                            !boxes[box].contains(num)) {

                            board[r][c] = num;
                            rows[r].add(num);
                            cols[c].add(num);
                            boxes[box].add(num);

                            if (backtrack(board))
                                return true;

                            board[r][c] = '.';
                            rows[r].remove(num);
                            cols[c].remove(num);
                            boxes[box].remove(num);
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
                    }
