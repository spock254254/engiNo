package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.TextDraw;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.interfaces.ui.button.IButton;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.button.BasicButton;
import com.spock254.engine.ui.button.Button;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameManager extends AbstractGame {

    BasicButton button;
    IButton button2;

    public GameManager(){

    }

    @Override
    public void setUp(GameContainer gameContainer) {

        button2 = new Button(gameContainer,new RectFilledDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
                10,20,50,30,"Start",
                new UIColor(0xff524C3D,0xff7C4E40,0xffF65828,0xffCAB4AE),
                new UIColor(0xff6AF96F,0xffA4F7A6,0xffF5DDA6,0xffD8CEB5),
                () -> System.out.println("CLICK!!!"));
    }


    @Override
    public void update(GameContainer gameContainer, float deltaTime) {

        button2.click();
    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {

        button2.drawButton();


    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
