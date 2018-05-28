package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.CircleDraw;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.scene.SceneConrainer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Scene2 extends AbstractGame {

    IDrawingShape circle;

    @Override
    public void setUp(GameContainer gameContainer) {
        circle =  new RectFilledDraw(gameContainer);
    }

    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
        if(gameContainer.getInput().isButtonDown(MouseEvent.BUTTON1)){
            SceneConrainer.CURRENT_SCENE = "1";
            System.out.println("CLICK");
        }
    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {
        circle.drawShape(70,70,30,30,0xffA4F7A6);
    }
}
