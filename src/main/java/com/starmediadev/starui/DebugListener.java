package com.starmediadev.starui;

import com.starmediadev.starui.handler.InventoryHandler;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

/**
 * Just a debug listener, ignore
 */
public class DebugListener implements Listener {
    
    private StarUI plugin;
    private GuiManager guiManager;
    
    public DebugListener(StarUI plugin) {
        this.plugin = plugin;
        guiManager = plugin.getServer().getServicesManager().getRegistration(GuiManager.class).getProvider();
    }
    
    private InventoryHandler getStarUIHandler(Inventory inventory) {
        return guiManager.getHandler(inventory);
    }
    
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        if (!plugin.isDebug()) {
            return;
        }
        plugin.getLogger().info("InventoryOpenEvent");
        printStarUIInfo(e.getInventory());
        plugin.getLogger().info("  Player: " + e.getPlayer().getName());
    }
    
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (!plugin.isDebug()) {
            return;
        }
        plugin.getLogger().info("InventoryCloseEvent");
        plugin.getLogger().info("  Player: " + e.getPlayer().getName());
        printStarUIInfo(e.getInventory());
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!plugin.isDebug()) {
            return;
        }
        plugin.getLogger().info("InventoryClickEvent");
        printStarUIInfo(e.getInventory());
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
        if (!plugin.isDebug()) {
            return;
        }
        plugin.getLogger().info("InventoryDragEvent");
        printStarUIInfo(e.getInventory());
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
        if (!plugin.isDebug()) {
            return;
        }
        plugin.getLogger().info("InventoryInteractEvent");
        printStarUIInfo(e.getInventory());
        plugin.getLogger().info("  Player: " + e.getWhoClicked().getName());
    }
    
    private void printStarUIInfo(Inventory inventory) {
        InventoryHandler handler = getStarUIHandler(inventory);
        plugin.getLogger().info("  StarUI Inventory: " + (handler != null));
        if (handler != null) {
            plugin.getLogger().info("  StarUI Handler Class: " + handler.getClass().getName());
        }
    }
}