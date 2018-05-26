package com.spock254.engine.audio;

import javafx.scene.media.AudioClip;

public class SoundClipBase {

    AudioClip audioClip;

    public SoundClipBase(String path){

        audioClip = new AudioClip(getClass().getResource(path).toString());

    }

    public void play(){ // test
        audioClip.play();
    }
}
