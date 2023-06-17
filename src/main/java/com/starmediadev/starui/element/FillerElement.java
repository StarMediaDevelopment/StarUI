package com.starmediadev.starui.element;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FillerElement extends Element {
    public FillerElement(Material material) {
        creator(player -> {
            ItemStack item = new ItemStack(material);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.WHITE.toString());
            item.setItemMeta(meta);
            return item;
        });
    }
}