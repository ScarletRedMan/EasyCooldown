package ru.dragonestia.easycooldown.cooldown;

public interface ICooldown {

    void close();

    void closeAndDoNotExecute();

    void execute();
}
