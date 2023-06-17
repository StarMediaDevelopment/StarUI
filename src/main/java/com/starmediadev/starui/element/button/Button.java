package com.starmediadev.starui.element.button;

import com.starmediadev.starui.element.Element;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class Button extends Element {
    
    protected Consumer<InventoryClickEvent> eventConsumer;
    protected Sound clickSound;
    protected float pitch;
    
    public Button consumer(Consumer<InventoryClickEvent> consumer) {
        this.eventConsumer = consumer;
        return this;
    }
    
    public Button clickSound(Sound sound, float pitch) {
        this.clickSound = sound;
        this.pitch = pitch;
        return this;
    }
    
    public Consumer<InventoryClickEvent> getEventConsumer() {
        return eventConsumer;
    }
    
    public void playSound(Player player) {
        if (clickSound != null) {
            player.playSound(player.getLocation(), clickSound, 1F, pitch);
        }
    }
}