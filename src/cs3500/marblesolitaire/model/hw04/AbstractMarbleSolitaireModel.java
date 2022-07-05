package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Class representing an abstract solitaire model.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  final int armSize;
  private final int sRow;
  private final int sCol;
  final ArrayList<ArrayList<SlotState>> slots;

  /**
   * Constructor that takes in no parameters.
   */
  public AbstractMarbleSolitaireModel() {
    this.armSize = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.slots = this.buildSlots(this.armSize, this.sRow, this.sCol);
  }

  /**
   * Constructor for the model that takes in the empty slot row and column.
   * @param sRow Row of the empty slot
   * @param sCol Column of the empty slot
   * @throws IllegalArgumentException When the given empty slot row and column is invalid
   */
  public AbstractMarbleSolitaireModel(int sRow, int sCol) {
    this.armSize = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.slots = this.buildSlots(this.armSize, this.sRow, this.sCol);
  }

  /**
   * Constructor for the model that takes in the size of one arm of the board.
   * @param armSize size of the arm
   * @throws IllegalArgumentException when the given arm size is negative or even
   */
  public AbstractMarbleSolitaireModel(int armSize) {
    this.armSize = armSize;
    this.sRow = (3 * armSize - 2) / 2;
    this.sCol = (3 * armSize - 2) / 2;
    this.slots = this.buildSlots(this.armSize, this.sRow, this.sCol);
  }

  /**
   * Constructor that takes on all parameters.
   * @param armSize size of one arm
   * @param sRow row of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException when the arm size is even or negative and/or when the given
   *                                  location of the empty slot is invalid.
   */
  public AbstractMarbleSolitaireModel(int armSize, int sRow, int sCol) {
    this.armSize = armSize;
    this.sRow = sRow;
    this.sCol = sCol;
    this.slots = this.buildSlots(this.armSize, this.sRow, this.sCol);
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
   *                                    2 slots horizontally or vertically
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
    } else if ((((fromRow != toRow + 2 && fromRow != toRow - 2) || fromCol != toCol)
            && ((fromCol != toCol + 2 && fromCol != toCol - 2) || fromRow != toRow))) {
      throw new IllegalArgumentException("Marble can only move two slots directly " +
              "horizontal or vertical");
    } else if (this.getSlotAt((fromRow + toRow) / 2, (fromCol + toCol) / 2) != SlotState.Marble) {
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

        if (isMoveDownValid || isMoveUpValid || isMoveLeftValid || isMoveRightValid) {
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
            && (((fromRow == toRow + 2 || fromRow == toRow - 2) && fromCol == toCol)
            || ((fromCol == toCol + 2 || fromCol == toCol - 2) && fromRow == toRow))
            && this.getSlotAt((fromRow + toRow) / 2, (fromCol + toCol) / 2) == SlotState.Marble;
  }

  /**
   * Returns the size of the board.
   * @return the longest dimension of the board
   */
  @Override
  public int getBoardSize() {
    return 3 * this.armSize - 2;
  }

  /**
   * Returns the SlotState of the given location of the board.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the SlotState at the given location
   * @throws IllegalArgumentException if the given location is outside the range of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.getBoardSize() - 1 ||  col < 0 || col > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("Given location is outside the range of the board");
    }
    return this.slots.get(row).get(col);
  }

  /**
   * Returns the score of the board.
   * @return the number of marbles remaining on the board
   */
  @Override
  public int getScore() {
    int count = 0;

    for (int i = 0; i < this.slots.size(); i++) {
      for (int j = 0; j < this.slots.get(i).size(); j++) {
        if (this.slots.get(i).get(j) == SlotState.Marble) {
          count++;
        }
      }
    }

    return count;
  }

  /**
   * Builds the board.
   * @param armSize armSize of the board
   * @param sRow row that the initial empty slot comes from
   * @param sCol column that the initial empty slot comes from
   * @return an ArrayList of ArrayLists of SlotStates that represents the board.
   */
  public abstract ArrayList<ArrayList<SlotState>> buildSlots(int armSize, int sRow, int sCol);
}
