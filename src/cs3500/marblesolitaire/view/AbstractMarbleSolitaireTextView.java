package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class for a MarbleSolitaireTextView.
 */
abstract class AbstractMarbleSolitaireTextView implements MarbleSolitaireView {
  final MarbleSolitaireModelState state;
  private Appendable dest;

  /**
   * Constructor that takes in a MarbleSolitaireModelState.
   * @param state state of the solitaire model
   * @throws IllegalArgumentException when the given state is null
   */
  public AbstractMarbleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {
    if (state == null) {
      throw new IllegalArgumentException("The state cannot be null");
    }
    this.state = state;
    this.dest = System.out;
  }

  /**
   * Constructor that takes in a MarbleSolitaireModelState and an Appendable.
   * @param state the state of the solitaire model
   * @param dest the destination that this view uses
   * @throws IllegalArgumentException if the state or destination is null
   */
  public AbstractMarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable dest)
          throws IllegalArgumentException {
    if (state == null || dest == null) {
      throw new IllegalArgumentException("The state or destination cannot be null");
    }

    this.state = state;
    this.dest = dest;
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
    MarbleSolitaireModelState.SlotState invalid = MarbleSolitaireModelState.SlotState.Invalid;

    for (int i = 0; i < this.state.getBoardSize(); i++) {
      for (int j = 0; j < this.state.getBoardSize(); j++) {
        boolean isAtEnd = (i == this.state.getBoardSize() - 1);
        MarbleSolitaireModelState.SlotState thisSlot = this.state.getSlotAt(i, j);
        try {
          MarbleSolitaireModelState.SlotState nextSlot = this.state.getSlotAt(i, j + 1);
          if (thisSlot == marble && nextSlot == invalid && isAtEnd) {
            answer = answer + "O";
            break;
          } else if (thisSlot == marble && nextSlot == invalid) {
            answer = answer + "O\n";
            break;
          } else if (thisSlot == marble) {
            answer = answer + "O ";
          } else if (thisSlot == empty && nextSlot == invalid && isAtEnd) {
            answer = answer + "_";
            break;
          } else if (thisSlot == empty && nextSlot == invalid) {
            answer = answer + "_\n";
            break;
          } else if (thisSlot == empty) {
            answer = answer + "_ ";
          } else {
            answer = answer + "  ";
          }
        } catch (IllegalArgumentException e) {
          if (thisSlot == marble && isAtEnd) {
            answer = answer + "O";
            break;
          } else if (thisSlot == marble) {
            answer = answer + "O\n";
            break;
          } else if (thisSlot == empty && isAtEnd) {
            answer = answer + "_";
            break;
          } else if (thisSlot == empty) {
            answer = answer + "_\n";
            break;
          } else {
            answer = answer + "  ";
          }
          break;
        }
      }
    }

    return answer;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above.
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    dest.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    dest.append(message);
  }
}
