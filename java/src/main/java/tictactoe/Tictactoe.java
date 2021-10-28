package tictactoe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tictactoe {

    public String winner(List<List<String>> grid) {
        for (List<String> line : grid) {
            if (hasAWinner(line)) {
                return line.get(0);
            }
        }
        for (int index = 0; index < 3; index++) {
            List<String> columnValues = getColumnValues(grid, index);
            if (hasAWinner(columnValues)) {
                return columnValues.get(0);
            }
        }
        return null;
    }

    private List<String> getColumnValues(List<List<String>> grid, Integer columnIndex) {
        List<String> columnValues = new ArrayList<>();
        for (List<String> line : grid) {
            columnValues.add(line.get(columnIndex));

        }
        return columnValues;
    }

    private Boolean hasAWinner(List<String> columnValues) {
        return !columnValues.get(0).isEmpty() && columnValues.get(0).equals(columnValues.get(1)) && columnValues.get(0).equals(columnValues.get(2));
    }

    public String whosTurn(List<List<String>> grid) {
        long count = grid.stream().flatMap(Collection::stream).filter(value -> !value.isEmpty()).count();
        return count % 2 == 0 ? "X" : "O";
    }

    public boolean isMoveValid(int line, int column, List<List<String>> board) {
        return board.get(line - 1).get(column - 1).isEmpty();
    }

    public List<List<String>> move(String x, int line, int column, List<List<String>> board) {
        if (!isMoveValid(line, column, board)) {
            throw new RuntimeException("box already taken");
        }
        board.get(line - 1).set(column - 1, x);
        return board;
    }
}