package com.spock254.engine;

import com.spock254.engine.gfx.Font;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pH,pW;
    private int[] p;

    private Font font = Font.STANDART;

    public Renderer(GameContainer gc){
        pH = gc.getHeight();
        pW = gc.getWidth();
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();

    }
    public void clear(){
        for (int i = 0;i < p.length;i++){
            p[i] = 1;
        }

    }
    public void setPixel(int x,int y,int value){

        if((x < 0 || x >= pW || y < 0 || y >= pH) || value == 0xffff00ff){

            return;
        }

        p[x + y * pW] = value; //set pix from two dem to one dem
    }
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

    public void drawImage(Image image,int offX,int offY){

        if(offX < -image.getWidth()) return;
        if(offY < -image.getHeight()) return;
        if(offX >= pW) return;
        if(offY >= pH) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX > pW) newWidth -= (newWidth + offX - pW);// stop render out of screen x
        if(newHeight + offY > pH) newHeight -= (newHeight + offY - pH);// stop render out of screen y


        for(int y = newX;y < newHeight;y++){
            for (int x = newY;x < newWidth;x++){
                setPixel(x + offX,y + offY,image.getPixels()[x + y * image.getWidth()]);
            }
        }

    }
    public void  drawImageTile(ImageTile image,int offX,int offY,int tileX, int tileY){

        if(offX < -image.getTileW()) return;
        if(offY < -image.getTileH()) return;
        if(offX >= pW) return;
        if(offY >= pH) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();

        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX > pW) newWidth -= (newWidth + offX - pW);// stop render out of screen x
        if(newHeight + offY > pH) newHeight -= (newHeight + offY - pH);// stop render out of screen y


        for(int y = newX;y < newHeight;y++){
            for (int x = newY;x < newWidth;x++){
                setPixel(x + offX,y + offY,image.getPixels()[(x + tileX * image.getTileH())
                        + (y + tileY * image.getTileH()) * image.getWidth()]);
            }
        }

    }
}
