package me.fiveship.rpgkit.localization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import me.fiveship.rpgkit.RPGKit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lang {

    private HashMap<String, String> strings = new HashMap<>();
    private HashMap<String, List<String>> lists = new HashMap<>();

    public static File langFileByID(String id) {
        return new File(RPGKit.langFolder(), id + ".json");
    }

    /**
     * Generates a Lang object from the Lang ID
     *
     * @param langID
     * @return
     */
    public static Lang generateFrom(String langID) {
        return generateFrom(langFileByID(langID));
    }

    @Nullable
    private static Lang generateFrom(File file) {
        try {
            if (!file.exists()) {
                var plugin = RPGKit.plugin();
                if (plugin != null) {
                    plugin.getLogger().warning("Langfile " + file.getName() + " does not exist.");
                } else {
                    System.err.println("Langfile " + file.getName() + " does not exist.");
                }
                return null;
            }
            Lang lang = new Lang();
            HashMap<String, Object> maps = RPGKit.JSON.readValue(file, new TypeReference<HashMap<String, Object>>() {
            });
            lang.add(null, maps);
            return lang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Adds the key-values from the HashMap to the Lang object so you can get them with the string(key) and list(key) method.
     *
     * @param path   The path that will be added to each key. If null or "" it will not be appended with this
     * @param values the values to be added to the lang file.
     */
    private void add(@Nullable String path, @NotNull HashMap<?, ?> values) {
        for (var entry : values.entrySet()) {
            if (entry.getKey() instanceof String key) {
                if (path != null && !path.isEmpty()) {
                    key = path + "." + key;
                }
                Object value = entry.getValue();
                if (value instanceof List list) {
                    List<String> l = new ArrayList<>();
                    for (var e : list) {
                        if (e instanceof String s) {
                            l.add(s);
                        }
                    }
                    lists.put(key, l);
                } else if (value instanceof Object[] array) {
                    List<String> l = new ArrayList<>();
                    for (var e : array) {
                        if (e instanceof String s) {
                            l.add(s);
                        }
                    }
                    lists.put(key, l);
                } else if (value instanceof HashMap map) {
                    add(key, map);
                } else {
                    strings.put(key, value.toString());
                }
            }
        }
    }

    private void printEverything() {
        for (var entry : strings.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        for (var entry : lists.entrySet()) {
            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue().toArray()));
        }
    }

}
