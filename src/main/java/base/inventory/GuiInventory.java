package base.inventory;

import base.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class GuiInventory {

    private Inventory inventory;
    private Player player;
    private HashMap<Integer, GuiItem> clickableItems = new HashMap<>();

    public GuiInventory(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }

    public void setSlot(int slot, GuiItem item) {
        this.inventory.setItem(slot, item.item);
        this.clickableItems.put(slot, item);
    }

    public void setBackground(Material material) {
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = new ItemStack(material, 1);
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatUtil.chat("&7"));
            item.setItemMeta(meta);
            setSlot(i, new GuiItem(new ItemStack(material, 1), this, event -> event.setCancelled(true)));
        }
    }

    public void handleItemClick(InventoryClickEvent event) {
        this.clickableItems.get(event.getSlot()).handleClick(event);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
