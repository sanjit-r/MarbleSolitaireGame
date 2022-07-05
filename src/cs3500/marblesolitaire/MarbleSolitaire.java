package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class to play MarbleSolitaire.
 */
public final class MarbleSolitaire {

  /**
   * Method to play MarbleSolitaire.
   * @param args Arguments.
   */
  public static void main(String[] args) {

    MarbleSolitaireModel model = null;
    MarbleSolitaireView view;
    MarbleSolitaireController c;

    if (args.length == 0) {
      model = new EnglishSolitaireModel();
      view = new MarbleSolitaireTextView(model);
      c = new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      c.playGame();
    } else if (args[0].equals("english")) {
      try {
        String next = args[1];
        if (args[1].equals("-size")) {
          model = new EnglishSolitaireModel(Integer.parseInt(args[2]));
        } else if (args[1].equals("-hole")) {
          model = new EnglishSolitaireModel(Integer.parseInt(args[2]) - 1,
                  Integer.parseInt(args[3]) - 1);
        } else {
          // do nothing
        }
      } catch (IndexOutOfBoundsException e) {
        model = new EnglishSolitaireModel();
      }
      view = new MarbleSolitaireTextView(model);
      c = new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      c.playGame();
    } else if (args[0].equals("european")) {
      try {
        String next = args[1];
        if (args[1].equals("-size")) {
          model = new EuropeanSolitaireModel(Integer.parseInt(args[2]));
        } else if (args[1].equals("-hole")) {
          model = new EuropeanSolitaireModel(Integer.parseInt(args[2]) - 1,
                  Integer.parseInt(args[3]) - 1);
        } else {
          // do nothing
        }
      } catch (IndexOutOfBoundsException e) {
        model = new EuropeanSolitaireModel();
      }
      view = new MarbleSolitaireTextView(model);
      c = new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      c.playGame();
    } else if (args[0].equals("triangular")) {
      try {
        String next = args[1];
        if (args[1].equals("-size")) {
          model = new TriangleSolitaireModel(Integer.parseInt(args[2]));
        } else if (args[1].equals("-hole")) {
          model = new TriangleSolitaireModel(Integer.parseInt(args[2]) - 1,
                  Integer.parseInt(args[3]) - 1);
        } else {
          // do nothing
        }
      } catch (IndexOutOfBoundsException e) {
        model = new TriangleSolitaireModel();
      }
      view = new TriangleSolitaireTextView(model);
      c = new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      c.playGame();
    }

  }

}
