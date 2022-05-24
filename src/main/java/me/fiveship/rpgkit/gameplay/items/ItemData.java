package me.fiveship.rpgkit.gameplay.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ItemData {

    @Getter
    @Setter
    @JsonProperty("ID")
    private String id;

    @Getter
    @Setter
    @JsonProperty("ItemModel")
    private ItemModel model = new ItemModel();

}
