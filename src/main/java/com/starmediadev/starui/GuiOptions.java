package com.starmediadev.starui;

public class GuiOptions {
    private boolean allowTake;
    private boolean allowInsert;
    private boolean allowDrag;
    private boolean allowMove;
    private boolean allowDrop;
    
    public boolean allowTake() {
        return allowTake;
    }
    
    public GuiOptions setAllowTake(boolean allowTake) {
        this.allowTake = allowTake;
        return this;
    }
    
    public boolean allowInsert() {
        return allowInsert;
    }
    
    public GuiOptions setAllowInsert(boolean allowInsert) {
        this.allowInsert = allowInsert;
        return this;
    }
    
    public boolean allowDrag() {
        return allowDrag;
    }
    
    public GuiOptions setAllowDrag(boolean allowDrag) {
        this.allowDrag = allowDrag;
        return this;
    }
    
    public boolean allowMove() {
        return allowMove;
    }
    
    public GuiOptions setAllowMove(boolean allowMove) {
        this.allowMove = allowMove;
        return this;
    }
    
    public boolean allowDrop() {
        return allowDrop;
    }
    
    public GuiOptions setAllowDrop(boolean allowDrop) {
        this.allowDrop = allowDrop;
        return this;
    }
}