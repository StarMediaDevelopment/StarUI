package com.starmediadev.starui;

import com.starmediadev.plugins.starcore.metrics.Metrics;

public class UIMetrics {
    private Metrics metrics;
    
    public UIMetrics(StarUI plugin, int serviceId) {
        this.metrics = new Metrics(plugin, serviceId);
    }
    
    public void shutdown() {
        metrics.shutdown();
    }
}
