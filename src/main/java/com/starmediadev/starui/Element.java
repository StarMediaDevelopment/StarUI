package com.starmediadev.starui;

import org.bukkit.inventory.ItemStack;

public class Element {

    protected ItemStack itemStack;
    protected boolean isStatic;
    protected int staticIndex = -1;
    protected boolean allowInsert;
    protected boolean isReplaceable;
    
    public Element(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
    
    public Element(ItemStack itemStack, int staticIndex) {
        this.itemStack = itemStack;
        this.staticIndex = staticIndex;
        if (staticIndex > -1) {
            this.isStatic = true;
        }
    }
    
    public void setStaticIndex(int staticIndex) {
        this.staticIndex = staticIndex;
        this.isStatic = staticIndex > -1;
    }
    
    public boolean isReplaceable() {
        return isReplaceable;
    }
    
    public ItemStack getItemStack() {
        return itemStack;
    }
    
    public boolean isStatic() {
        return staticIndex > -1;
    }
    
    public int getStaticIndex() {
        return staticIndex;
    }
    
    public boolean isAllowInsert() {
        return allowInsert;
    }
    
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
    
    public void setAllowInsert(boolean allowInsert) {
        this.allowInsert = allowInsert;
    }
    
    public void setReplaceable(boolean replaceable) {
        isReplaceable = replaceable;
    }
    
    @Override
    public String toString() {
        return itemStack.getType().toString();
    }
}
