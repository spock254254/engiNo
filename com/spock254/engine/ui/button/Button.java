package com.spock254.engine.ui.button;

import com.spock254.engine.GameContainer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;

public class Button extends BasicButton {

    private int hoverColor;
    private int initColor = super.getButtonColor();

    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor, String buttonText, int textOffX, int textOffY, int textColor,
                  int hoverColor) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, buttonColor, buttonText, textOffX, textOffY, textColor);
        this.hoverColor = hoverColor;
    }

    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor, String buttonText, int textColor,
                  int hoverColor) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, buttonColor, buttonText, textColor);
        this.hoverColor = hoverColor;
    }

    @Override
    public void drawButton() {
        super.drawButton();

        if(super.getButtonOffX() <= super.getGameContainer().getInput().getMouseX()
                && (super.getButtonOffX()+super.getButtonW()) >= super.getGameContainer().getInput().getMouseX()
                && super.getButtonOffY() <= super.getGameContainer().getInput().getMouseY()
                && (super.getButtonOffY() + super.getButtonH() >= super.getGameContainer().getInput().getMouseY())){
            super.setButtonColor(this.hoverColor);
        }else {
            super.setButtonColor(initColor);
        }



    }
}
