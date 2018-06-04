package com.spock254.engine.audio;

import javafx.scene.media.AudioClip;

public class SoundClipBase {

    AudioClip audioClip;

    public SoundClipBase(String path){

        audioClip = new AudioClip(getClass().getResource(path).toString());

    }

    public void play(){
        audioClip.play();
    }

    public void setVolume(double volume){
        audioClip.setVolume(volume);
    }
    public void stop(){
        audioClip.stop();
    }
    public boolean isPlaying(){
        return audioClip.isPlaying();
    }
    //TODO temp
    public AudioClip getAudioClip(){return audioClip;}
}
