package base;

import base.listeners.ClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginBase extends JavaPlugin {

    public static PluginBase INSTANCE;

    @Override
    public void onEnable() {
        //Register Events

        //Register Listeners
        new ClickListener(this);
    }

    @Override
    public void onLoad() {
        INSTANCE = this;
    }

}
