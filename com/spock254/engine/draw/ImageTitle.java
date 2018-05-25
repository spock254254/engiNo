package com.spock254.engine.draw;

import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.gfx.ImageTile;
import com.spock254.engine.interfaces.draw.DrawingImageTitle;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageTile;

public class ImageTitle extends Renderer implements DrawingImageTitle {

    private IImageTile image;
    //private IImage baseImage;
    // TODO : implement interface correctly and use it like ctr arg
    public ImageTitle(GameContainer gc,IImageTile imageTile){
        super(gc);
        this.image = imageTile;
        //baseImage = (IImage) image;
    }

    public void drawImageTile(int offX, int offY, int tileX, int tileY){
        if(offX < -image.getTileW()) return;
        if(offY < -image.getTileH()) return;
        if(offX >= super.getpW()) return;
        if(offY >= super.getpH()) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();

        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX > super.getpW()) newWidth -= (newWidth + offX - super.getpW());// stop render out of screen x
        if(newHeight + offY > super.getpH()) newHeight -= (newHeight + offY - super.getpH());// stop render out of screen y


        for(int y = newX;y < newHeight;y++){
            for (int x = newY;x < newWidth;x++){
                setPixel(x + offX,y + offY,image.getPixels()[(x + tileX * image.getTileH())
                        + (y + tileY * image.getTileH()) * image.getWidth()]);
            }
        }
    }
}
