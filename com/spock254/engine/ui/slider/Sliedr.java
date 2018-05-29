package com.spock254.engine.ui.slider;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.UIObjectFunction;
import com.spock254.engine.interfaces.ui.IUIObject;
import com.spock254.engine.ui.UIColor;

public class Sliedr extends BasicSlider implements IUIObject {

    private int sliderValue;
    private UIObjectFunction uiObjectFunction;

    public Sliedr(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                  int offXline, int offYline, int offXButton, int offYButton,
                  int lineW, int lineH, int buttonW, int buttonH,
                  UIColor sliderLineColor, UIColor sliderButtonColor,
                  UIObjectFunction uiObjectFunction) {

        super(kernel, sliderLine, sliderButton, offXline, offYline,
                offXButton, offYButton, lineW, lineH, buttonW,
                buttonH, sliderLineColor, sliderButtonColor);

        this.uiObjectFunction = uiObjectFunction;
    }

    public Sliedr(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                  int offXline, int offYline, int lineW,
                  UIColor sliderLineColor, UIColor sliderButtonColor,
                  UIObjectFunction uiObjectFunction) {
        super(kernel, sliderLine, sliderButton, offXline,
                offYline, lineW, sliderLineColor, sliderButtonColor);

        this.uiObjectFunction = uiObjectFunction;
    }


    @Override
    public void action() {

    }

    @Override
    public void draw() {
        super.drawBasicUI();

    }

    @Override
    public boolean isHover() {
        return false;
    }

    @Override
    public void setButtonUIObjectFunction(UIObjectFunction uiObjectFunction) {
        this.uiObjectFunction = uiObjectFunction;
    }

    @Override
    public UIObjectFunction getButtonUIObjectFunction() {
        return this.uiObjectFunction;
    }

    @Override
    public UIColor getBaseColor() {
        return super.getSliderLineColor();
    }

    @Override
    public void setBaseColor(UIColor color) {
        super.setSliderLineColor(color);
    }

    @Override
    public UIColor getUpperColor() {
        return super.getSliderButtonColor();
    }

    @Override
    public void setUpperColor(UIColor color) {
        super.setSliderButtonColor(color);
    }
}
