package com.starmediadev.starui;

import com.starmediadev.plugins.starcore.lib.ColorUtils;
import com.starmediadev.starlib.collection.IncrementalMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

import java.util.*;
import java.util.stream.Stream;

public class Gui implements InventoryHandler {
    
    private UIManager uiManager;
    protected String title;
    protected int rows;
    protected GuiOptions options;
    protected IncrementalMap<Element> elements = new IncrementalMap<>();
    protected Map<Integer, Slot> slots = new HashMap<>();
    protected Inventory inventory;
    
    public Gui(UIManager uiManager, String title, int rows) {
        this(uiManager, title, rows, new GuiOptions());
    }
    
    public Gui(UIManager uiManager, String title, int rows, GuiOptions options) {
        this.uiManager = uiManager;
        this.title = title;
        this.rows = rows;
        this.options = options;
        
        if (rows > 6) {
            throw new IllegalArgumentException("Cannot have more than 6 rows in a GUI");
        }
        
        for (int i = 0; i < rows * 9; i++) {
            slots.put(i, new Slot(i));
        }
    }
    
    public void generateInventory() {
        inventory = Bukkit.createInventory(null, slots.size(), ColorUtils.color(title));
    }
    
    public void populateSlots() {
        this.slots.forEach((index, slot) -> slot.setElement(null));
        this.elements.forEach((slot, element) -> this.slots.get(slot).setElement(element));
    }
    
    public void refreshInventory() {
        if (inventory == null) {
            generateInventory();
        }
        populateSlots();
        new HashMap<>(slots).forEach((index, slot) -> inventory.setItem(index, slot.getElement().getItemStack()));
    }
    
    public void openInventory(Player player) {
        refreshInventory();
        player.openInventory(inventory);
    }
    
    public void addElement(Element element) {
        this.elements.add(element);
    }
    
    public void removeElement(int index) {
        this.elements.remove(index);
    }
    
    public void setElement(int slot, Element element) {
        this.elements.put(slot, element);
    }
    
    public UIManager getUiManager() {
        return uiManager;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getRows() {
        return rows;
    }
    
    @Override
    public void onClick(InventoryClickEvent e) {
        if (e.getRawSlot() != e.getSlot()) {
            e.setCancelled(true);
            return;
        }
        
        if (!options.allowInsert()) {
            if (e.getClick() == ClickType.DROP || e.getClick() == ClickType.CONTROL_DROP) {
                e.setCancelled(true);
            }
        }
        
        if (!options.allowTake()) {
            if (Stream.of(ClickType.LEFT, ClickType.SHIFT_LEFT, ClickType.RIGHT, ClickType.SHIFT_RIGHT).anyMatch(clickType -> e.getClick() == clickType)) {
                e.setCancelled(true);
            }
        }
    }
    
    @Override
    public void onDrag(InventoryDragEvent e) {
        if (!options.allowDrag()) {
            e.setCancelled(true);
        }
    }
    
    @Override
    public void onMove(InventoryMoveItemEvent e) {
        if (!options.allowMove()) {
            e.setCancelled(true);
        }
    }
}