package views;

import model.World;

public interface View {
    void renderWorld(World world);
    void win();
    void lose();
}
