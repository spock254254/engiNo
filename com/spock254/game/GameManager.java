package com.spock254.game;

import com.spock254.audio.SoundClip;
import com.spock254.audio.SoundClipBase;
import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.*;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;
import com.spock254.engine.interfaces.Rendering;
import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.draw.DrawingImageTitle;
import com.spock254.engine.interfaces.draw.DrawingText;
import com.spock254.engine.interfaces.gfx.IFont;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageTile;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    IImageTile imageTile;
    DrawingImageTitle drawingImageTitle;

    IImage image;
    DrawingImage drawingImage;

    public GameManager(){

        imageTile = new ImageTile("/res/thief_boy_drbl.png",100,100);
       // image = new Image("/res/thief_boy_drbl.png");
    }

    @Override
    public void setUp(GameContainer gameContainer) {
       //drawingImageTitle = new ImageTitle(gameContainer,imageTile);
       //drawingImageTitle.drawImageTile(10,10,0,0);

    }

    @Override
    public void update(GameContainer gameContainer, float deltaTime) {


    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {
        drawingImageTitle = new ImageTitle(gameContainer,imageTile);
        drawingImageTitle.drawImageTile(10,10,0,0);
        //drawingImage = new com.spock254.engine.draw.Image(gameContainer,image);
        //drawingImage.drawImage(10,10);

    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
