import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest {

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

    e1 = new TriangleSolitaireModel();
    e2 = new TriangleSolitaireModel(1, 1);
    e3 = new TriangleSolitaireModel(3);
    e4 = new TriangleSolitaireModel(3, 2, 0);
  }

  @Test
  public void testValidInitialization() {
    assertEquals(e1.getBoardSize(), 5);
    assertEquals(empty, e1.getSlotAt(0, 0));

    assertEquals(e2.getBoardSize(), 5);
    assertEquals(empty, e2.getSlotAt(1, 1));

    assertEquals(e3.getBoardSize(), 3);
    assertEquals(empty, e3.getSlotAt(0, 0));

    assertEquals(e4.getBoardSize(), 3);
    assertEquals(empty, e4.getSlotAt(2, 0));
  }

  @Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireModel es2Error = new TriangleSolitaireModel(-1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es3Error = new TriangleSolitaireModel(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es4Error1 = new TriangleSolitaireModel(-2, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      MarbleSolitaireModel es4Error2 = new TriangleSolitaireModel(5, 0, 1);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testValidMove() {
    e1.move(2, 2, 0, 0);
    assertEquals(empty, e1.getSlotAt(2, 2));
    assertEquals(empty, e1.getSlotAt(1, 1));
    assertEquals(marble, e1.getSlotAt(0, 0));

    init();

    e1.move(2, 0, 0, 0);
    assertEquals(empty, e1.getSlotAt(2, 0));
    assertEquals(empty, e1.getSlotAt(1, 0));
    assertEquals(marble, e1.getSlotAt(0, 0));

    MarbleSolitaireModel e = new TriangleSolitaireModel(5, 3, 1);

    e.move(1, 1, 3, 1);
    assertEquals(empty, e.getSlotAt(1, 1));
    assertEquals(empty, e.getSlotAt(2, 1));
    assertEquals(marble, e.getSlotAt(3, 1));

    e = new TriangleSolitaireModel(6, 4, 2);

    e.move(2, 0, 4, 2);
    assertEquals(empty, e.getSlotAt(2, 0));
    assertEquals(empty, e.getSlotAt(3, 1));
    assertEquals(marble, e.getSlotAt(4, 2));

    e = new TriangleSolitaireModel(6, 4, 2);

    e.move(4, 4, 4, 2);
    assertEquals(empty, e.getSlotAt(4, 4));
    assertEquals(empty, e.getSlotAt(4, 3));
    assertEquals(marble, e.getSlotAt(4, 2));

    e = new TriangleSolitaireModel(6, 4, 2);

    e.move(4, 0, 4, 2);
    assertEquals(empty, e.getSlotAt(4, 0));
    assertEquals(empty, e.getSlotAt(4, 1));
    assertEquals(marble, e.getSlotAt(4, 2));
  }

  @Test
  public void testInvalidMove() {
    try {
      e1.move(0, 2, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(3, 2, 1, 2);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(0, 0, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(3, 3, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    } try {
      e1.move(3, 1, 5, 2);
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
      e1.move(2, 2, 0, 0);
      e1.move(3, 3, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(14, e1.getScore());
    assertEquals(5, e3.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertEquals(false, e1.isGameOver());
    e1.move(2, 2, 0, 0);
    e1.move(4, 4, 2, 2);
    e1.move(3, 1, 1, 1);
    e1.move(1, 1, 3, 3);
    e1.move(4, 2, 2, 2);
    e1.move(3, 3, 1, 1);
    e1.move(4, 0, 4, 2);
    e1.move(4, 3, 4, 1);
    e1.move(0, 0, 2, 2);
    e1.move(2, 0, 0, 0);
    assertEquals(true, e1.isGameOver());
  }
}