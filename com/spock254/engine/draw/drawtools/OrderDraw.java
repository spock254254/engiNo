package com.spock254.engine.draw.drawtools;

import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.draw.drawtools.IOffSetDrawManager;
import com.spock254.engine.interfaces.gfx.IImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderDraw {

    private ArrayList<IOffSetDrawManager> images = new ArrayList<>();

    public void OrderDraw(){

    }

    public void add(IOffSetDrawManager image){
        images.add(image);
    }

    public void sort(){
        Collections.sort(images, new Comparator<IOffSetDrawManager>(){
            public int compare(IOffSetDrawManager o1, IOffSetDrawManager o2){
                if(o1.getDrawingImage().getzDapth() == o2.getDrawingImage().getzDapth())
                    return 0;
                return o1.getDrawingImage().getzDapth() < o2.getDrawingImage().getzDapth() ? -1 : 1;
            }
        });

    }
    //TODO : test draw
    public void draw(){
        for(IOffSetDrawManager offSetDrawManager : images)
            offSetDrawManager.getDrawingImage().drawImage(offSetDrawManager.getOffX(),offSetDrawManager.getOffY());
    }
}
