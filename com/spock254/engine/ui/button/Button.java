package com.spock254.engine.ui.button;

import com.spock254.engine.GameContainer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.ButtonClickFunck;
import com.spock254.engine.interfaces.ui.button.IButton;
import com.spock254.engine.ui.UIColor;

import java.awt.event.MouseEvent;

public class Button extends BasicButton implements IButton {


    private UIColor textColor;
    private UIColor btnColor;
    private int initBtnColor;
    private int initTextColor;

    private ButtonClickFunck buttonButtonClickFunck;


    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText, int textOffX, int textOffY,
                  UIColor textColor,UIColor btnColor,ButtonClickFunck buttonButtonClickFunck) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textOffX, textOffY, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
        this.buttonButtonClickFunck = buttonButtonClickFunck;
    }

    public Button(GameContainer gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText,
                  UIColor textColor,UIColor btnColor,ButtonClickFunck buttonButtonClickFunck) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
        this.buttonButtonClickFunck = buttonButtonClickFunck;
    }

    public void setButtonButtonClickFunck(ButtonClickFunck buttonButtonClickFunck) {
        this.buttonButtonClickFunck = buttonButtonClickFunck;
    }

    public ButtonClickFunck getButtonButtonClickFunck() {
        return buttonButtonClickFunck;
    }

    @Override
    public void click(){
        if(isHover() && getGameContainer().getInput().isButtonUp(MouseEvent.BUTTON1))
            buttonButtonClickFunck.click();
    }

    @Override
    public void drawButton() {
        super.drawButton();

        if(this.isHover()){
            super.setButtonColor(this.btnColor.getHoverColor());
            super.setTextColor(this.textColor.getHoverColor());
            if(isBtnCliced(MouseEvent.BUTTON1)){
                //System.out.println("Click");
                super.setButtonColor(this.btnColor.getActiveColor());
                super.setTextColor(this.textColor.getActiveColor());
            }
            //System.out.println("START");

        }else {
            super.setButtonColor(initBtnColor);
            super.setTextColor(initTextColor);
        }
    }


    @Override
    public boolean isHover(){
        return (super.getButtonOffX() <= super.getGameContainer().getInput().getMouseX()
                && (super.getButtonOffX()+super.getButtonW()) >= super.getGameContainer().getInput().getMouseX()
                && super.getButtonOffY() <= super.getGameContainer().getInput().getMouseY()
                && (super.getButtonOffY() + super.getButtonH() >= super.getGameContainer().getInput().getMouseY()));
    }

    private boolean isBtnCliced(int code){
        return (super.getGameContainer().getInput().isButton(code));
    }

}
