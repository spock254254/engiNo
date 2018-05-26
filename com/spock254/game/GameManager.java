package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectDraw;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.order.OrderDrawShape;
import com.spock254.engine.draw.order.OrderImageContainer;
import com.spock254.engine.draw.order.OrderShapeContainer;
import com.spock254.engine.gfx.Image;
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
    public GameManager(){

        image = new Image("/res/Untitled.png");
        image2 = new Image("/res/hart.png");
        image3 = new Image("/res/standart.png");
        //image.setAlpha(true);
       // image = new Image("/res/thief_boy_drbl.png");
    }

    @Override
    public void setUp(GameContainer gameContainer) {

        filledRect = new RectFilledDraw(gameContainer);
        rect = new RectDraw(gameContainer);


        drawShape1 = new OrderDrawShape(filledRect,10,10,100,120,0xff121CAB,1);
        drawShape2 = new OrderDrawShape(rect,12,15,50,100,0xff37BFAD,2);

        shapeContainer = new OrderShapeContainer();
        shapeContainer.add(drawShape1);
        shapeContainer.add(drawShape2);
        shapeContainer.sort();

        /*orderImageContainer = new OrderImageContainer();
        IOrderDrawImage drawManager1 = new OrderDrawImage(new ImageDraw(gameContainer,image),20,20,3);
        IOrderDrawImage drawManager2 = new OrderDrawImage(new ImageDraw(gameContainer,image2),15,10,0);
        IOrderDrawImage drawManager3 = new OrderDrawImage(new ImageDraw(gameContainer,image3),10,15,1);
        orderImageContainer.add(drawManager1);
        orderImageContainer.add(drawManager2);
        orderImageContainer.add(drawManager3);
        orderImageContainer.sort();*/



    }

//int i = 0;
    @Override
    public void update(GameContainer gameContainer, float deltaTime) {
//        if(gameContainer.getInput().isKeyDown(KeyEvent.VK_A)) i++;

    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {


        //orderImageContainer.draw();
        //filledRect1.drawShape(10,10,100,150,0xff72F79A);
        //filledRect2.drawShape(10,10,150,50,0xffFF7A5F);
        //rect.drawShape(10,10,100,50,0xff72F79A);
        //filledRect.drawShape(15,5,50,50,0xffFF7A5F);
        shapeContainer.draw();
    }

    public static void main(String[] args){

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
