package com.spock254.engine.ui.button;

import com.spock254.engine.GameContainer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.ui.UIColor;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Button extends BasicButton {


    private UIColor textColor;
    private UIColor btnColor;
    private int initBtnColor;
    private int initTextColor;



    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText, int textOffX, int textOffY,
                  UIColor textColor,UIColor btnColor) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textOffX, textOffY, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
    }

    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText,
                  UIColor textColor,UIColor btnColor) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
    }


    @Override
    public void drawButton() {
        super.drawButton();

        //if(this.isBtnCliced(0)){
        //    System.out.println("Click!");
        //    super.setButtonColor(this.btnColor.getActiveColor());
        //    super.setTextColor(this.textColor.getActiveColor());

        //}
        if(this.isHover()){
            super.setButtonColor(this.btnColor.getHoverColor());
            super.setTextColor(this.textColor.getHoverColor());
            if(isBtnCliced(0)){
                System.out.println("Click");
                super.setButtonColor(this.btnColor.getActiveColor());
                super.setTextColor(this.textColor.getActiveColor());
                // TODO add deligate 
            }
        }else {
            super.setButtonColor(initBtnColor);
            super.setTextColor(initTextColor);
        }
    }
    public boolean isHover(){
        return (super.getButtonOffX() <= super.getGameContainer().getInput().getMouseX()
                && (super.getButtonOffX()+super.getButtonW()) >= super.getGameContainer().getInput().getMouseX()
                && super.getButtonOffY() <= super.getGameContainer().getInput().getMouseY()
                && (super.getButtonOffY() + super.getButtonH() >= super.getGameContainer().getInput().getMouseY()));
    }
    public boolean isBtnCliced(int keyCode){ // TODO : make set up for key event
        return (super.getGameContainer().getInput().isButton(MouseEvent.BUTTON1));
    }

}
