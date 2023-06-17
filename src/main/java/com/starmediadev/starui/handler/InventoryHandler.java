package com.starmediadev.starui.handler;

import org.bukkit.event.inventory.*;

public interface InventoryHandler {
    void onClick(InventoryClickEvent e);
    void onDrag(InventoryDragEvent e);
    void onOpen(InventoryOpenEvent e);
    void onClose(InventoryCloseEvent e);
}