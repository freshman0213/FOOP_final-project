package views;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class Background{
    private List<Image> backgroundImages;
    private int current = 0;

    public Background(String path) {
        backgroundImages = imagesFromFolder(path);
    }

    public void render(Graphics g){
        g.drawImage(backgroundImages.get(current), 0, 0, GameView.WIDTH, GameView.HEIGHT, null);
    }

    public void update(){
        current = (current == backgroundImages.size() - 1)? 0 : current + 1;
    }
    
}
