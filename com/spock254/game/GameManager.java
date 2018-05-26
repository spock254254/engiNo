package com.spock254.game;

import com.spock254.audio.SoundClip;
import com.spock254.audio.SoundClipBase;
import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.*;
import com.spock254.engine.draw.drawtools.OrderDraw;
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
import com.sun.org.apache.bcel.internal.generic.CHECKCAST;

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
    OrderDraw orderDraw;

    public GameManager(){

        image = new Image("/res/Untitled.png");
        image2 = new Image("/res/hart.png");
        //image.setAlpha(true);
       // image = new Image("/res/thief_boy_drbl.png");
    }

    @Override
    public void setUp(GameContainer gameContainer) {

        orderDraw = new OrderDraw();
        DrawingImage drawingImage1 = new ImageDraw(gameContainer,new Image("/res/hart.png"));
        drawingImage1.setzDapth(0);
        DrawingImage drawingImage2 = new ImageDraw(gameContainer,new Image("/res/standart.png"));
        drawingImage2.setzDapth(1);
        DrawingImage drawingImage3 = new ImageDraw(gameContainer,new Image("/res/Untitled.png"));
        drawingImage3.setzDapth(2);
        orderDraw.add(drawingImage1);
        orderDraw.add(drawingImage2);
        orderDraw.add(drawingImage3);
        orderDraw.sort();


    }


    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
        //if(gameContainer.getInput().isKeyDown(KeyEvent.VK_A)) i++;


    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {


        orderDraw.draw();

    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
