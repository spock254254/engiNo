package com.spock254.engine.ui.button;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.button.IBasicButton;

public class BasicButton implements IBasicButton {

    private IDrawingShape shape;
    private IDrawingText text;
    private Kernel kernel;
    private int buttonOffX;
    private int buttonOffY;
    private int buttonW;
    private int buttonH;
    private int buttonColor;
    private String buttonText;
    private int textOffX,textOffY;
    private int textColor;


    public BasicButton(Kernel gc, IDrawingShape shape, IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor,
                       String buttonText, int textOffX, int textOffY, int textColor) {
        this.kernel = gc;
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
    public BasicButton(Kernel gc, IDrawingShape shape, IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor,
                       String buttonText, int textColor) {
        this.kernel = gc;
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
    }

    @Override
    public IDrawingShape getShape() {
        return shape;
    }
    @Override
    public void setShape(IDrawingShape shape) {
        this.shape = shape;
    }
    @Override
    public IDrawingText getText() {
        return text;
    }
    @Override
    public void setText(IDrawingText text) {
        this.text = text;
    }
    @Override
    public Kernel getKernel() {
        return kernel;
    }
    @Override
    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }
    @Override
    public int getButtonOffX() {
        return buttonOffX;
    }
    @Override
    public void setButtonOffX(int buttonOffX) {
        this.buttonOffX = buttonOffX;
    }
    @Override
    public int getButtonOffY() {
        return buttonOffY;
    }
    @Override
    public void setButtonOffY(int buttonOffY) {
        this.buttonOffY = buttonOffY;
    }
    @Override
    public int getButtonW() {
        return buttonW;
    }
    @Override
    public void setButtonW(int buttonW) {
        this.buttonW = buttonW;
    }
    @Override
    public int getButtonH() {
        return buttonH;
    }
    @Override
    public void setButtonH(int buttonH) {
        this.buttonH = buttonH;
    }
    @Override
    public int getButtonColor() {
        return buttonColor;
    }
    @Override
    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }
    @Override
    public String getButtonText() {
        return buttonText;
    }
    @Override
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
    @Override
    public int getTextOffX() {
        return textOffX;
    }
    @Override
    public void setTextOffX(int textOffX) {
        this.textOffX = textOffX;
    }
    @Override
    public int getTextOffY() {
        return textOffY;
    }
    @Override
    public void setTextOffY(int textOffY) {
        this.textOffY = textOffY;
    }
    @Override
    public int getTextColor() {
        return textColor;
    }
    @Override
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
