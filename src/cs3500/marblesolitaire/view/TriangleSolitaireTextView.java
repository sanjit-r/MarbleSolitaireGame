package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the text view for a TriangleSolitaireModel.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireTextView {

  /**
   * Constructor that takes in a MarbleSolitaireModelState.
   * @param state state of the solitaire model
   * @throws IllegalArgumentException when the given state is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {
    super(state);
  }

  /**
   * Constructor that takes in a MarbleSolitaireModelState and an Appendable.
   * @param state the state of the solitaire model
   * @param dest the destination that this view uses
   * @throws IllegalArgumentException if the state or destination is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable dest)
          throws IllegalArgumentException {
    super(state, dest);
  }

  /**
   * Returns the string representation of the model's state.
   * @return the representation of the board as a string
   */
  @Override
  public String toString() {
    String answer = "";

    MarbleSolitaireModelState.SlotState marble = MarbleSolitaireModelState.SlotState.Marble;
    MarbleSolitaireModelState.SlotState empty = MarbleSolitaireModelState.SlotState.Empty;

    int boardSize = this.state.getBoardSize();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize - i - 1; j++) {
        answer = answer + " ";
      }
      for (int j = 0; j < boardSize; j++) {
        MarbleSolitaireModelState.SlotState thisSlot = this.state.getSlotAt(i, j);
        if (thisSlot.equals(marble)) {
          answer = answer + "O ";
        }
        if (thisSlot.equals(empty)) {
          answer = answer + "_ ";
        }
      }
      answer = answer.substring(0, answer.length() - 1);
      if (i < boardSize - 1) {
        answer = answer + "\n";
      }
    }
    return answer;

  }

}
