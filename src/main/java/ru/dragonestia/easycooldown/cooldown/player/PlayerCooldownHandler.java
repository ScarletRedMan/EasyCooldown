package ru.dragonestia.easycooldown.cooldown.player;

import ru.dragonestia.easycooldown.cooldown.PlayerCooldown;

public class PlayerCooldownHandler {

    private PlayerCooldownManager manager;

    public PlayerCooldownHandler(PlayerCooldownManager manager){
        this.manager = manager;
    }

    public PlayerCooldownManager getPlayerCooldownManager() {
        return manager;
    }

    public void handle(){
        for(PlayerCooldown cooldown: manager.getCooldowns().values()){
            if(!cooldown.isOut()) continue;

            cooldown.close();
        }
    }
}
