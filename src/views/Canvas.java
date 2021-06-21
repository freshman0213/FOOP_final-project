package views;

import javax.swing.JPanel;
import java.awt.*;

import model.World;

public class Canvas extends JPanel implements View {
    private World world;

    @Override
    public void render(World world) {
        this.world = world;
        repaint(); // ask the JPanel to repaint, it will invoke paintComponent(g) after a while.
    }

    @Override
    protected void paintComponent(Graphics g /*paintbrush*/) {
        super.paintComponent(g);
        // Now, let's paint
        g.setColor(Color.WHITE); // paint background with all white
        g.fillRect(0, 0, GameView.WIDTH, GameView.HEIGHT);

        world.render(g); // ask the world to paint itself and paint the sprites on the canvas
    }
}
