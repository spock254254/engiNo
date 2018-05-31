package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.CircleFillDraw;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.IUIObject;
import com.spock254.engine.ui.ColorTable;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.slider.Sliedr;

public class Scene1 extends AbstractGame {

    IUIObject slider;
    IDrawingShape line;
    IDrawingShape button;


    @Override
    public void setUp(Kernel kernel) {

        line = new RectFilledDraw(kernel);
        button = new CircleFillDraw(kernel);

        slider = new Sliedr(kernel,line,button,50,50,50,
                new UIColor(ColorTable.darkred),new UIColor(ColorTable.firebrick),() -> System.out.println("Slide..."));
    }

    @Override
    public void update(Kernel kernel, float deltaTime) {
        slider.action();
    }

    @Override
    public void render(Kernel kernel, Renderer renderer) {
        slider.draw();
    }
}
