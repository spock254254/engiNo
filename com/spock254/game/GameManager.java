package com.spock254.game;

import com.spock254.audio.SoundClip;
import com.spock254.audio.SoundClipBase;
import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.*;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.gfx.ImageTile;
import com.spock254.engine.interfaces.Rendering;
import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.draw.DrawingImageTitle;
import com.spock254.engine.interfaces.draw.DrawingText;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {


    //private DrawingImage image;
    //private DrawingImageTitle image;
    com.spock254.engine.gfx.ImageTile imageTile;
    private DrawingImageTitle drawingImageTitle;
    private DrawingText text;
    private Font font;

    public GameManager(){

        font = new Font("/res/standart.png");
        imageTile = new ImageTile("/res/thief_boy_drbl.png",100,100);

    }

    @Override
    public void setUp(GameContainer gameContainer) {
        //image = new ImageTitle(gameContainer,new com.spock254.engine.gfx.ImageTile("/res/thief_boy_drbl.png",50,50));
        drawingImageTitle = new ImageTitle(gameContainer,imageTile);
        text = new Text(gameContainer,font);
    }

    @Override
    public void update(GameContainer gameContainer, float deltaTime) {

        //if(gameContainer.getInput().isKeyDown(KeyEvent.VK_A))
            //soundClip.play();



    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {


        //drawingImageTitle.drawImageTile(10,10,i,0);
        text.drawText("Vika Blizard",10,10,0xff60FDE8);
    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
