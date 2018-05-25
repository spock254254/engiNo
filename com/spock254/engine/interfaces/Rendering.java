package com.spock254.engine.interfaces;

import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;

public interface Rendering {

    void clear();
    void setPixel(int x,int y,int value);
    void drawText(String text,int offX,int offY,int color);
    void drawImage(Image image, int offX, int offY);
    void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY);
    void drawRect(int offX,int offY,int width,int height,int color);
    void drawFilledRect(int offX,int offY,int width,int height,int color);
}
