package com.spock254.engine.ui.button;

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
        this.textOffX = ((buttonW - text.getFont().getTextPixelWeight(buttonText)) / 2) + buttonOffX;
        this.textOffY = ((buttonH / 2) - (text.getFont().getTextPixelHeight(buttonText)) / 2) + buttonOffY; // TODO
        this.textColor = textColor;
    }

    public void drawButton(){

        shape.drawShape(buttonOffX,buttonOffY,buttonW,buttonH,buttonColor);
        text.drawText(buttonText,textOffX,textOffY,textColor);
       // if(this.buttonOffX >= gameContainer.getInput().getMouseX()
        //        && (this.buttonOffX + buttonW) <= gameContainer.getInput().getMouseX())

        //if(buttonOffX <= this.gameContainer.getInput().getMouseX()
        //        && (buttonOffX+buttonW) >= this.gameContainer.getInput().getMouseX())
        //    System.out.println("+");

        //System.out.println(buttonOffX + "  :  "+ this.gameContainer.getInput().getMouseX());
        //System.out.println(gameContainer.getInput().getMouseX()+" : "+gameContainer.getInput().getMouseY());

    }

    public IDrawingShape getShape() {
        return shape;
    }

    public void setShape(IDrawingShape shape) {
        this.shape = shape;
    }

    public IDrawingText getText() {
        return text;
    }

    public void setText(IDrawingText text) {
        this.text = text;
    }

    public GameContainer getGameContainer() {
        return gameContainer;
    }

    public void setGameContainer(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    public int getButtonOffX() {
        return buttonOffX;
    }

    public void setButtonOffX(int buttonOffX) {
        this.buttonOffX = buttonOffX;
    }

    public int getButtonOffY() {
        return buttonOffY;
    }

    public void setButtonOffY(int buttonOffY) {
        this.buttonOffY = buttonOffY;
    }

    public int getButtonW() {
        return buttonW;
    }

    public void setButtonW(int buttonW) {
        this.buttonW = buttonW;
    }

    public int getButtonH() {
        return buttonH;
    }

    public void setButtonH(int buttonH) {
        this.buttonH = buttonH;
    }

    public int getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public int getTextOffX() {
        return textOffX;
    }

    public void setTextOffX(int textOffX) {
        this.textOffX = textOffX;
    }

    public int getTextOffY() {
        return textOffY;
    }

    public void setTextOffY(int textOffY) {
        this.textOffY = textOffY;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
