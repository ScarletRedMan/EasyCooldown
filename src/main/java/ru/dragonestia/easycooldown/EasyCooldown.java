package ru.dragonestia.easycooldown;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import ru.dragonestia.easycooldown.cooldown.PlayerCooldown;
import ru.dragonestia.easycooldown.cooldown.player.PlayerCooldownManager;
import ru.dragonestia.easycooldown.task.PlayersTask;

import java.util.HashMap;

public class EasyCooldown extends PluginBase implements Listener {

    public static HashMap<Player, PlayerCooldownManager> pcdm = new HashMap<>();


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getScheduler().scheduleRepeatingTask(new PlayersTask(this), 10);

        for(Player player: getServer().getOnlinePlayers().values()){
            PlayerCooldownManager.join(player);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();

        PlayerCooldownManager.join(player);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        PlayerCooldownManager manager = PlayerCooldownManager.get(player);
        if(manager == null) return;
        manager.quit();
    }
}
