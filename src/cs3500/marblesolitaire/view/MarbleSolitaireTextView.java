package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents a marble solitaire text view.
 */
public class MarbleSolitaireTextView extends AbstractMarbleSolitaireTextView {

  /**
   * Constructor that takes in a MarbleSolitaireModelState.
   * @param state state of the solitaire model
   * @throws IllegalArgumentException when the given state is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) throws IllegalArgumentException {
    super(state);
  }

  /**
   * Constructor that takes in a MarbleSolitaireModelState and an Appendable.
   * @param state the state of the solitaire model
   * @param dest the destination that this view uses
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable dest)
          throws IllegalArgumentException {
    super(state, dest);
  }

}
