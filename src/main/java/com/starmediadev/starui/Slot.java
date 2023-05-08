package com.starmediadev.starui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * A utility class used to make it easier to manage the menus internally
 */
public class Slot {
    
    protected static final Element AIR_ELEMENT = new Element(new ItemStack(Material.AIR));
    
    protected final int index;
    protected Element element = AIR_ELEMENT;

    public Slot(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element == null ? AIR_ELEMENT : element;
    }
}
