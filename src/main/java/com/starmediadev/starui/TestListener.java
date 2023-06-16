package com.starmediadev.starui;

import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TestListener implements Listener {
    
    private JavaPlugin plugin;
    
    public TestListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        plugin.getLogger().info("InventoryClickEvent");
        plugin.getLogger().info("  Player: " + e.getWhoClicked().getName());
        plugin.getLogger().info("  ClickType: " + e.getClick().name());
        plugin.getLogger().info("  Slot: " + e.getSlot());
        plugin.getLogger().info("  Raw Slot: " + e.getRawSlot());
        plugin.getLogger().info("  Action: " + e.getAction());
        ItemStack item = e.getCurrentItem();
        if (item != null) {
            plugin.getLogger().info("  Current Item Type:" + item.getType());
        } else {
            plugin.getLogger().info("  Current Item: null");
        }
    }
    
    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        plugin.getLogger().info("InventoryDragEvent");
        plugin.getLogger().info("  Player: " + e.getWhoClicked().getName());
        plugin.getLogger().info("  DragType: " + e.getType().name());
        ItemStack cursor = e.getCursor();
        if (cursor != null) {
            plugin.getLogger().info("  Cursor Item:" + cursor.getType());
        } else {
            plugin.getLogger().info("  Cursor Item: null");
        }
        plugin.getLogger().info("  Raw Slots: " + e.getRawSlots());
        plugin.getLogger().info("  Slots: " + e.getInventorySlots());
    }
    
    @EventHandler
    public void onInteract(InventoryInteractEvent e) {
        plugin.getLogger().info("InventoryInteractEvent");
        plugin.getLogger().info("  Player: " + e.getWhoClicked().getName());
    }
}