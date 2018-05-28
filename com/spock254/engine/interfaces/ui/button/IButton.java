package com.spock254.engine.interfaces.ui.button;

import com.spock254.engine.interfaces.ui.ButtonClickFunck;

public interface IButton extends  IBasicButton{
    public void click();
    public void drawButton();
    public boolean isHover();
    public void setButtonButtonClickFunck(ButtonClickFunck buttonButtonClickFunck);
    public ButtonClickFunck getButtonButtonClickFunck();
}
