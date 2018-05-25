package com.spock254.engine;

public abstract class AbstractGame {

    public abstract void setUp(GameContainer gameContainer);
    public abstract void update(GameContainer gameContainer,float deltaTime);
    public abstract void render(GameContainer gameContainer,Renderer renderer);
}
