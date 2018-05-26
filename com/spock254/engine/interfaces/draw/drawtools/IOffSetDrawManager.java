package com.spock254.engine.interfaces.draw.drawtools;

import com.spock254.engine.interfaces.draw.DrawingImage;

public interface IOffSetDrawManager {

    public int getOffX();
    public void setOffX(int offX);
    public int getOffY();
    public void setOffY(int offY);
    public DrawingImage getDrawingImage();
    public void setDrawingImage(DrawingImage drawingImage);
}
