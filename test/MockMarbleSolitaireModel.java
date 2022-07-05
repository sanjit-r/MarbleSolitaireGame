import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Mock MarbleSolitaireModel class.
 */
public class MockMarbleSolitaireModel implements MarbleSolitaireModel {

  private StringBuilder log;

  public MockMarbleSolitaireModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d\n",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
