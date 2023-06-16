package com.starmediadev.starui;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;

public class StarUI extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new UIListener(), this);
        //getServer().getPluginManager().registerEvents(new TestListener(this), this);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("testui")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use that command.");
                return true;
            }
            
            player.openInventory(Bukkit.createInventory(null, 54, "Test"));
        }
        return true;
    }
}