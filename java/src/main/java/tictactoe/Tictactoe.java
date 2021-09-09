package tictactoe;

import java.util.List;

public class Tictactoe {
    public static void main(String[] args) {
        System.out.println("Hello babouche");
    }

    public String winner(List<List<String>> grid) {
        for (List<String> line : grid) {
            if (!line.get(0).isEmpty() && line.get(0).equals(line.get(1)) && line.get(0).equals(line.get(2))) {
                return line.get(0);
            }
        }
        return null;
    }
}