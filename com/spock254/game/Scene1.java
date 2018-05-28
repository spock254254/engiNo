package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.CircleDraw;
import com.spock254.engine.draw.TextDraw;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.button.IButton;
import com.spock254.engine.scene.SceneConrainer;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.button.Button;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Scene1 extends AbstractGame {

    IDrawingShape circle;
    IButton button2;

    @Override
    public void setUp(GameContainer gameContainer) {
        circle =  new CircleDraw(gameContainer);
        button2 = new Button(gameContainer,new CircleDraw(gameContainer),new TextDraw(gameContainer,new Font("/res/standart.png")),
                50,50,25,30,"Start",41,46,
                new UIColor(0xff524C3D,0xff7C4E40,0xffF65828,0xffCAB4AE),
                new UIColor(0xff6AF96F,0xffA4F7A6,0xffF5DDA6,0xffD8CEB5),
                () -> System.out.println("CLICK!!!"));
    }

    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
        button2.click();
        if(gameContainer.getInput().isButtonDown(MouseEvent.BUTTON1)){
            SceneConrainer.CURRENT_SCENE = "2";
            System.out.println("CLICK");
        }
    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {
        circle.drawShape(30,30,30,30,0xffA4F7A6);
        button2.drawButton();
    }
}
