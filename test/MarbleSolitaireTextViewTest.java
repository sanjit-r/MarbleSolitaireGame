import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextViewTest {

  MarbleSolitaireModel es1;
  MarbleSolitaireTextView tv1;

  MarbleSolitaireModel es2;
  MarbleSolitaireTextView tv2;

  MarbleSolitaireModel es3;
  MarbleSolitaireView tv3;

  MarbleSolitaireModel es4;
  MarbleSolitaireView tv4;

  MarbleSolitaireModel es5;
  MarbleSolitaireView tv5;

  MarbleSolitaireModel eu1;
  MarbleSolitaireView euView1;

  MarbleSolitaireModel eu2;
  MarbleSolitaireView euView2;

  MarbleSolitaireModel eu3;
  MarbleSolitaireView euView3;

  MarbleSolitaireModel eu4;
  MarbleSolitaireView euView4;

  @Before
  public void init() {
    es1 = new EnglishSolitaireModel();
    tv1 = new MarbleSolitaireTextView(es1);

    es2 = new EnglishSolitaireModel(2, 1);
    tv2 = new MarbleSolitaireTextView(es2);

    es3 = new EnglishSolitaireModel(5);
    tv3 = new MarbleSolitaireTextView(es3);

    es4 = new EnglishSolitaireModel(5, 4, 4);
    tv4 = new MarbleSolitaireTextView(es4);

    es5 = new EnglishSolitaireModel(0, 4);
    tv5 = new MarbleSolitaireTextView(es5);

    eu1 = new EuropeanSolitaireModel();
    euView1 = new MarbleSolitaireTextView(eu1);

    eu2 = new EuropeanSolitaireModel(5);
    euView2 = new MarbleSolitaireTextView(eu2);

    eu3 = new EuropeanSolitaireModel(5, 7, 7);
    euView3 = new MarbleSolitaireTextView(eu3);

    eu4 = new EuropeanSolitaireModel(4, 4);
    euView4 = new MarbleSolitaireTextView(eu4);
  }

  @Test
  public void testValidInitialization() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", tv1.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euView1.toString());

  }

  @Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireView tvError = new MarbleSolitaireTextView(null);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
                 "    O O O\n" +
                 "O O O O O O O\n" +
                 "O O O _ O O O\n" +
                 "O O O O O O O\n" +
                 "    O O O\n" +
                 "    O O O", tv1.toString());

    assertEquals("    O O O\n" +
                "    O O O\n" +
                "O _ O O O O O\n" +
                "O O O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O\n" +
                "    O O O", tv2.toString());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", tv3.toString());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", tv4.toString());

    assertEquals("    O O _\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", tv5.toString());

    es1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", tv1.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euView1.toString());
    eu1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euView1.toString());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euView2.toString());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O _ O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euView3.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O", euView4.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, out);
    view.renderBoard();

    assertEquals(view.toString(), out.toString());

    MarbleSolitaireModel model2 = new EuropeanSolitaireModel();
    Appendable out2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, out2);
    view2.renderBoard();

    assertEquals(view2.toString(), out2.toString());

    MarbleSolitaireModel model3 = new TriangleSolitaireModel();
    Appendable out3 = new StringBuilder();
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(model3, out3);
    view3.renderBoard();

    assertEquals(view3.toString(), out3.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(model, out);
    view.renderMessage("Hello world");

    assertEquals("Hello world", out.toString());
  }
}