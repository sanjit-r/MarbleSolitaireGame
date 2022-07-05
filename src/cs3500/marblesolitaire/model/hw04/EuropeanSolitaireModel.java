package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * Represents a European Marble Solitaire game.
 */
public class EuropeanSolitaireModel extends AbstractMarbleSolitaireModel {

  /**
   * Constructor for the model that takes in no parameters.
   */
  public EuropeanSolitaireModel() {
    super();
  }

  /**
   * Constructor for the model that takes in the empty slot row and column.
   * @param sRow Row of the empty slot
   * @param sCol Column of the empty slot
   * @throws IllegalArgumentException When the given empty slot row and column is invalid
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);

    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Constructor for the model that takes in the size of one arm of the board.
   * @param armSize size of the arm
   * @throws IllegalArgumentException when the given arm size is negative or even
   */
  public EuropeanSolitaireModel(int armSize) throws IllegalArgumentException {
    super(armSize);

    if (armSize % 2 != 1 || armSize <= 0) {
      throw new IllegalArgumentException("The arm size must be a positive, odd number.");
    }
  }

  /**
   * Constructor that takes on all parameters.
   * @param armSize size of one arm
   * @param sRow row of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException when the arm size is even or negative and/or when the given
   *                                  location of the empty slot is invalid.
   */
  public EuropeanSolitaireModel(int armSize, int sRow, int sCol) throws IllegalArgumentException {
    super(armSize, sRow, sCol);

    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    if (armSize % 2 == 0 && armSize < 0) {
      throw new IllegalArgumentException("The arm size must be a positive, odd number.");
    }
  }

  /**
   * Builds the board.
   * @param armSize armSize of the board
   * @param sRow row that the initial empty slot comes from
   * @param sCol column that the initial empty slot comes from
   * @return an ArrayList of ArrayLists of SlotStates that represents the board.
   */
  public ArrayList<ArrayList<SlotState>> buildSlots(int armSize, int sRow, int sCol) {

    int boardSize = 3 * armSize - 2;
    ArrayList<ArrayList<SlotState>> slots = new ArrayList<ArrayList<SlotState>>();
    for (int i = 0; i < boardSize; i++) {
      slots.add(new ArrayList<SlotState>());
      for (int j = 0; j < boardSize; j++) {
        if (((i > (boardSize + (this.armSize + 2 * j)) / 2 - 1) && j < armSize - 1)
            || (i > armSize * 2 - 2 && j > (boardSize / 2) +
                (this.armSize / 2 + (boardSize - i - 1)))
            || (i < 0 || i > boardSize - 1 || j > boardSize - 1 || j < 0)
            || (i < this.armSize - 1 && j < (boardSize - (armSize + 2 * i)) / 2)
            || (i < this.armSize - 1 && j > (boardSize / 2) + ((this.armSize + 2 * i) / 2))) {
          slots.get(i).add(SlotState.Invalid);
        } else if (i == sRow && j == sCol) {
          slots.get(i).add(SlotState.Empty);
        } else {
          slots.get(i).add(SlotState.Marble);
        }
      }
    }
    return slots;
  }
}
