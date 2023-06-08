package com.starmediadev.starui;

import com.starmediadev.plugins.starcore.lib.ColorUtils;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {
    
    private UIManager uiManager;
    
    public TestCmd(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.color("&cOnly players can use that command."));
            return true;
        }
        
        if (!(args.length > 1)) {
            player.sendMessage(ColorUtils.color("&cYou do not have enough arguments."));
            return true;
        }
        
        String name = args[0];
        int rows;
        try {
            rows = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            player.sendMessage(ColorUtils.color("&cYou provided an invalid whole number."));
            return true;
        }
        
        if (rows > 6) {
            player.sendMessage(ColorUtils.color("&cYou cannot have more than 6 rows in a GUI."));
            return true;
        }
        
        GuiOptions options = new GuiOptions();
        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {
                if (args[i].startsWith("take:")) {
                    options.setAllowTake(Boolean.parseBoolean(args[i].split(":")[1]));
                } else if (args[i].startsWith("insert:")) {
                    options.setAllowInsert(Boolean.parseBoolean(args[i].split(":")[1]));
                } else if (args[i].startsWith("drag:")) {
                    options.setAllowDrag(Boolean.parseBoolean(args[i].split(":")[1]));
                } else if (args[i].startsWith("move:")) {
                    options.setAllowMove(Boolean.parseBoolean(args[i].split(":")[1]));
                }
            }
        }
        
        Gui gui = new Gui(uiManager, name, rows, options);
        //TODO populate
        gui.openInventory(player);
        return true;
    }
}