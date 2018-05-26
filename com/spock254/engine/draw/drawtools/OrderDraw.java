package com.spock254.engine.draw.drawtools;

import com.spock254.engine.interfaces.draw.DrawingImage;
import com.spock254.engine.interfaces.gfx.IImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderDraw {

    private ArrayList<DrawingImage> images = new ArrayList<>();;

    public void OrderDraw(){

    }

    public void add(DrawingImage image){
        images.add(image);
    }
    public void sort(){
        Collections.sort(images, new Comparator<DrawingImage>(){
            public int compare(DrawingImage o1, DrawingImage o2){
                if(o1.getzDapth() == o2.getzDapth())
                    return 0;
                return o1.getzDapth() < o2.getzDapth() ? -1 : 1;
            }
        });
        for(DrawingImage drawingImage : images){
            System.out.println(drawingImage.getzDapth());
        }
    }
    //TODO : test draw
    public void draw(){
        for(DrawingImage drawingImage : images)
            drawingImage.drawImage(0,0);
    }
}
