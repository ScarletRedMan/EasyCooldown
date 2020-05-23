package ru.dragonestia.easycooldown.cooldown.player;

import cn.nukkit.Player;
import ru.dragonestia.easycooldown.EasyCooldown;
import ru.dragonestia.easycooldown.cooldown.PlayerCooldown;

import java.util.HashMap;

public class PlayerCooldownManager {

    private HashMap<String, PlayerCooldown> cooldowns = new HashMap<>();

    private Player player;

    private PlayerCooldownManager(Player player){
        this.player = player;
    }

    public HashMap<String, PlayerCooldown> getCooldowns(){
        return cooldowns;
    }

    public Player getPlayer() {
        return player;
    }

    public void addCooldown(String key, PlayerCooldown cooldown){
        cooldown.setManager(this);
        cooldowns.put(key.toLowerCase(), cooldown);
    }

    public boolean hasCooldown(String key){
        return cooldowns.containsKey(key.toLowerCase());
    }

    public void removeCooldown(String key){
        cooldowns.remove(key.toLowerCase());
    }

    public void removeCooldown(PlayerCooldown cooldown){
        String key = null;
        for(String targetKey: cooldowns.keySet()){
            if(cooldowns.get(targetKey).equals(cooldown)){
                key = targetKey;
                break;
            }
        }

        if(key == null) return;
        cooldowns.remove(key);
    }

    public PlayerCooldown getCooldown(String key){
        return cooldowns.getOrDefault(key.toLowerCase(), null);
    }

    public static void join(Player player){
        EasyCooldown.pcdm.put(player, new PlayerCooldownManager(player));
    }

    public void quit(){
        EasyCooldown.pcdm.remove(player);
    }

    public static PlayerCooldownManager get(Player player){
        return EasyCooldown.pcdm.get(player);
    }

    public void handleCooldowns(){
        new PlayerCooldownHandler(this).handle();
    }
}
