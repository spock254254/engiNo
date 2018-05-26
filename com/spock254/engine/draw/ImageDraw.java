package com.spock254.engine.draw;

import com.spock254.engine.GameContainer;
import com.spock254.engine.Renderer;
import com.spock254.engine.gfx.ImageRequest;
import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;

import java.util.ArrayList;

public class ImageDraw extends Renderer implements DrawingImage {

    IImage image;
    //ArrayList<IImageRequest> imageRequests = new ArrayList<>();
    //private boolean processing = false;

    public ImageDraw(GameContainer gc, IImage image){
        super(gc);
        this.image = image;
    }
/*
    @Override
    public void process(){

        processing = true;

        for(int i = 0; i < imageRequests.size(); i ++){

            IImageRequest ir = imageRequests.get(i);
            super.setzDapth(ir.getzDepth());
            drawImage(ir.getOffX(),ir.getOffY()); // TODO : i think a problem is here
        }
        imageRequests.clear();
        processing = false;
    }
*/
    @Override
    public void drawImage(int offX, int offY) {

        if(image.isAlpha() && !super.processing){
            super.imageRequests.add(new ImageRequest(image,super.getzDapth(),offX,offY));
            return;
        }

        // don't render
        if(offX < -image.getWidth()) return;
        if(offY < -image.getHeight()) return;
        if(offX >= super.getpW()) return;
        if(offY >= super.getpH()) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX > super.getpW()) newWidth -= (newWidth + offX - super.getpW());// stop render out of screen x
        if(newHeight + offY > super.getpH()) newHeight -= (newHeight + offY - super.getpH());// stop render out of screen y


        for(int y = newX;y < newHeight;y++){
            for (int x = newY;x < newWidth;x++){
                setPixel(x + offX,y + offY,image.getPixels()[x + y * image.getWidth()]);
            }
        }
    }
}
