package com.spock254.engine.interfaces;

import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;

public interface Rendering {

    public void clear();
    public void setPixel(int x,int y,int value);
}
