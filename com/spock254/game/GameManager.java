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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    IImageTile imageTile;
    DrawingImageTitle drawingImageTitle;

    IImage image;
    IImage image2;
    DrawingImage drawingImage;
    DrawingImage drawingImage2;

    public GameManager(){

        image = new Image("/res/Untitled.png");
        image2 = new Image("/res/hart.png");
        //image.setAlpha(true);
       // image = new Image("/res/thief_boy_drbl.png");
    }

    @Override
    public void setUp(GameContainer gameContainer) {

        drawingImage = new ImageDraw(gameContainer,image);
        drawingImage2 = new ImageDraw(gameContainer,image2);
    }


    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
        //if(gameContainer.getInput().isKeyDown(KeyEvent.VK_A)) i++;

    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {

        //drawingImage.setzDapth(3);
        //drawingImage2.setzDapth(2);
       // drawingImage.process();
        //drawingImage2.process();
        drawingImage.drawImage(10,10);
        drawingImage2.drawImage(15,15);


    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
