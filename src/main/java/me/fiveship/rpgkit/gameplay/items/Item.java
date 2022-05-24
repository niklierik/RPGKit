package me.fiveship.rpgkit.gameplay.items;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Item {

    @Getter
    @Setter
    private ItemData data = new ItemData();

    @Getter
    @Setter
    private UUID owner;

    @Getter
    @Setter
    private String customName;

}
