package com.starmediadev.starui.gui;

import com.starmediadev.starui.element.Element;
import com.starmediadev.starui.element.button.Button;
import com.starmediadev.starui.handler.InventoryHandler;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

import java.util.*;

public class InventoryGUI implements InventoryHandler {
    
    protected final Inventory inventory;
    protected final Map<Integer, Slot> slots = new TreeMap<>();
    private final int rows;
    
    public InventoryGUI(int rows, String title) {
        this.rows = rows;
        if (rows > 6) {
            throw new IllegalArgumentException("You can only have a total of 6 rows in a GUI. You have " + rows);
        }
        this.inventory = Bukkit.createInventory(null, rows * 9, ChatColor.translateAlternateColorCodes('&', title));
        for (int i = 0; i < rows * 9; i++) {
            slots.put(i, new Slot(i));
        }
    }
    
    public void setElement(int row, int column, Element element) {
        setSlotValue(row, column, element);
    }
    
    public void removeElement(int row, int column) {
        setSlotValue(row, column, null);
    }
    
    private void setSlotValue(int row, int column, Element value) {
        if (row < 0 || row >= this.rows) {
            throw new IllegalArgumentException("Invalid row value. Supports 0-" + (this.rows - 1));
        }
        
        if (column < 0 || column > 8) {
            throw new IllegalArgumentException("Invalid column value. Supports 0-8");
        }
        
        Slot slot = slots.get(row * 9 + column);
        slot.setElement(value);
    }
    
    public void decorate(Player player) {
        this.slots.forEach((index, slot) -> {
            if (slot.getElement() != null) {
                this.inventory.setItem(index, slot.getElement().getIconCreator().apply(player));
            } else {
                this.inventory.setItem(index, null);
            }
        });
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true); //TODO This will have to be changed when the InsertElement is implemented
        Slot slot = this.slots.get(e.getRawSlot());
        if (slot == null) {
            return;
        }
        
        if (slot.getElement() == null) {
            return;
        }
        
        if (slot.getElement() instanceof Button button) {
            if (button.getEventConsumer() != null) {
                button.getEventConsumer().accept(e);
                button.playSound((Player) e.getWhoClicked());
            }
        }
    }
    
    @Override
    public void onDrag(InventoryDragEvent e) {
        
    }
    
    @Override
    public void onOpen(InventoryOpenEvent e) {
        decorate((Player) e.getPlayer());
    }
    
    @Override
    public void onClose(InventoryCloseEvent e) {
        
    }
}
