package com.starmediadev.starui.button;

import com.starmediadev.starui.Element;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Button extends Element {
    
    protected ButtonAction leftClickAction, middleClickAction, rightClickAction;
    protected Sound clickSound; 
    
    public Button(ItemStack itemStack) {
        super(itemStack);
    }
    
    public Button(ItemStack itemStack, Sound sound) {
        super(itemStack);
        this.clickSound = sound;
    }
    
    public Button(ItemStack itemStack, int staticIndex) {
        super(itemStack, staticIndex);
    }
    
    public void playSound(Player player) {
        if (clickSound != null) {
            player.playSound(player.getLocation(), clickSound, 1F, 1F);
        }
    }
    
    public Button setLeftClickAction(ButtonAction leftClickAction) {
        this.leftClickAction = leftClickAction;
        return this;
    }
    
    public Button setRightClickAction(ButtonAction rightClickAction) {
        this.rightClickAction = rightClickAction;
        return this;
    }
    
    public ButtonAction getLeftClickAction() {
        return leftClickAction;
    }
    
    public ButtonAction getRightClickAction() {
        return rightClickAction;
    }
    
    public void setClickSound(Sound clickSound) {
        this.clickSound = clickSound;
    }
    
    public Sound getClickSound() {
        return clickSound;
    }
    
    public void setMiddleClickAction(ButtonAction middleClickAction) {
        this.middleClickAction = middleClickAction;
    }
    
    public ButtonAction getMiddleClickAction() {
        return middleClickAction;
    }
}
