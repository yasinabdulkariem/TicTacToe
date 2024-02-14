import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class

    private Image xImage, oImage;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TITLE_BAR_HEIGHT = 23;
    private TicTacToe game;
    private static final int length = 150;
    private static final int start = 100;
    public TicTacToeViewer(TicTacToe game) {

        this.game = game;
        oImage = new ImageIcon("Resources/O.png").getImage();
        xImage = new ImageIcon("Resources/X.png").getImage();
        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image getxImage() {
        return xImage;
    }

    public Image getoImage() {
        return oImage;
    }
    public void drawBoard(Graphics g){
        if(this.game.getBoard() != null){
            for (int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    this.game.getBoard()[i][j].draw(g, start + j * length, start + i * length);
                }
            }
        }
    }
    public void drawString(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString("0", start + 20, start - 20);
        g.drawString("1", start + 20 + length, start - 20);
        g.drawString("2", start + 20 + length * 2, start - 20);

        g.drawString("0", start - 20, start + 20);
        g.drawString("1", start - 20 , start + 20 + length);
        g.drawString("2", start - 20 , start + 20 + length * 2);
    }
    public void win(Graphics g, String winner){
        g.setColor(Color.BLACK);

        if(winner.equals("-")){
            g.drawString("Tie Game", start, 750);
        }
        else if(winner.equals("O")){
            g.drawString("O Wins", start, 750);
        }
        else if(winner.equals("X")){
            g.drawString("X Wins", start, 750);
        }

    }
    public void paint(Graphics g){
        this.drawBoard(g);
        this.drawString(g);
        if(game.getGameOver()) {
            win(g, game.getWinner());
        }
    }
}
