package com.spock254.engine.scene;

import com.spock254.engine.AbstractGame;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class SceneConrainer {

    public static String CURRENT_SCENE = "1";
    private Map<String,AbstractGame> scenes;

    public SceneConrainer(Map<String,AbstractGame> scenes){
        this.scenes = scenes;
    }
    public AbstractGame getScene(String scene){
        return scenes.get(scene);
    }
    public void addScene(String scene,AbstractGame abstractGame){
        scenes.put(scene,abstractGame);
    }

    public Map<String, AbstractGame> getScenes() {
        return scenes;
    }
}
