package com.spock254.game;

import com.spock254.audio.SoundClip;
import com.spock254.audio.SoundClipBase;
import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.gfx.ImageTile;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    private ImageTile image;
    SoundClipBase soundClip;


    public GameManager(){

        image = new ImageTile("/res/CrBaa3.png",320*2,240 * 2);
        soundClip = new SoundClipBase("/res/Beep1.wav");
    }

    @Override
    public void update(GameContainer gameContainer, float deltaTime) {

        if(gameContainer.getInput().isKeyDown(KeyEvent.VK_A))
            soundClip.play();


    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {

       // renderer.drawImage(image,0,0);
        //renderer.drawImageTile(image,0 ,0,temp2,0);
    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
