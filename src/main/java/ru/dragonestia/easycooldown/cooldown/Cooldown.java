package ru.dragonestia.easycooldown.cooldown;

public abstract class Cooldown<T> implements ICooldown{

    protected long timeout;

    protected T action;

    public Cooldown(T action, double seconds){
        this.action = action;
        this.timeout = System.currentTimeMillis() + (long) (seconds * 1000);
    }

    public void addSeconds(int seconds){
        this.addSeconds((double) seconds);
    }

    public void addSeconds(double seconds){
        this.timeout += (long) (seconds * 1000);
    }

    public long getSecondsLeft(){
        return Math.max((timeout - System.currentTimeMillis()) / 1000L, 0);
    }

    public boolean isOut(){
        return timeout <= System.currentTimeMillis();
    }

    public T getAction(){
        return action;
    }
}
