package com.starmediadev.starui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class StarUI extends JavaPlugin {
    
    private static UIManager uiManager;
    
    @Override
    public void onEnable() {
        uiManager = new UIManager(this);
        Bukkit.getServicesManager().register(UIManager.class, uiManager, this, ServicePriority.Normal);
        getCommand("testgui").setExecutor(new TestCmd(uiManager));
    }
    
    public static UIManager getUiManager() {
        return uiManager;
    }
}