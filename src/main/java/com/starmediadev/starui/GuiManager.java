package com.starmediadev.starui;

import com.starmediadev.starui.gui.InventoryGUI;
import com.starmediadev.starui.handler.InventoryHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class GuiManager implements Listener {
    public JavaPlugin plugin;
    private Map<Inventory, InventoryHandler> activeHandlers = new HashMap<>();
    
    public GuiManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public void setup() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    public void registerInventory(Inventory inventory, InventoryHandler handler) {
        this.activeHandlers.put(inventory, handler);
    }
    
    public void unregisterInventory(Inventory inventory) {
        this.activeHandlers.remove(inventory);
    }
    
    public boolean isRegisteredInventory(Inventory inventory) {
        return this.activeHandlers.containsKey(inventory);
    }
    
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        InventoryHandler handler = this.activeHandlers.get(e.getInventory());
        if (handler != null) {
            handler.onOpen(e);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onClose(InventoryCloseEvent e) {
        Inventory inventory = e.getInventory();
        InventoryHandler handler = this.activeHandlers.get(inventory);
        if (handler != null) {
            handler.onClose(e);
            this.unregisterInventory(inventory);
        }
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        InventoryHandler handler = this.activeHandlers.get(e.getInventory());
        if (handler != null) {
            handler.onClick(e);
        }
    }
    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        InventoryHandler handler = this.activeHandlers.get(e.getInventory());
        if (handler != null) {
            handler.onDrag(e);
        }
    }
    
    public InventoryHandler getHandler(Inventory inventory) {
        return this.activeHandlers.get(inventory);
    }
    
    public void openGUI(InventoryGUI gui, Player player) {
        Inventory inventory = gui.getInventory();
        this.activeHandlers.put(inventory, gui);
        player.openInventory(inventory);
    }
    
    public Map<Inventory, InventoryHandler> getActiveHandlers() {
        return new HashMap<>(this.activeHandlers);
    }
}