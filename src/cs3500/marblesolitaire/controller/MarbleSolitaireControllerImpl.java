package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents the implementation of the MarbleSolitaire controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable readable;

  /**
   * Constructor for the controller implementation that takes in the
   * model, view, and readable objects.
   * @param model the MarbleSolitaire model
   * @param view the MarbleSolitaire view
   * @param readable the user inputs
   * @throws IllegalArgumentException when either the model, view, or readable is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }

    this.model = model;
    this.view = view;
    this.readable = readable;
  }


  @Override
  public void playGame() throws IllegalStateException {

    try {
      Scanner scan = new Scanner(readable);
      while (!this.model.isGameOver()) {

        // using the view, render the current state of the game
        this.view.renderBoard();
        this.view.renderMessage(System.lineSeparator());

        // using the view, transmit the score
        this.view.renderMessage("Score: " + this.model.getScore() + System.lineSeparator());

        // If the game is ongoing, obtain the next user input from the Readable object.
        int[] inputs = new int[4];
        int inputsIndex = 0;
        while (inputsIndex < 4) {

          if (!scan.hasNext()) {
            throw new IllegalStateException();
          }

          String nextInput = scan.next();
          if (nextInput.equalsIgnoreCase("q")) {
            this.view.renderMessage("Game quit!" + System.lineSeparator()
                    + "State of game when quit:" + System.lineSeparator());
            this.view.renderBoard();
            this.view.renderMessage(System.lineSeparator());
            this.view.renderMessage("Score: " + this.model.getScore());
            return;
          } else {
            try {
              int validInput = Integer.parseInt(nextInput);
              inputs[inputsIndex] = validInput;
              inputsIndex++;
            } catch (NumberFormatException e) {
              // do nothing
            }
          }
        }

        int fromRow = inputs[0];
        int fromCol = inputs[1];
        int toRow = inputs[2];
        int toCol = inputs[3];

        try {
          // Make the move
          model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
        } catch (IllegalArgumentException e) {
          this.view.renderMessage("Invalid move. Play again. "
                  + e.getMessage() + System.lineSeparator());
        }
      }

      if (this.model.isGameOver()) {
        this.view.renderMessage("Game over!" + System.lineSeparator());
        this.view.renderBoard();
        this.view.renderMessage(System.lineSeparator() + "Score: " + this.model.getScore());
      }
    } catch (IOException e) {
      throw new IllegalStateException("Error reading inputs");
    }

  }
}
