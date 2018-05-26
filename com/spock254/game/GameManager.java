package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.anim.Animation;
import com.spock254.engine.draw.RectDraw;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.order.OrderDrawShape;
import com.spock254.engine.draw.order.OrderImageContainer;
import com.spock254.engine.draw.order.OrderShapeContainer;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingImage;
import com.spock254.engine.interfaces.draw.IDrawingImageTitle;
import com.spock254.engine.interfaces.draw.order.IOrderDrawShape;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageTile;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    IImageTile imageTile;
    IDrawingImageTitle IDrawingImageTitle;

    IImage image;
    IImage image2;
    IImage image3;
    IDrawingImage IDrawingImage;
    IDrawingImage IDrawingImage2;
    OrderImageContainer orderImageContainer;

    IDrawingShape filledRect;
    IDrawingShape rect;

    OrderShapeContainer shapeContainer;

    IOrderDrawShape drawShape1;
    IOrderDrawShape drawShape2;

    Animation animation;

    public GameManager(){

        //image = new Image("/res/Untitled.png");
        //image2 = new Image("/res/hart.png");
        //image3 = new Image("/res/standart.png");

    }

    @Override
    public void setUp(GameContainer gameContainer) {
        animation = new Animation(gameContainer,new ImageTile("/res/images.png",25,25)
                ,10,10,10,1,9);

    }

int i = 0;
    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
        i++;
        if(i > 1000)
            i = 0;
    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {
       // System.out.println(i);
        animation.startAnim(i);

    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
