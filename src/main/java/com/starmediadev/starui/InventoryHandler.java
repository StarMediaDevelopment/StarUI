package com.starmediadev.starui;

import org.bukkit.event.inventory.*;

public interface InventoryHandler {
    default void onInteract(InventoryInteractEvent e) {}
    default void onClick(InventoryClickEvent e){}
    default void onOpen(InventoryOpenEvent e) {}
    default void onClose(InventoryCloseEvent e) {}
    default void onDrag(InventoryDragEvent e) {}
    default void onMove(InventoryMoveItemEvent e) {}
}
