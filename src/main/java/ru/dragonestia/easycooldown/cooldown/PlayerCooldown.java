package ru.dragonestia.easycooldown.cooldown;

import ru.dragonestia.easycooldown.cooldown.player.PlayerCooldownManager;
import ru.dragonestia.easycooldown.elements.TimeoutPlayerAction;

public class PlayerCooldown extends Cooldown<TimeoutPlayerAction> {

    public PlayerCooldown(TimeoutPlayerAction action, double seconds) {
        super(action, seconds);
    }

    private PlayerCooldownManager manager = null;

    public void close(PlayerCooldownManager manager) {
        this.manager = manager;
        close();
    }

    public void setManager(PlayerCooldownManager manager){
        this.manager = manager;
    }

    @Override
    public void close() {
        if(manager == null) return;

        manager.removeCooldown(this);
        execute();
    }

    @Override
    public void closeAndDoNotExecute(){
        if(manager == null) return;

        manager.removeCooldown(this);
    }

    @Override
    public void execute(){
        if(manager == null) return;

        action.execute(manager.getPlayer());
    }
}
