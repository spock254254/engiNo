package com.spock254.engine.draw.drawtools;

import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.draw.drawtools.IOffSetDrawManager;

public class OffSetDrawManager implements IOffSetDrawManager {

    private int offX,offY;
    private DrawingImage drawingImage;


    public OffSetDrawManager(DrawingImage drawingImage,int offX,int offY,int zDapth){
        this.drawingImage = drawingImage;
        this.offX = offX;
        this.offY = offY;
        this.drawingImage.setzDapth(zDapth);
    }
    @Override
    public int getOffX() {
        return offX;
    }
    @Override
    public void setOffX(int offX) {
        this.offX = offX;
    }
    @Override
    public int getOffY() {
        return offY;
    }
    @Override
    public void setOffY(int offY) {
        this.offY = offY;
    }
    @Override
    public DrawingImage getDrawingImage() {
        return drawingImage;
    }
    @Override
    public void setDrawingImage(DrawingImage drawingImage) {
        this.drawingImage = drawingImage;
    }
}
