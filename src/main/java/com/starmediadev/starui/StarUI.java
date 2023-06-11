package com.starmediadev.starui;

import org.bukkit.plugin.java.JavaPlugin;

public class StarUI extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new UIListener(), this);
    }
}