import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for EnglishSolitaireModel.
 */
public class EnglishSolitaireModelTest {

  EnglishSolitaireModel es1;
  EnglishSolitaireModel es2;
  EnglishSolitaireModel es2Error;
  EnglishSolitaireModel es3;
  EnglishSolitaireModel es3Error;
  EnglishSolitaireModel es4;
  EnglishSolitaireModel es4Error;
  EnglishSolitaireModel es4Error2;

  /**
   * The initial conditions of the examples.
   */
  @Before
  public void init() {
    es1 = new EnglishSolitaireModel();
    es2 = new EnglishSolitaireModel(2, 1);
    es3 = new EnglishSolitaireModel(5);
    es4 = new EnglishSolitaireModel(5, 0, 4);
  }

  @Test
  public void testValidInitialization() {


    assertEquals(7, es1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 3));

    assertEquals(7, es2.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es2.getSlotAt(2, 1));

    assertEquals(13, es3.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es3.getSlotAt(6, 6));

    assertEquals(13, es4.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es4.getSlotAt(0, 4));


  }

  @Test
  public void testInvalidInitialization() {
    try {
      es2Error = new EnglishSolitaireModel(0, 0);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (0,0)")) {
        fail();
      }
    }
    try {
      es3Error = new EnglishSolitaireModel(2);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      es4Error = new EnglishSolitaireModel(5, 0, 0);
      es4Error2 = new EnglishSolitaireModel(2, 4, 4);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testValidMove() {
    es1.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, es1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(4, 3));

    this.init();
    es1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, es1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(2, 3));

    this.init();
    es1.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, es1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 4));

    this.init();
    es1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, es1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 2));
  }

  @Test
  public void testInvalidMove() {
    assertEquals(es1, es1);
    try {
      es1.move(3, 3, 5, 3);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      es1.move(5, 3, 6, 3);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      es1.move(2, 0, 0, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      es1.move(0, 0, 2, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      es1.move(0, 2, 2, 2);
    } catch (IllegalArgumentException e) {
      // do nothing
    } try {
      es1.move(4, 3, 2, 3);
    } catch (IllegalArgumentException e) {
      // do nothing
    } try {
      es1.move(6, 3, 3, 3);
    } catch (IllegalArgumentException e) {
      // do nothing
    } try {
      new EnglishSolitaireModel(3, 4).move(1, 2, 3, 4);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testIsGameOver() {
    assertEquals(false, es1.isGameOver());
    es1.move(5, 3, 3, 3);
    es1.move(2, 3, 4, 3);
    es1.move(0, 3, 2, 3);
    es1.move(3, 1, 3, 3);
    es1.move(3, 4, 3, 2);
    es1.move(3, 6, 3, 4);
    assertEquals(true, es1.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, es1.getBoardSize());
    assertEquals(13, es3.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, es1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, es1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, es1.getSlotAt(0, 0));
    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, es1.getSlotAt(-1, 10000));
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(32, es1.getScore());
    assertEquals(104, es3.getScore());
  }
}