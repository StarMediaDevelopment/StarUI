package com.starmediadev.starui;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FillerElement extends Element {
    public FillerElement(Material material, int staticIndex) {
        super(buildItem(material), staticIndex);
        this.isReplaceable = true;
    }
    
    private static ItemStack buildItem(Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE.toString());
        item.setItemMeta(meta);
        return item;
    }
}
