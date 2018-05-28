package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.TextDraw;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.button.BasicButton;
import com.spock254.engine.ui.button.Button;

public class GameManager extends AbstractGame {

    BasicButton button;
    BasicButton button2;

    public GameManager(){

    }

    @Override
    public void setUp(GameContainer gameContainer) {
        //button = new BasicButton(gameContainer,new RectFilledDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
          //                      10,10,40,20,0xffE6118A,
            //                    "Start",19,17,0xff2B0B1D);

        //button2 = new Button(gameContainer,new RectFilledDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
        //        11,41,20,15,0xffE6118A,
        //        "Start",0xff2B0B1D,0xff9FFFA6);
        button2 = new Button(gameContainer,new RectFilledDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
                10,20,50,30,"Start",
                new UIColor(0xff524C3D,0xff7C4E40,0xffF65828,0xffCAB4AE),
                new UIColor(0xff6AF96F,0xffA4F7A6,0xffF5DDA6,0xffD8CEB5));

    }


    @Override
    public void update(GameContainer gameContainer, float deltaTime) {

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
