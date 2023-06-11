package com.starmediadev.starui.button;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;

public class PreviousPageButton extends Button {
    
    public PreviousPageButton(ItemStack itemStack) {
        this(itemStack, -1);
    }
    
    public PreviousPageButton(ItemStack itemStack, int staticIndex) {
        super(itemStack, staticIndex);
        this.leftClickAction = (player, menu, click) -> {
            int currentPage = menu.getCurrentPage();

            if (currentPage == 1) {
                player.sendMessage(ChatColor.RED + "You are already at the first page.");
                return;
            }

            menu.setCurrentPage(--currentPage);
            Bukkit.getScheduler().runTaskLater(menu.getPlugin(), () -> player.openInventory(menu.getInventory()), 1L);
        };
    }
}
