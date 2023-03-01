import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.Color;

public class Tile extends JPanel {
    
    private JButton tileButton;
    private ChessPiece piece;
    private Color tileColor;
    private int rowCoordinate;
    private int colCoordinate;

    public ChessPiece getPiece() { return piece; }
    public Color getTileColor() { return tileColor; }
    public int getRowCoordinate() { return rowCoordinate; }
    public int getColCoordinate() { return colCoordinate; }
    public JButton getTileButton() { return tileButton; }

    public void setRowCoordinate(int rowCoordinate) { this.rowCoordinate = rowCoordinate; }
    public void setColCoordinate(int colCoordinate) { this.colCoordinate = colCoordinate; }
    public void setPiece(ChessPiece piece) { this.piece = piece; }
    public void setTileColor(Color tileColor) { this.tileColor = tileColor; }

    public Tile(ChessPiece pieceIn, Color tileColorIn) {
        setLayout(null); // Allows button in panel to be any size it wants to be
        setPiece(pieceIn);
        setTileColor(tileColorIn);
        /* Creates an invisible button. This allows the user to
        replace the shape with a face by clicking the shape. */
        tileButton = new JButton();
        
        // Makes button invisible.
        tileButton.setOpaque(false);
        tileButton.setContentAreaFilled(false);
        tileButton.setBorderPainted(false);

        if (!piece.getPieceType().equals("Empty")) {
            tileButton.setIcon(pieceIn.getPieceImage());
        }

        add(tileButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(tileColor);
        g.fillRect(0,0, getWidth(), getHeight());

        // Sets size of the invisible button so it covers the entire shape
        tileButton.setSize(getWidth(), getHeight());
    }
}