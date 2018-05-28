package com.spock254.engine.interfaces.ui.button;

import com.spock254.engine.GameContainer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.ButtonClickFunck;

public interface IButton extends  IBasicButton{
    public void click();
    public void drawButton();
    public boolean isHover();
    public void setButtonClickFunck(ButtonClickFunck buttonClickFunck);
    public ButtonClickFunck getButtonClickFunck();
}
