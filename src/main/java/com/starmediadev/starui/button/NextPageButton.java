package com.starmediadev.starui.button;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;

public class NextPageButton extends Button {
    
    public NextPageButton(ItemStack itemStack) {
        this(itemStack, -1);
    }
    
    public NextPageButton(ItemStack itemStack, int staticIndex) {
        super(itemStack, staticIndex);
        this.leftClickAction = (player, menu, click) -> {
            int totalPages = menu.getTotalPages();
            int currentPage = menu.getCurrentPage();

            if (currentPage == totalPages) {
                player.sendMessage(ChatColor.RED + "You are already at the last page.");
                return;
            }

            menu.setCurrentPage(++currentPage);
            Bukkit.getScheduler().runTaskLater(menu.getPlugin(), () -> player.openInventory(menu.getInventory()), 1L);
        };
    }
}
