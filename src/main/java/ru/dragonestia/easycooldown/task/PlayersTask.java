package ru.dragonestia.easycooldown.task;

import cn.nukkit.scheduler.PluginTask;
import ru.dragonestia.easycooldown.EasyCooldown;
import ru.dragonestia.easycooldown.cooldown.player.PlayerCooldownManager;

public class PlayersTask extends PluginTask<EasyCooldown> {

    public PlayersTask(EasyCooldown owner) {
        super(owner);
    }

    @Override
    public void onRun(int i) {
        for(PlayerCooldownManager manager: EasyCooldown.pcdm.values()){
            manager.handleCooldowns();
        }
    }
}
