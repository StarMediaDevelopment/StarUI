package com.starmediadev.starui;

import com.starmediadev.starui.button.Button;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class UIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (!(e.getClickedInventory().getHolder() instanceof Menu menu)) {
            return;
        }
        if (e.getSlot() != e.getRawSlot()) {
            return;
        }
        Slot slot = menu.getSlot(e.getSlot());
        if (slot == null) {
            return;
        }
        Element element = slot.getElement();
        if (element == null || !slot.getElement().isAllowInsert()) {
            e.setCancelled(true);
        }
        
        if (element instanceof Button button) {
            button.playSound(player);
            if (e.isLeftClick()) {
                if (button.getLeftClickAction() != null) {
                    button.getLeftClickAction().onClick(player, menu, e.getClick());
                }
            } else if (e.isRightClick()) {
                if (button.getRightClickAction() != null) {
                    button.getRightClickAction().onClick(player, menu, e.getClick());
                }
            } else if (e.getClick() == ClickType.MIDDLE) {
                if (button.getMiddleClickAction() != null) {
                    button.getMiddleClickAction().onClick(player, menu, e.getClick());
                }
            }
        } else if (element instanceof InsertElement insertElement) {
            if (e.getAction().name().toLowerCase().contains("pickup_")) {
                insertElement.onRemove(player, menu);
            } else if (e.getAction().name().toLowerCase().contains("place_")) {
                if (insertElement.keepOnPageMove()) {
                    insertElement.setItemStack(e.getCursor());
                }
                insertElement.onInsert(player, menu, e.getCursor());
            }
        }
    }
}
