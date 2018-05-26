package com.spock254.engine;

import com.spock254.engine.gfx.Font;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;
import com.spock254.engine.interfaces.Rendering;
import com.spock254.engine.interfaces.gfx.IImageRequest;

import java.awt.image.DataBufferInt;
import java.util.ArrayList;

public class Renderer implements Rendering {

    private final int MAX_ALPHA = 255;
    private Font font = Font.STANDART;

    protected ArrayList<IImageRequest> imageRequests = new ArrayList<>();
    protected boolean processing = false;


    private int pH,pW;
    private int[] p;
    private int[] zb;
    private  int zDapth = 0;


    public Renderer(GameContainer gc){
        pH = gc.getHeight();
        pW = gc.getWidth();
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
        zb = new int[p.length];
    }
    @Override
    public void clear(){
        for (int i = 0;i < p.length;i++){
            p[i] = 0;
            zb[i] = 0;
        }

    }

    @Override
    public void setPixel(int x,int y,int value){

        int alpha = ((value >> 24) & 0xff);

        if((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0)
            return;
        if(zb[x + y * pW] > zDapth)
            return;


        if(alpha == MAX_ALPHA){
            p[x + y * pW] = value; //set pix from two dem to one dem
        }else {

            int pixelColor = p[x + y * pW];

            int newRed = ((pixelColor >> 16) & 0xff) - (int)((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen = ((pixelColor >> 8) & 0xff) - (int)((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
            int newBlue = (pixelColor & 0xff) - (int)(((pixelColor & 0xff) - (value & 0xff)) * (alpha / 255f));

            p[x + y * pW] = (255 << 24 | newRed << 16 | newGreen << 8 | newBlue);
        }

    }

    @Override
    public void process(){

        processing = true;

        for(int i = 0; i < imageRequests.size(); i ++){

            IImageRequest ir = imageRequests.get(i);
            setzDapth(ir.getzDepth());
            //drawImage(ir.getOffX(),ir.getOffY()); // TODO : i think a problem is here

        }
        imageRequests.clear();
        processing = false;
    }
    /*
    //@Override
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
    //@Override
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
    //@Override

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

    //@Override
    public void drawRect(int offX,int offY,int width,int height,int color){
        for (int y = 0;y <= height;y++){

            setPixel(offX,y + offY,color);
            setPixel(offX + width,y + offY,color);
        }
        for (int x = 0;x <= width;x++){
            setPixel(x + offX,offY,color);
            setPixel(x + offX,offY + height,color);
        }

    }

    //@Override
    public void drawFilledRect(int offX, int offY, int width, int height, int color) {

        //TODO : don't draw far then screen position

        for (int y = 0;y <= height;y++)
            for (int x = 0;x <= width;x++)
                setPixel(x + offX,y + offY,color);
    }
    */
    @Override
    public int getpH() {
        return pH;
    }
    @Override
    public void setpH(int pH) {
        this.pH = pH;
    }
    @Override
    public int getpW() {
        return pW;
    }
    @Override
    public void setpW(int pW) {
        this.pW = pW;
    }
    @Override
    public int[] getP() {
        return p;
    }
    @Override
    public void setP(int[] p) {
        this.p = p;
    }
    @Override
    public int getzDapth() {
        return zDapth;
    }
    @Override
    public void setzDapth(int zDapth) {
        this.zDapth = zDapth;
    }

}
