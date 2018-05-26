package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.TextDraw;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.ui.BasicButton;

public class GameManager extends AbstractGame {

    BasicButton button;

    public GameManager(){

    }

    @Override
    public void setUp(GameContainer gameContainer) {
        button = new BasicButton(gameContainer,new RectFilledDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
                                10,10,40,20,0xffE6118A,
                                "Start",19,17,0xff2B0B1D);

    }


    @Override
    public void update(GameContainer gameContainer, float deltaTime) {

    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {
        button.drawButton();

    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
