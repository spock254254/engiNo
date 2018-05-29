package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.CircleDraw;
import com.spock254.engine.draw.TextDraw;
import com.spock254.engine.gfx.Font;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.button.IButton;
import com.spock254.engine.scene.SceneConrainer;
import com.spock254.engine.ui.ColorTable;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.button.Button;

public class Scene1 extends AbstractGame {

    IDrawingShape circle;
    IButton button2;

    @Override
    public void setUp(Kernel kernel) {
        circle =  new CircleDraw(kernel);
        button2 = new Button(kernel,new CircleDraw(kernel),new TextDraw(kernel,new Font("/res/standart.png")),
                50,50,25,30,"Start",41,46,
                new UIColor(0xff524C3D,ColorTable.lightsalmon,0xffF65828,0xffCAB4AE),
                new UIColor(0xff6AF96F,0xffA4F7A6,0xffF5DDA6,0xffD8CEB5),
                () -> SceneConrainer.CURRENT_SCENE = "2");
    }

    @Override
    public void update(Kernel kernel, float deltaTime) {
        button2.click();
        //if(kernel.getInput().isButtonDown(MouseEvent.BUTTON1)){
        //    SceneConrainer.CURRENT_SCENE = "2";
        //    System.out.println("CLICK");
        //}
    }

    @Override
    public void render(Kernel kernel, Renderer renderer) {
        circle.drawShape(30,30,30,30,0xffA4F7A6);
        button2.drawButton();
    }
}
