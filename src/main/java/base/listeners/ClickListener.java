package base.listeners;

import base.PluginBase;
import base.inventory.GuiManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ClickListener implements Listener {

    private PluginBase plugin;

    public ClickListener(PluginBase plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (GuiManager.inventories.containsKey(event.getInventory())) GuiManager.inventories.get(event.getInventory()).handleItemClick(event);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        GuiManager.inventories.remove(event.getInventory());
    }

}
