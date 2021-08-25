package base.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiItem {

    public GuiInventory inventory;
    public ItemStack item;
    public ClickRunnable runnable;

    public GuiItem(ItemStack item, GuiInventory inventory) {
        this(item, inventory, null);
    }

    public GuiItem(ItemStack item, GuiInventory inventory, ClickRunnable runnable) {
        this.item = item;
        this.inventory = inventory;
        this.runnable = runnable;
    }

    public void handleClick(InventoryClickEvent event) {
        if (runnable != null) {
            runnable.run(event);
        }
    }

}
