package com.spock254.engine.anim;

import com.spock254.engine.GameContainer;
import com.spock254.engine.draw.ImageTitleDraw;
import com.spock254.engine.interfaces.gfx.IImageTile;

public class Animation extends ImageTitleDraw {

    private int counter = 0;
    private int animSpeed;
    private int animoffX, animoffY;
    private int line,row;

    public Animation(GameContainer gc, IImageTile imageTile,int animSpeed,int animoffX,int animoffY,int line,int row) {
        super(gc, imageTile);
        this.animSpeed = animSpeed;
        this.animoffX = animoffX;
        this.animoffY = animoffY;
        this.line = line;
        this.row = row;
    }

    public void startAnim(int frames){


        if(frames % animSpeed == 0){
            counter++;
        }if(counter > row)
            counter = 0;
        //if (t > 500)
        //    t = 0;
        System.out.println(frames+" : "+ counter);
        super.drawImageTile(animoffX,animoffY,counter,1);
    }

    public int getAnimoffX() {
        return animoffX;
    }

    public void setAnimoffX(int animoffX) {
        this.animoffX = animoffX;
    }

    public int getAnimoffY() {
        return animoffY;
    }

    public void setAnimoffY(int animoffY) {
        this.animoffY = animoffY;
    }
}
