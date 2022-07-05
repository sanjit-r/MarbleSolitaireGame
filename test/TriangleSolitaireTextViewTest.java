import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the TriangleSolitaireTextViewClass.
 */
public class TriangleSolitaireTextViewTest {

  MarbleSolitaireModel ts1;
  MarbleSolitaireView v1;

  MarbleSolitaireModel ts2;
  MarbleSolitaireView v2;

  MarbleSolitaireModel ts3;
  MarbleSolitaireView v3;

  MarbleSolitaireModel ts4;
  MarbleSolitaireView v4;

  @Before
  public void init() {
    ts1 = new TriangleSolitaireModel();
    v1 = new TriangleSolitaireTextView(ts1);

    ts2 = new TriangleSolitaireModel(2, 1);
    v2 = new TriangleSolitaireTextView(ts2);

    ts3 = new TriangleSolitaireModel(3);
    v3 = new TriangleSolitaireTextView(ts3);

    ts4 = new TriangleSolitaireModel(3, 2, 1);
    v4 = new TriangleSolitaireTextView(ts4);
  }

  @Test
  public void testValidInitialization() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", v1.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", v2.toString());
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", v3.toString());
    assertEquals("  O\n" +
            " O O\n" +
            "O _ O", v4.toString());

  }

  @Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireView vError = new MarbleSolitaireTextView(null);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", v1.toString());
    ts1.move(2, 2, 0, 0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", v1.toString());

  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    view.renderBoard();

    assertEquals(view.toString(), out.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, out);
    view.renderMessage("Hello world");

    assertEquals("Hello world", out.toString());
  }
}