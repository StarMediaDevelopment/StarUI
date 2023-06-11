package com.starmediadev.starui.button;

import com.starmediadev.starui.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

@FunctionalInterface
public interface ButtonAction {
    void onClick(Player player, Menu menu, ClickType click);
}
