import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private Image xImage, oImage;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private static final int length = 150;
    private TicTacToeViewer square;
    TicTacToe game;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer square, TicTacToe game) {
        this.square = square;
        this.row = row;
        this.col = col;
        this.game = game;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, int x, int y){
        //Draws the outline
        g.setColor(Color.BLACK);
        g.drawRect(x, y, length, length);
        //checks to see if on the winning square
        if(isWinningSquare){
            g.setColor(Color.GREEN);
            g.fillRect(x, y, length, length);
        }
        //Initializes the images
        oImage = new ImageIcon("Resources/O.png").getImage();
        xImage = new ImageIcon("Resources/X.png").getImage();
        //Draws the x images
        if(marker.equals(TicTacToe.X_MARKER)){
            g.drawImage(xImage, x, y, length, length, null);
        }
        //Draws the o images
        else if(marker.equals(TicTacToe.O_MARKER)){
            g.drawImage(oImage, x, y, length, length, null);
        }
    }
}