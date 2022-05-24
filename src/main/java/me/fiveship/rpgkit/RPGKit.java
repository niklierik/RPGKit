package me.fiveship.rpgkit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public final class RPGKit extends JavaPlugin {

    private static RPGKit kit;
    public static final ObjectMapper JSON = new ObjectMapper();

    @Override
    public void onEnable() {
        if (kit != null) {
            kit.onDisable();
        }
        kit = this;
    }

    @Override
    public void onDisable() {
    }

    @Nullable
    public static RPGKit plugin() {
        return kit;
    }

    @NotNull
    public static File dataFolder() {
        File f = null;
        if (kit == null) {
            f = new File(new File("plugins"), "RPGKit");
        } else {
            f = kit.getDataFolder();
        }
        f.mkdirs();
        return f;
    }

    @NotNull
    public static File langFolder() {
        var f = new File(dataFolder(), "Lang");
        f.mkdirs();
        return f;
    }
}
