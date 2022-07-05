import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the MarbleSolitaire controller.
 */
public class MarbleSolitaireControllerImplTest {

  @Test
  public void testValidInitializationOfConstructorEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test
  public void testValidInitializationOfConstructorEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test
  public void testValidInitializationOfConstructorTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullModelEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(null, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullModelEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(null, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullModelTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new TriangleSolitaireTextView(null, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullViewEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = null;
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullViewEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = null;
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullViewTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = null;
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullInputEnglish() {
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, null);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullInputEuropean() {
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, null);

    assertEquals(c, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullInputTriangle() {
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, null);

    assertEquals(c, c);
  }

  @Test
  public void testInitialMessageWithZeroParamEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32", log.toString());
  }

  @Test
  public void testInitialMessageWithZeroParamEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", log.toString());
  }

  @Test
  public void testInitialMessageWithZeroParamTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", log.toString());
  }

  @Test
  public void testInitialMessageWithOneParamEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(5);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

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
            "        O O O O O" +
            "\nScore: 104" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "        O O O O O\n" +
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
            "        O O O O O" +
            "\nScore: 104", log.toString());
  }

  @Test
  public void testInitialMessageWithOneParamEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel(5);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

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
            "        O O O O O\n" +
            "Score: 128\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
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
            "        O O O O O\n" +
            "Score: 128", log.toString());
  }

  @Test
  public void testInitialMessageWithOneParamTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel(3);
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("  _\n" +
            " O O\n" +
            "O O O\n" +
            "Score: 5\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "  _\n" +
            " O O\n" +
            "O O O\n" +
            "Score: 5", log.toString());
  }

  @Test
  public void testInitialMessageWithTwoParamEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(2, 3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32", log.toString());
  }

  @Test
  public void testInitialMessageWithTwoParamEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel(4, 4);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", log.toString());
  }

  @Test
  public void testInitialMessageWithTwoParamTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel(1, 1);
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", log.toString());
  }

  @Test
  public void testInitialMessageWithThreeParamEnglish() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel(5, 5, 6);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O" +
            "\nScore: 104" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O" +
            "\nScore: 104", log.toString());
  }

  @Test
  public void testInitialMessageWithThreeParamEuropean() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel(5, 4, 0);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "_ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 128\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "_ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Score: 128", log.toString());
  }

  @Test
  public void testInitialMessageWithThreeParamTriangle() {
    Readable in = new StringReader("q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel(3, 2, 0);
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("  O\n" +
            " O O\n" +
            "_ O O\n" +
            "Score: 5\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "  O\n" +
            " O O\n" +
            "_ O O\n" +
            "Score: 5", log.toString());
  }

  @Test
  public void testQuitAfterOneValidMoveEnglish() {
    Readable in = new StringReader("6 4 4 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O" +
            "\nScore: 31" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O" +
            "\nScore: 31", log.toString());
  }

  @Test
  public void testQuitAfterOneValidMoveEuropean() {
    Readable in = new StringReader("6 4 4 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35", log.toString());
  }

  @Test
  public void testQuitAfterOneValidMove() {
    Readable in = new StringReader("3 3 1 1 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", log.toString());
  }

  @Test
  public void testQuitAfterMultipleValidMovesEnglish() {
    Readable in = new StringReader("6 4 4 4 3 4 5 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O" +
            "\nScore: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O" +
            "\nScore: 30" +
            "\nGame quit!" +
            "\nState of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O" +
            "\nScore: 30", log.toString());
  }

  @Test
  public void testQuitAfterMultipleValidMovesEuropean() {
    Readable in = new StringReader("6 4 4 4 3 4 5 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 34\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 34", log.toString());
  }

  @Test
  public void testQuitAfterMultipleValidMovesTriangle() {
    Readable in = new StringReader("3 3 1 1 5 5 3 3 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 12\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 12", log.toString());
  }

  @Test
  public void testPlayUntilGameOverValidMovesEnglish() {
    Readable in = new StringReader("6 4 4 4 " +
            "3 4 5 4 " +
            "1 4 3 4 " +
            "4 2 4 4 " +
            "4 5 4 3 " +
            "4 7 4 5");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O" +
            "\nScore: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26", log.toString());
  }

  @Test
  public void testPlayUntilGameOverValidMovesEuropean() {
    Readable in = new StringReader("6 4 4 4\n" +
            "3 4 5 4\n" +
            "1 4 3 4\n" +
            "4 6 4 4\n" +
            "4 3 4 5\n" +
            "4 1 4 3\n" +
            "2 2 2 4\n" +
            "2 5 2 3\n" +
            "6 2 6 4\n" +
            "6 5 6 3\n" +
            "6 6 4 6\n" +
            "4 6 4 4\n" +
            "4 4 2 4\n" +
            "3 6 3 4\n" +
            "3 4 1 4\n" +
            "3 2 3 4\n" +
            "5 3 3 3\n" +
            "7 3 5 3\n" +
            "7 5 7 3\n" +
            "3 4 3 2\n" +
            "3 1 3 3\n" +
            "2 3 4 3\n" +
            "5 3 3 3\n" +
            "5 5 5 3\n" +
            "5 2 5 4\n");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 34\n" +
                    "    O _ O\n" +
                    "  O O _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 33\n" +
                    "    O _ O\n" +
                    "  O O _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O _ O\n" +
                    "  O O _ O O\n" +
                    "O O O O O O O\n" +
                    "O O _ _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "    O _ O\n" +
                    "  O O _ O O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "    O _ O\n" +
                    "  _ _ O O O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 29\n" +
                    "    O _ O\n" +
                    "  _ O _ _ O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 28\n" +
                    "    O _ O\n" +
                    "  _ O _ _ O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  _ _ O O O\n" +
                    "    O O O\n" +
                    "Score: 27\n" +
                    "    O _ O\n" +
                    "  _ O _ _ O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O _ O\n" +
                    "O O O O O O O\n" +
                    "  _ O _ _ O\n" +
                    "    O O O\n" +
                    "Score: 26\n" +
                    "    O _ O\n" +
                    "  _ O _ _ O\n" +
                    "O O O O O O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 25\n" +
                    "    O _ O\n" +
                    "  _ O _ _ O\n" +
                    "O O O O O O O\n" +
                    "_ _ O O _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 24\n" +
                    "    O _ O\n" +
                    "  _ O O _ O\n" +
                    "O O O _ O O O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 23\n" +
                    "    O _ O\n" +
                    "  _ O O _ O\n" +
                    "O O O O _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 22\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O O O _ _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 21\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O _ _ O _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 20\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O _ O O _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O _ O O _ O\n" +
                    "  _ O _ _ _\n" +
                    "    O O O\n" +
                    "Score: 19\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O _ O O _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    _ O O\n" +
                    "Score: 18\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O _ O O _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 17\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "O O _ _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 16\n" +
                    "    O O O\n" +
                    "  _ O _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 15\n" +
                    "    O O O\n" +
                    "  _ _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "O O O O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 14\n" +
                    "    O O O\n" +
                    "  _ _ _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O _ O O _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 13\n" +
                    "    O O O\n" +
                    "  _ _ _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O O O _ _ _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 12\n" +
                    "Game over!\n" +
                    "    O O O\n" +
                    "  _ _ _ _ O\n" +
                    "_ _ O _ _ _ O\n" +
                    "_ _ _ _ _ _ O\n" +
                    "O _ _ O _ _ O\n" +
                    "  _ _ _ _ _\n" +
                    "    O _ _\n" +
                    "Score: 11", log.toString());
  }

  @Test
  public void testPlayUntilGameOverValidMovesTriangle() {
    Readable in = new StringReader("3 3 1 1\n" +
            "5 5 3 3\n" +
            "4 2 2 2\n" +
            "2 2 4 4\n" +
            "5 3 3 3\n" +
            "4 4 2 2\n" +
            "5 1 5 3\n" +
            "5 4 5 2\n" +
            "1 1 3 3\n" +
            "3 1 1 1\n");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 12\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O _ O _\n" +
            "O O O O _\n" +
            "Score: 11\n" +
            "    O\n" +
            "   O _\n" +
            "  O _ _\n" +
            " O _ O O\n" +
            "O O O O _\n" +
            "Score: 10\n" +
            "    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ O\n" +
            "O O _ O _\n" +
            "Score: 9\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "O O _ O _\n" +
            "Score: 8\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ _ O O _\n" +
            "Score: 7\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 6\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 5\n" +
            "Game over!\n" +
            "    O\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 4", log.toString());
  }

  @Test
  public void testPlayUntilGameOverWithInvalidMovesEnglish() {
    Readable in = new StringReader("6 4 4 4 " +
            "1 1 1 1 " +
            "3 4 5 4 " +
            "3 5 4 4 " +
            "1 4 3 4 " +
            "4 2 4 4 " +
            "4 5 4 3 " +
            "8 9 10 11 " +
            "4 7 4 5");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals(
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. From position is invalid.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Invalid move. Play again. Marble can only move " +
                    "two slots directly horizontal or vertical\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Invalid move. Play again. Given location is outside the range of the board\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26", log.toString());
  }

  @Test
  public void testPlayUntilGameOverWithInvalidMovesEuropean() {
    Readable in = new StringReader("6 4 4 4\n" +
            "3 4 5 4\n" +
            "1 4 3 4\n" +
            "4 6 4 4\n" +
            "4 3 4 5\n" +
            "4 1 4 3\n" +
            "2 2 2 4\n" +
            "2 5 2 3\n" +
            "1 1 1 1\n" +
            "6 2 6 4\n" +
            "6 5 6 3\n" +
            "6 6 4 6\n" +
            "4 6 4 4\n" +
            "4 4 2 4\n" +
            "3 6 3 4\n" +
            "3 4 1 4\n" +
            "3 2 3 4\n" +
            "5 5 2 2\n" +
            "5 3 3 3\n" +
            "7 3 5 3\n" +
            "7 5 7 3\n" +
            "3 4 3 2\n" +
            "3 1 3 3\n" +
            "1 2 3 4\n" +
            "2 3 4 3\n" +
            "5 3 3 3\n" +
            "5 5 5 3\n" +
            "5 2 5 4\n");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 34\n" +
            "    O _ O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 33\n" +
            "    O _ O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O _ O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O _ O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O _ O\n" +
            "  _ _ O O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "Invalid move. Play again. From position is invalid.\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  _ _ O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "  _ O _ _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O _ O\n" +
            "  _ O _ _ O\n" +
            "O O O O O O O\n" +
            "_ _ O O _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O _ O\n" +
            "  _ O O _ O\n" +
            "O O O _ O O O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O _ O\n" +
            "  _ O O _ O\n" +
            "O O O O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O O O _ _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "Invalid move. Play again. Marble can only move two slots directly horizontal " +
            "or vertical\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O _ _ O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O _ O O _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O _ O O _ O\n" +
            "  _ O _ _ _\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O _ O O _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    _ O O\n" +
            "Score: 18\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O _ O O _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 17\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "O O _ _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 16\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 15\n" +
            "Invalid move. Play again. From position is invalid.\n" +
            "    O O O\n" +
            "  _ O _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 15\n" +
            "    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "O O O O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 14\n" +
            "    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O _ O O _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 13\n" +
            "    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O O O _ _ _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 12\n" +
            "Game over!\n" +
            "    O O O\n" +
            "  _ _ _ _ O\n" +
            "_ _ O _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ O _ _ O\n" +
            "  _ _ _ _ _\n" +
            "    O _ _\n" +
            "Score: 11", log.toString());
  }

  @Test
  public void testPlayUntilGameOverWithInvalidMovesTriangle() {
    Readable in = new StringReader("3 3 1 1\n" +
            "5 5 3 3\n" +
            "1 2 3 4\n" +
            "4 2 2 2\n" +
            "2 2 4 4\n" +
            "5 3 3 3\n" +
            "4 4 2 2\n" +
            "5 5 1 1\n" +
            "5 1 5 3\n" +
            "5 4 5 2\n" +
            "1 3 5 3\n" +
            "1 1 3 3\n" +
            "3 1 1 1\n");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 12\n" +
            "Invalid move. Play again. From position is invalid.\n" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O _\n" +
            "Score: 12\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O _ O _\n" +
            "O O O O _\n" +
            "Score: 11\n" +
            "    O\n" +
            "   O _\n" +
            "  O _ _\n" +
            " O _ O O\n" +
            "O O O O _\n" +
            "Score: 10\n" +
            "    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ O\n" +
            "O O _ O _\n" +
            "Score: 9\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "O O _ O _\n" +
            "Score: 8\n" +
            "Invalid move. Play again. From position does not have a marble.\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "O O _ O _\n" +
            "Score: 8\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ _ O O _\n" +
            "Score: 7\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 6\n" +
            "Invalid move. Play again. From position is invalid.\n" +
            "    O\n" +
            "   O O\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 6\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 5\n" +
            "Game over!\n" +
            "    O\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O _ _ _\n" +
            "_ O _ _ _\n" +
            "Score: 4", log.toString());
  }

  @Test
  public void testInvalidInputsEnglish() {
    Readable in = new StringReader("6 hello 4 4 four 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", log.toString());
  }

  @Test
  public void testInvalidInputsEuropean() {
    Readable in = new StringReader("6 hello 4 4 four 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O\n" +
            "Score: 35", log.toString());
  }

  @Test
  public void testInvalidInputsTriangle() {
    Readable in = new StringReader("3 hello 3 1 one 1 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", log.toString());
  }

  @Test
  public void testQuitInFromRow() {
    Readable in = new StringReader("q 4 4 4");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
  }

  @Test
  public void testQuitInFromCol() {
    Readable in = new StringReader("6 q 4 4");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
  }

  @Test
  public void testQuitInToRow() {
    Readable in = new StringReader("6 4 q 4");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
  }

  @Test
  public void testQuitInToCol() {
    Readable in = new StringReader("6 4 4 q");
    Appendable log = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(model, view, in);

    c.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
  }

  @Test
  public void testModelInputs() {
    Readable in = new StringReader("6 4 4 4 q");
    Readable in2 = new StringReader("a 3 5 5 5 q");
    Readable in3 = new StringReader("3 a 5 5 5 q");
    Readable in4 = new StringReader("3 5 5 a 5 q");
    Readable in5 = new StringReader("3 3 3 5 a q");
    Readable in6 = new StringReader("3 3 a a a 5 5 q");
    Readable in7 = new StringReader("3\n3\n3\n3\nq");
    Readable in8 = new StringReader("3\n4\na\na\n4\n4\nq");

    StringBuilder log = new StringBuilder();
    StringBuilder log2 = new StringBuilder();
    StringBuilder log3 = new StringBuilder();
    StringBuilder log4 = new StringBuilder();
    StringBuilder log5 = new StringBuilder();
    StringBuilder log6 = new StringBuilder();
    StringBuilder log7 = new StringBuilder();
    StringBuilder log8 = new StringBuilder();


    MarbleSolitaireModel mock = new MockMarbleSolitaireModel(log);
    MarbleSolitaireModel mock2 = new MockMarbleSolitaireModel(log2);
    MarbleSolitaireModel mock3 = new MockMarbleSolitaireModel(log3);
    MarbleSolitaireModel mock4 = new MockMarbleSolitaireModel(log4);
    MarbleSolitaireModel mock5 = new MockMarbleSolitaireModel(log5);
    MarbleSolitaireModel mock6 = new MockMarbleSolitaireModel(log6);
    MarbleSolitaireModel mock7 = new MockMarbleSolitaireModel(log7);
    MarbleSolitaireModel mock8 = new MockMarbleSolitaireModel(log8);

    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, new StringBuilder());
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(mock2, new StringBuilder());
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(mock3, new StringBuilder());
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(mock4, new StringBuilder());
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(mock5, new StringBuilder());
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(mock6, new StringBuilder());
    MarbleSolitaireView view7 = new MarbleSolitaireTextView(mock7, new StringBuilder());
    MarbleSolitaireView view8 = new MarbleSolitaireTextView(mock8, new StringBuilder());

    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(mock, view, in);
    MarbleSolitaireController c2 = new MarbleSolitaireControllerImpl(mock2, view2, in2);
    MarbleSolitaireController c3 = new MarbleSolitaireControllerImpl(mock3, view3, in3);
    MarbleSolitaireController c4 = new MarbleSolitaireControllerImpl(mock4, view4, in4);
    MarbleSolitaireController c5 = new MarbleSolitaireControllerImpl(mock5, view5, in5);
    MarbleSolitaireController c6 = new MarbleSolitaireControllerImpl(mock6, view6, in6);
    MarbleSolitaireController c7 = new MarbleSolitaireControllerImpl(mock7, view7, in7);
    MarbleSolitaireController c8 = new MarbleSolitaireControllerImpl(mock8, view8, in8);

    c.playGame();
    c2.playGame();
    c3.playGame();
    c4.playGame();
    c5.playGame();
    c6.playGame();
    c7.playGame();
    c8.playGame();

    assertEquals("fromRow = 5, fromCol = 3, toRow = 3, toCol = 3\n", log.toString());
    assertEquals("fromRow = 2, fromCol = 4, toRow = 4, toCol = 4\n", log2.toString());
    assertEquals("fromRow = 2, fromCol = 4, toRow = 4, toCol = 4\n", log3.toString());
    assertEquals("fromRow = 2, fromCol = 4, toRow = 4, toCol = 4\n", log4.toString());
    assertEquals("fromRow = 2, fromCol = 2, toRow = 2, toCol = 4\n", log5.toString());
    assertEquals("fromRow = 2, fromCol = 2, toRow = 4, toCol = 4\n", log6.toString());
    assertEquals("fromRow = 2, fromCol = 2, toRow = 2, toCol = 2\n", log7.toString());
    assertEquals("fromRow = 2, fromCol = 3, toRow = 3, toCol = 3\n", log8.toString());

  }

}