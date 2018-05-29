package com.spock254.engine.interfaces.ui.button;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;

public interface IBasicButton {

    public IDrawingShape getShape();
    public void setShape(IDrawingShape shape);
    public IDrawingText getText();
    public void setText(IDrawingText text);
    public Kernel getKernel();
    public void setKernel(Kernel kernel);
    public int getButtonOffX();
    public void setButtonOffX(int buttonOffX);
    public int getButtonOffY();
    public void setButtonOffY(int buttonOffY);
    public int getButtonW();
    public void setButtonW(int buttonW);
    public int getButtonH();
    public void setButtonH(int buttonH);
    public int getButtonColor();
    public void setButtonColor(int buttonColor);
    public String getButtonText();
    public void setButtonText(String buttonText);
    public int getTextOffX();
    public void setTextOffX(int textOffX);
    public int getTextOffY();
    public void setTextOffY(int textOffY);
    public int getTextColor();
    public void setTextColor(int textColor);
}
