package tictactoe;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TictactoeTest {
   private static final List<String> EMPTY_LINE = List.of("", "", "");
   Tictactoe sut = new Tictactoe();

   @Test
   public void thereIsNoWinnerWhenWeStartTheGame() {
      Assertions.assertThat(sut.winner(List.of(EMPTY_LINE, EMPTY_LINE, EMPTY_LINE))).isNull();
   }

   @Test
   public void winnerFirstLine() {
      Assertions.assertThat(sut.winner(List.of(List.of("X", "X", "X"), EMPTY_LINE, EMPTY_LINE))).isEqualTo("X");
   }

   @Test
   public void winnerSecondLine() {
      Assertions.assertThat(sut.winner(List.of(EMPTY_LINE, List.of("O", "O", "O"), EMPTY_LINE))).isEqualTo("O");
   }

   @Test
   public void winnerThirdLine() {
      Assertions.assertThat(sut.winner(List.of(EMPTY_LINE, EMPTY_LINE, List.of("X", "X", "X")))).isEqualTo("X");
   }
}