# MarbleSolitaireGame

Welcome to Marble Solitaire!

There are three versions of the game: english, european, and triangular. To play the game, read the following guide
for the arguments of the main method:

You must pass one of english, european, or triangular. This argument will decide which board shape (and hence which model and view) you should use.

You may optionally pass the two arguments -size N, where N is a number, to specify the size of the board. If unspecified, you should use the default 
size for the chosen board shape.

You may optionally pass the three arguments -hole R C, where R and C are numbers, to specify the row and column of the initial hole in the same manner 
as players of the game enter move positions. If unspecified, you should use the default hole position for the chosen board shape.

The following are some examples of valid command lines, and their meanings:

english -size 6 produces a plus-shaped board with arm-width of 6, and initial hole in the center

triangular produces a triangle-shaped board (as in this assignment) with side-length 5, and initial hole at the top

triangular -size 4 produces a triangle-shaped board (as in this assignment) with side-length 4, and initial hole at the top

european -hole 1 4 produces an octagon-shaped board (as in this assignment) with side-length 3, and the initial hole in the middle of the top edge.

This is not an exhaustive list; other command lines are possible.

Run the main method in "MarbleSolitaire.java" to play the game.

The game runs by command line inputs with 4 integer arguments, seperated by spaces. The first 2 arguments select the marble that you want to move,
and the second 2 select the space that you want to move the marble to.

