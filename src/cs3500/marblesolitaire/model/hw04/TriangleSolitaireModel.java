package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

/**
 * Represents a Triangular marble solitaire game.
 */
public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {

  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * Constructor for the model that takes in the empty slot row and column.
   * @param sRow Row of the empty slot
   * @param sCol Column of the empty slot
   * @throws IllegalArgumentException When the given empty slot row and column is invalid
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(5, sRow, sCol);

    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid || sCol > sRow) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Constructor for the model that takes in the size of one arm of the board.
   * @param armSize size of the arm
   * @throws IllegalArgumentException when the given arm size is negative or even
   */
  public TriangleSolitaireModel(int armSize) throws IllegalArgumentException {
    super(armSize, 0, 0);

    if (armSize < 1) {
      throw new IllegalArgumentException("The dimension must be positive.");
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
  public TriangleSolitaireModel(int armSize, int sRow, int sCol) throws IllegalArgumentException {
    super(armSize, sRow, sCol);

    if (armSize < 1) {
      throw new IllegalArgumentException("The dimension must be positive.");
    }
    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid || sCol > sRow) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
  }

  /**
   * Moves the specified marble to the specified slot.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException If the from slot is invalid
   *                                  if the to slot is invalid
   *                                  if the from position does not have a marble
   *                                  if the to position is not empty
   *                                  if the user is trying to move the marble anywhere besides
   *                                    2 slots horizontally, vertically or diagonally
   *                                  if there is no marble between the from and to slots
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.getSlotAt(fromRow, fromCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("From position is invalid.");
    } else if (this.getSlotAt(toRow, toCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("To position is invalid.");
    } else if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) {
      throw new IllegalArgumentException("From position does not have a marble.");
    } else if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      throw new IllegalArgumentException("To position is not empty.");
    } else if (((toRow != (fromRow + 2)) || (toCol != (fromCol + 2)))
            && ((toRow != (fromRow - 2)) || (toCol != (fromCol - 2)))
            && ((toCol != fromCol) || ((toRow != (fromRow + 2)) && (toRow != (fromRow - 2))))
            && ((toRow != fromRow) || ((toCol != (fromCol + 2)) && (toCol != (fromCol - 2))))) {
      throw new IllegalArgumentException("Marble can only move two spaces up, down, or diagonal");
    } else if (this.getSlotAt((fromRow + toRow) / 2,
            (fromCol + toCol) / 2) != SlotState.Marble) {
      throw new IllegalArgumentException("There is no marble in between the from and to positions");
    } else {
      this.slots.get(fromRow).set(fromCol, SlotState.Empty);
      this.slots.get((fromRow + toRow) / 2).set((fromCol + toCol) / 2, SlotState.Empty);
      this.slots.get(toRow).set(toCol, SlotState.Marble);
    }
  }

  /**
   * Determines whether the game is over.
   * @return true if there are no valid moves remaining and false otherwise
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.slots.size(); i++) {
      for (int j = 0; j < this.slots.get(i).size(); j++) {
        boolean isMoveDownValid = this.isMoveValid(i, j, i + 2, j);
        boolean isMoveUpValid = this.isMoveValid(i, j, i - 2, j);
        boolean isMoveLeftValid = this.isMoveValid(i, j, i, j - 2);
        boolean isMoveRightValid = this.isMoveValid(i, j, i, j + 2);
        boolean isMoveDiagonalUpValid = this.isMoveValid(i, j, i - 2, j - 2);
        boolean isMoveDiagonalDownValid = this.isMoveValid(i, j, i + 2, j + 2);

        if (isMoveDownValid || isMoveUpValid || isMoveLeftValid || isMoveRightValid
                || isMoveDiagonalUpValid || isMoveDiagonalDownValid) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Determines if a given move is valid.
   * @param fromRow the row of the from marble
   * @param fromCol the column of the from marble
   * @param toRow the row of the to marble
   * @param toCol the column of the to marble
   * @return true if the move is valid and false otherwise
   */
  @Override
  public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
    try {
      SlotState from = this.getSlotAt(fromRow, fromCol);
      SlotState to = this.getSlotAt(toRow, toCol);
    } catch (IllegalArgumentException e) {
      return false;
    }

    return this.getSlotAt(fromRow, fromCol) != SlotState.Invalid
            && this.getSlotAt(toRow, toCol) != SlotState.Invalid
            && this.getSlotAt(fromRow, fromCol) == SlotState.Marble
            && this.getSlotAt(toRow, toCol) == SlotState.Empty
            && ((toRow == fromRow + 2 && toCol == fromCol + 2)
            || (toRow == fromRow - 2 && toCol == fromCol - 2)
            || (toCol == fromCol && (toRow == fromRow + 2 || toRow == fromRow - 2))
            || (toRow == fromRow && (toCol == fromCol + 2 || toCol == fromCol - 2)))
            && this.getSlotAt((fromRow + toRow) / 2, (fromCol + toCol) / 2)
            == SlotState.Marble;
  }

  /**
   * Returns the size of the board.
   * @return the longest dimension of the board
   */
  @Override
  public int getBoardSize() {
    return this.armSize;
  }

  /**
   * Builds the board.
   * @param armSize armSize of the board
   * @param sRow row that the initial empty slot comes from
   * @param sCol column that the initial empty slot comes from
   * @return an ArrayList of ArrayLists of SlotStates that represents the board.
   */
  public ArrayList<ArrayList<SlotState>> buildSlots(int armSize, int sRow, int sCol) {
    ArrayList<ArrayList<SlotState>> slots = new ArrayList<ArrayList<SlotState>>();
    for (int i = 0; i < armSize; i++) {
      slots.add(new ArrayList<SlotState>());
      for (int j = 0; j < armSize; j++) {
        if (i == sRow && j == sCol) {
          slots.get(i).add(SlotState.Empty);
        } else if (j < i + 1) {
          slots.get(i).add(SlotState.Marble);
        } else {
          slots.get(i).add(SlotState.Invalid);
        }
      }
    }

    return slots;
  }
}
