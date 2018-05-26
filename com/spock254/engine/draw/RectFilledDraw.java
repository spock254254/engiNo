package com.spock254.engine.draw;

import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;

public class RectFilledDraw extends Renderer implements IDrawingShape {

    public RectFilledDraw(GameContainer gc) {
        super(gc);
    }

    @Override
    public void drawShape(int offX,int offY,int width,int height,int color){
        //TODO : don't draw far then screen position

        for (int y = 0;y <= height;y++)
            for (int x = 0;x <= width;x++)
                super.setPixel(x + offX,y + offY,color);
    }

    @Override
    public int getZDapth() {
        return super.getzDapth();
    }

    @Override
    public void setZDapth(int zDapth) {
        super.setzDapth(zDapth);
    }
}
