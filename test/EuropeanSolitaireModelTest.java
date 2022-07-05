
import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  MarbleSolitaireModelState.SlotState marble;
  MarbleSolitaireModelState.SlotState invalid;
  MarbleSolitaireModelState.SlotState empty;

  MarbleSolitaireModel e1;
  MarbleSolitaireModel e2;
  MarbleSolitaireModel e3;
  MarbleSolitaireModel e4;

  @Before
  public void init() {
    marble = MarbleSolitaireModelState.SlotState.Marble;
    invalid = MarbleSolitaireModelState.SlotState.Invalid;
    empty = MarbleSolitaireModelState.SlotState.Empty;

    e1 = new EuropeanSolitaireModel();
    e2 = new EuropeanSolitaireModel(2, 2);
    e3 = new EuropeanSolitaireModel(5);
    e4 = new EuropeanSolitaireModel(5, 2, 2);
  }

  @Test
  public void testValidInitialization() {
    assertEquals(e1.getBoardSize(), 7);
    assertEquals(empty, e1.getSlotAt(3, 3));

    assertEquals(e2.getBoardSize(), 7);
    assertEquals(empty, e2.getSlotAt(2, 2));

    assertEquals(e3.getBoardSize(), 13);
    assertEquals(empty, e3.getSlotAt(6, 6));

    assertEquals(e4.getBoardSize(), 13);
    assertEquals(empty, e4.getSlotAt(2, 2));
  }

  @Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireModel es2Error = new EuropeanSolitaireModel(4);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es3Error = new EuropeanSolitaireModel(0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es4Error1 = new EuropeanSolitaireModel(-2, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es4Error2 = new EuropeanSolitaireModel(5, 0, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testValidMove() {
    e1.move(1, 3, 3, 3);
    assertEquals(empty, e1.getSlotAt(1, 3));
    assertEquals(empty, e1.getSlotAt(2, 3));
    assertEquals(marble, e1.getSlotAt(3, 3));

    init();

    e1.move(5, 3, 3, 3);
    assertEquals(empty, e1.getSlotAt(5, 3));
    assertEquals(empty, e1.getSlotAt(4, 3));
    assertEquals(marble, e1.getSlotAt(3, 3));

    init();

    e1.move(3, 5, 3, 3);
    assertEquals(empty, e1.getSlotAt(3, 5));
    assertEquals(empty, e1.getSlotAt(3, 4));
    assertEquals(marble, e1.getSlotAt(3, 3));

    init();

    e1.move(3, 1, 3, 3);
    assertEquals(empty, e1.getSlotAt(3, 1));
    assertEquals(empty, e1.getSlotAt(3, 2));
    assertEquals(marble, e1.getSlotAt(3, 3));

    MarbleSolitaireModel e = new EuropeanSolitaireModel(1, 1);
    e.move(1, 3, 1, 1);
    assertEquals(empty, e.getSlotAt(1, 3));
    assertEquals(empty, e.getSlotAt(1, 2));
    assertEquals(marble, e.getSlotAt(1, 1));
  }

  @Test
  public void testInvalidMove() {
    try {
      e1.move(1, 2, 1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(1, 0, 1, 2);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(3, 3, 5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(2, 2, 4, 2);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    } try {
      e1.move(2, 3, 4, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(5, 3, 2, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(5, 5, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(36, e1.getScore());
    assertEquals(128, e3.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertEquals(false, e1.isGameOver());
    e1.move(5, 3, 3, 3);
    e1.move(2, 3, 4, 3);
    e1.move(0, 3, 2, 3);
    e1.move(3, 5, 3, 3);
    e1.move(3, 2, 3, 4);
    e1.move(3, 0, 3, 2);
    e1.move(1, 1, 1, 3);
    e1.move(1, 4, 1, 2);
    e1.move(5, 1, 5, 3);
    e1.move(5, 4, 5, 2);
    e1.move(5, 5, 3, 5);
    e1.move(3, 5, 3, 3);
    e1.move(3, 3, 1, 3);
    e1.move(2, 5, 2, 3);
    e1.move(2, 3, 0, 3);
    e1.move(2, 1, 2, 3);
    e1.move(4, 2, 2, 2);
    e1.move(6, 2, 4, 2);
    e1.move(6, 4, 6, 2);
    e1.move(2, 3, 2, 1);
    e1.move(2, 0, 2, 2);
    e1.move(1, 2, 3, 2);
    e1.move(4, 2, 2, 2);
    e1.move(4, 4, 4, 2);
    e1.move(4, 1, 4, 3);
    assertEquals(true, e1.isGameOver());
  }
}