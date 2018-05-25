package com.spock254.engine.draw;

import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.DrawingRect;

public class Rect extends Renderer implements DrawingRect {

    public Rect(GameContainer gc) {
        super(gc);
    }


    @Override
    public void drawRect(int offX, int offY, int width, int height, int color) {
        for (int y = 0;y <= height;y++){

            super.setPixel(offX,y + offY,color);
            super.setPixel(offX + width,y + offY,color);
        }
        for (int x = 0;x <= width;x++){
            super.setPixel(x + offX,offY,color);
            super.setPixel(x + offX,offY + height,color);
        }
    }
}
