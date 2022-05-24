package me.fiveship.rpgkit.gameplay.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemModel {

    @Getter
    @Setter
    @JsonProperty("Material")
    private Material material = Material.STICK;

    @Getter
    @Setter
    private int damage = 0;

    public ItemModel() {
    }

    public ItemModel(Material m) {
        material = m;
    }

    public ItemModel(Material m, int dam) {
        material = m;
        damage = dam;
    }

    public ItemStack toStack() {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        if (meta instanceof Damageable d) {
            d.setDamage(damage);
        }
        stack.setItemMeta(meta);
        return stack;
    }

}
