import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class SimplePlatformerGamee extends JPanel implements ActionListener {

    // Game states
    private enum GameState {
        PLAYING, WON, LOST
    }

    private GameState gameState;

    // Player properties
    private int playerX;
    private int playerY;
    private final int playerWidth = 30;
    private final int playerHeight = 40;
    private final int playerSpeed = 5;
    private double velocityY; // Using double for smoother gravity/jump calculations
    private final double gravity = 0.5;
    private final double jumpStrength = -10;
    private boolean onGround;

    // Movement flags
    private boolean movingLeft;
    private boolean movingRight;

    // Game loop timer
    private Timer gameLoopTimer;

    // Game elements
    private ArrayList<Platform> platforms;
    private ArrayList<Coin> coins;
    private Exit exit;
    private int score;

    // Tile size for mapping from the image
    private final int TILE_SIZE = 40;

    public SimplePlatformerGamee() {
        // Set up the panel
        setPreferredSize(new Dimension(800, 600)); // Window size
        setBackground(new Color(135, 206, 235)); // Sky blue background
        setFocusable(true); // Make sure panel can receive key events
        addKeyListener(new GameKeyListener()); // Add keyboard listener

        // Initialize game elements and state
        initGame();

        // Initialize game loop timer
        gameLoopTimer = new Timer(15, this); // Updates every 15 milliseconds (approx 60 FPS)
        gameLoopTimer.start();
    }

    private void initGame() {
        playerX = 50;
        playerY = 0; // Will be set to ground level by resetGame()
        velocityY = 0;
        onGround = false;
        movingLeft = false;
        movingRight = false;
        score = 0;
        gameState = GameState.PLAYING;

        // Define platforms based on the image grid
        platforms = new ArrayList<>();
        // Ground platform
        // Ensure getHeight() is called after the panel has been laid out,
        // or use a fixed height for initialization if called before.
        // For simplicity, we'll assume getHeight() returns the preferred size height here.
        platforms.add(new Platform(0, (int)(600 - TILE_SIZE), 800, TILE_SIZE, new Color(74, 44, 42))); // Dark brown ground

        // Floating platforms - adjusted for better playability and visual appeal
        // Row 1 (1 tile up from ground)
        platforms.add(new Platform(TILE_SIZE * 2, (int)(600 - TILE_SIZE * 2), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 5, (int)(600 - TILE_SIZE * 2), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 10, (int)(600 - TILE_SIZE * 2), TILE_SIZE * 3, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 16, (int)(600 - TILE_SIZE * 2), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));

        // Row 2 (2 tiles up from ground)
        platforms.add(new Platform(TILE_SIZE * 1, (int)(600 - TILE_SIZE * 3), TILE_SIZE * 3, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 4, (int)(600 - TILE_SIZE * 3), TILE_SIZE * 3, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 9, (int)(600 - TILE_SIZE * 3), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 15, (int)(600 - TILE_SIZE * 3), TILE_SIZE * 3, TILE_SIZE / 2, new Color(107, 66, 38)));

        // Row 3 (3 tiles up from ground)
        platforms.add(new Platform(TILE_SIZE * 2, (int)(600 - TILE_SIZE * 4), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 5, (int)(600 - TILE_SIZE * 4), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 10, (int)(600 - TILE_SIZE * 4), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 17, (int)(600 - TILE_SIZE * 4), TILE_SIZE * 1, TILE_SIZE / 2, new Color(107, 66, 38)));

        // Row 4 (higher platforms)
        platforms.add(new Platform(TILE_SIZE * 7, (int)(600 - TILE_SIZE * 5), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));
        platforms.add(new Platform(TILE_SIZE * 13, (int)(600 - TILE_SIZE * 5), TILE_SIZE * 2, TILE_SIZE / 2, new Color(107, 66, 38)));


        // Define coins based on red circles in the image
        coins = new ArrayList<>();
        coins.add(new Coin(TILE_SIZE * 3, (int)(600 - TILE_SIZE * 2.5), 8, Color.YELLOW));
        coins.add(new Coin(TILE_SIZE * 6, (int)(600 - TILE_SIZE * 2.5), 8, Color.YELLOW));
        coins.add(new Coin((int)(TILE_SIZE * 11.5), (int)(600 - TILE_SIZE * 2.5), 8, Color.YELLOW));
        coins.add(new Coin(TILE_SIZE * 17, (int)(600 - TILE_SIZE * 2.5), 8, Color.YELLOW));

        coins.add(new Coin((int)(TILE_SIZE * 2.5), (int)(600 - TILE_SIZE * 3.5), 8, Color.YELLOW));
        coins.add(new Coin((int)(TILE_SIZE * 5.5), (int)(600 - TILE_SIZE * 3.5), 8, Color.YELLOW));
        coins.add(new Coin((int)(TILE_SIZE * 10.5), (int)(600 - TILE_SIZE * 3.5), 8, Color.YELLOW));
        coins.add(new Coin((int)(TILE_SIZE * 16.5), (int)(600 - TILE_SIZE * 3.5), 8, Color.YELLOW));

        coins.add(new Coin(TILE_SIZE * 3, (int)(600 - TILE_SIZE * 4.5), 8, Color.YELLOW));
        coins.add(new Coin(TILE_SIZE * 6, (int)(600 - TILE_SIZE * 4.5), 8, Color.YELLOW));
        coins.add(new Coin(TILE_SIZE * 11, (int)(600 - TILE_SIZE * 4.5), 8, Color.YELLOW));
        coins.add(new Coin((int)(TILE_SIZE * 17.5), (int)(600 - TILE_SIZE * 4.5), 8, Color.YELLOW));

        coins.add(new Coin(TILE_SIZE * 8, (int)(600 - TILE_SIZE * 5.5), 8, Color.YELLOW));
        coins.add(new Coin(TILE_SIZE * 14, (int)(600 - TILE_SIZE * 5.5), 8, Color.YELLOW));

        // Define exit (mushroom icon in the image)
        exit = new Exit((int)(800 - TILE_SIZE * 1.5), (int)(600 - TILE_SIZE * 1.5), TILE_SIZE, TILE_SIZE, Color.MAGENTA);

        // Set initial player position on the ground
        playerY = platforms.get(0).y - playerHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the screen

        // Draw platforms
        for (Platform p : platforms) {
            g.setColor(p.color);
            g.fillRect(p.x, p.y, p.width, p.height);
        }

        // Draw coins
        for (Coin c : coins) {
            if (!c.collected) {
                g.setColor(c.color);
                g.fillOval(c.x - c.radius, c.y - c.radius, c.radius * 2, c.radius * 2);
            }
        }

        // Draw exit
        g.setColor(exit.color);
        g.fillRect(exit.x, exit.y, exit.width, exit.height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Inter", Font.BOLD, 24));
        // Using a simple text representation for the mushroom icon
        // For a more advanced game, you would load an image or draw a custom shape.
        g.drawString("🍄", exit.x + exit.width / 4, exit.y + exit.height * 3 / 4);


        // Draw the player
        g.setColor(new Color(255, 69, 0)); // Orange-red for player
        g.fillRect(playerX, playerY, playerWidth, playerHeight);

        // Draw score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Inter", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 25);

        // Draw game messages if game is not playing
        if (gameState != GameState.PLAYING) {
            drawMessage(g);
        }
    }

    private void drawMessage(Graphics g) {
        String message = "";
        Color textColor = Color.WHITE;
        if (gameState == GameState.WON) {
            message = "You Won! Score: " + score;
            textColor = Color.GREEN;
        } else if (gameState == GameState.LOST) {
            message = "Game Over! Score: " + score;
            textColor = Color.RED;
        }

        // Draw a semi-transparent background for the message
        g.setColor(new Color(0, 0, 0, 180)); // Black with 70% opacity
        g.fillRect(0, getHeight() / 2 - 50, getWidth(), 100);

        // Draw the message text
        g.setColor(textColor);
        g.setFont(new Font("Inter", Font.BOLD, 40));
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(message)) / 2;
        int y = (getHeight() / 2) + (fm.getAscent() / 2);
        g.drawString(message, x, y);

        // Draw restart instruction
        g.setColor(Color.WHITE);
        g.setFont(new Font("Inter", Font.PLAIN, 20));
        String restartMsg = "Press 'R' to Restart";
        fm = g.getFontMetrics();
        x = (getWidth() - fm.stringWidth(restartMsg)) / 2;
        y = (getHeight() / 2) + (fm.getAscent() / 2) + 50; // Below the main message
        g.drawString(restartMsg, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameState != GameState.PLAYING) {
            return; // Stop game logic if game is not playing
        }

        // Update player position based on movement flags
        if (movingLeft) {
            playerX -= playerSpeed;
        }
        if (movingRight) {
            playerX += playerSpeed;
        }

        // Apply gravity
        velocityY += gravity;
        playerY += velocityY;

        // Keep player within horizontal bounds of the window
        if (playerX < 0) {
            playerX = 0;
        }
        if (playerX + playerWidth > getWidth()) {
            playerX = getWidth() - playerWidth;
        }

        // Reset onGround flag for current frame
        onGround = false;

        // Platform collision detection
        Rectangle playerBounds = new Rectangle(playerX, playerY, playerWidth, playerHeight);
        for (Platform p : platforms) {
            Rectangle platformBounds = new Rectangle(p.x, p.y, p.width, p.height);

            if (playerBounds.intersects(platformBounds)) {
                // If falling and landed on top of a platform
                if (velocityY > 0 && playerY + playerHeight - velocityY <= p.y) {
                    playerY = p.y - playerHeight;
                    velocityY = 0;
                    onGround = true;
                }
                // If hitting the bottom of a platform (jumping into it)
                else if (velocityY < 0 && playerY >= p.y + p.height - velocityY) {
                    playerY = p.y + p.height;
                    velocityY = 0;
                }
            }
        }

        // Game Over condition: player falls below the bottom of the canvas
        if (playerY > getHeight()) {
            gameState = GameState.LOST;
        }

        // Coin collision detection
        Iterator<Coin> coinIterator = coins.iterator();
        while (coinIterator.hasNext()) {
            Coin c = coinIterator.next();
            if (!c.collected) {
                // Simple circular collision for coins
                double distanceX = (playerX + playerWidth / 2) - c.x;
                double distanceY = (playerY + playerHeight / 2) - c.y;
                double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

                if (distance < (playerWidth / 2 + c.radius)) { // Approximate collision
                    c.collected = true;
                    score += 10;
                }
            }
        }

        // Exit collision detection (win condition)
        Rectangle exitBounds = new Rectangle(exit.x, exit.y, exit.width, exit.height);
        if (playerBounds.intersects(exitBounds)) {
            gameState = GameState.WON;
        }

        // Request a repaint to update the screen
        repaint();
    }

    // Inner class for handling keyboard input
    private class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (gameState != GameState.PLAYING) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    initGame(); // Reset game if 'R' is pressed when game is over
                }
                return; // Ignore other keys if game is not playing
            }

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                movingLeft = true;
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                movingRight = true;
            } else if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                if (onGround) { // Only jump if on ground
                    velocityY = jumpStrength;
                    onGround = false; // Player is no longer on ground when jumping
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (gameState != GameState.PLAYING) {
                return; // Ignore key releases if game is not playing
            }

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                movingLeft = false;
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                movingRight = false;
            }
        }
    }

    // Helper class for Platform objects
    private static class Platform {
        int x, y, width, height;
        Color color;

        public Platform(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }
    }

    // Helper class for Coin objects
    private static class Coin {
        int x, y, radius;
        Color color;
        boolean collected;

        public Coin(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            this.collected = false;
        }
    }

    // Helper class for Exit object
    private static class Exit {
        int x, y, width, height;
        Color color;

        public Exit(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        // Set up the JFrame (the main window)
        JFrame frame = new JFrame("Simple Platformer Game");
        SimplePlatformerGamee gamePanel = new SimplePlatformerGamee();
        frame.add(gamePanel);
        frame.pack(); // Adjusts window size to fit the preferred size of the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false); // For simplicity, fixed size for now
        frame.setVisible(true); // Make the window visible
    }
}