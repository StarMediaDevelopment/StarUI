package com.starmediadev.starui;

import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class UIManager implements Listener {
    private JavaPlugin plugin;
    private Map<Inventory, InventoryHandler> activeInventories = new HashMap<>();
    
    public UIManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> activeInventories.entrySet().removeIf(entry -> entry.getKey().getViewers().isEmpty()), 1L, 12000);
    }
    
    public JavaPlugin getPlugin() {
        return plugin;
    }
    
    public void registerInventory(Inventory inventory, InventoryHandler handler) {
        activeInventories.put(inventory, handler);
    }
    
    public void unregisterInventory(Inventory inventory) {
        activeInventories.remove(inventory);
    }
    
    public Map<Inventory, InventoryHandler> getActiveInventories() {
        return new HashMap<>(activeInventories);
    }
    
    @EventHandler
    public void onInteract(InventoryInteractEvent e) {
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getInventory().equals(inv)) {
                handler.onInteract(e);
            }
        });
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getInventory().equals(inv)) {
                handler.onClick(e);
            }
        });
    }
    
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getInventory().equals(inv)) {
                handler.onOpen(e);
            }
        });
    }
    
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        this.activeInventories.remove(e.getInventory());
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getInventory().equals(inv)) {
                handler.onClose(e);
            }
        });
    }
    
    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getInventory().equals(inv)) {
                handler.onDrag(e);
            }
        });
    }
    
    @EventHandler
    public void onMove(InventoryMoveItemEvent e) {
        getActiveInventories().forEach((inv, handler) -> {
            if (e.getSource().equals(inv) || e.getDestination().equals(inv)) {
                handler.onMove(e);
            }
        });
    }
}