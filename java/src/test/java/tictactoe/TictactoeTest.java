package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TictactoeTest {
    private static final List<String> EMPTY_LINE = List.of("", "", "");
    Tictactoe sut = new Tictactoe();

    @Test
    public void thereIsNoWinnerWhenWeStartTheGame() {
        assertThat(sut.winner(List.of(EMPTY_LINE, EMPTY_LINE, EMPTY_LINE))).isNull();
    }

    @Test
    public void winnerFirstLine() {
        assertThat(sut.winner(List.of(List.of("X", "X", "X"), EMPTY_LINE, EMPTY_LINE))).isEqualTo("X");
    }

    @Test
    public void winnerSecondLine() {
        assertThat(sut.winner(List.of(EMPTY_LINE, List.of("O", "O", "O"), EMPTY_LINE))).isEqualTo("O");
    }

    @Test
    public void winnerThirdLine() {
        assertThat(sut.winner(List.of(EMPTY_LINE, EMPTY_LINE, List.of("X", "X", "X")))).isEqualTo("X");
    }

    @Test
    public void winnerFirstColumn() {
        assertThat(sut.winner(List.of(List.of("O", "", ""), List.of("O", "", ""), List.of("O", "", "")))).isEqualTo("O");
    }

    @Test
    public void winnerSecondColumn() {
        assertThat(sut.winner(List.of(List.of("", "O", ""), List.of("", "O", ""), List.of("", "O", "")))).isEqualTo("O");
    }

    @Test
    public void winnerThirdColumn() {
        assertThat(sut.winner(List.of(List.of("", "", "O"), List.of("", "", "O"), List.of("", "", "O")))).isEqualTo("O");
    }

    @Test
    public void whosTurnWhenStarting() {
        assertThat(sut.whosTurn(List.of(EMPTY_LINE, EMPTY_LINE, EMPTY_LINE))).isEqualTo("X");
    }

    @Test
    public void whosTurnOnSecondTurn() {
        assertThat(sut.whosTurn(List.of(List.of("X", "", ""), EMPTY_LINE, EMPTY_LINE))).isEqualTo("O");
    }

    @Test
    public void validMove() {
        assertThat(sut.isMoveValid(1, 1, List.of(EMPTY_LINE, EMPTY_LINE, EMPTY_LINE))).isTrue();
    }

    @Test
    public void nonValidMove() {
        assertThat(sut.isMoveValid(1, 1, List.of(List.of("X", "", ""), EMPTY_LINE, EMPTY_LINE))).isFalse();
    }

    @Test
    public void move() {
        assertThat(sut.move("X", 1, 1, List.of(new ArrayList<>(EMPTY_LINE), EMPTY_LINE, EMPTY_LINE))).isEqualTo(List.of(List.of("X", "", ""), EMPTY_LINE, EMPTY_LINE));
    }
}