package com.spock254.engine.draw;

import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.interfaces.gfx.IFont;

public class TextDrawI extends Renderer implements IDrawingText {

    private IFont font;

    public TextDrawI(GameContainer gameContainer, IFont font){
        super(gameContainer);
        this.font = font;
    }

    @Override
    public void drawText(String text,int offX,int offY,int color){

        Image fontImage = font.getFontImage();
        text = text.toUpperCase();
        int offset = 0;

        for(int i = 0; i < text.length();i++){
            int unicode = text.codePointAt(i) - 32;

            for(int y = 0;y < fontImage.getHeight();y++){
                for (int x = 0;x < font.getWidths()[unicode];x++){
                    if(font.getFontImage().getPixels()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getWidth()] == 0xffffffff){
                        setPixel(x + offX + offset,y+offY,color);
                    }
                }
            }
            offset += font.getWidths()[unicode];
        }

    }

}