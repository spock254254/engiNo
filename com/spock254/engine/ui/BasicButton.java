package com.spock254.engine.ui;

import com.spock254.engine.GameContainer;
import com.spock254.engine.draw.RectDraw;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;

public class BasicButton {

    private IDrawingShape shape;
    private IDrawingText text;
    private GameContainer gameContainer;
    private int buttonOffX;
    private int buttonOffY;
    private int buttonW;
    private int buttonH;
    private int buttonColor;
    private String buttonText;
    private int textOffX,textOffY;
    private int textColor;


    public BasicButton(GameContainer gc,IDrawingShape shape,IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH,int buttonColor,
                       String buttonText,int textOffX,int textOffY,int textColor) {
        this.gameContainer = gc;
        this.shape = shape;
        this.text = text;
        this.buttonOffX = buttonOffX;
        this.buttonOffY = buttonOffY;
        this.buttonW = buttonW;
        this.buttonH = buttonH;
        this.buttonColor = buttonColor;
        this.buttonText = buttonText;
        this.textOffX = textOffX;
        this.textOffY = textOffY;
        this.textColor = textColor;
    }
    public BasicButton(GameContainer gc,IDrawingShape shape,IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH,int buttonColor,
                       String buttonText,int textColor) {
        this.gameContainer = gc;
        this.shape = shape;
        this.text = text;
        this.buttonOffX = buttonOffX;
        this.buttonOffY = buttonOffY;
        this.buttonW = buttonW;
        this.buttonH = buttonH;
        this.buttonColor = buttonColor;
        this.buttonText = buttonText;
        //this.textOffX = text.getFont().getWidths() // TODO : get btn center and put text
        //this.textOffY = textOffY;
        this.textColor = textColor;
    }

    public void drawButton(){

        shape.drawShape(buttonOffX,buttonOffY,buttonW,buttonH,buttonColor);
        text.drawText(buttonText,textOffX,textOffY,textColor);
    }

}
