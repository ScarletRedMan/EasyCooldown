package ru.dragonestia.easycooldown.elements;

import cn.nukkit.Player;

public interface TimeoutPlayerAction extends TimeoutAction {

    void execute(Player player);
}
