package com.spock254.engine;

public class GameContainer implements Runnable{

    private Thread tread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame abstractGame;

    private boolean isRunning = false;
    private final double UPDATE_CAP = 1.0/60.0;
    private int width = 320;//(int)ScreenSize.getSizeScreen().getWidth();
    private int height = 240;//(int)ScreenSize.getSizeScreen().getHeight();
    private float scale = 2f;
    private String title = "engineNo";
    private int fps;

    public GameContainer(){}

    public GameContainer(AbstractGame abstractGame)
    {
        this.abstractGame = abstractGame;
    }

    public void start(){
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        abstractGame.setUp(this);

        tread = new Thread(this);
        tread.run();
    }

    public void stop(){

    }


    @Override
    public void run() {

        isRunning = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        fps = 0;

        while (isRunning){
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP){

                unprocessedTime -= UPDATE_CAP;
                render = true;

                //abstract game
                abstractGame.update(this,(float)UPDATE_CAP);
                input.update();



                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    //System.out.println("FPS : "+fps);
                }
            }
            if(render)
            {
                renderer.clear();
                abstractGame.render(this,renderer);
                //renderer.drawText("FPS : "+fps,0,0,0xff00ffff); //TODO : fix drawText class
                window.update();
                frames++;
            }else {
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose(){

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }

    public int getFps(){ return fps; }
}
