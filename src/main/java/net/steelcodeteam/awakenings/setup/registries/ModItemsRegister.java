package net.steelcodeteam.awakenings.setup.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.steelcodeteam.awakenings.Awakenings;
import net.steelcodeteam.awakenings.setup.ModCreativeTab;

import java.util.function.Supplier;

public class ModItemsRegister {

    public static RegistryObject<Item> TEST;

    public static void register() {
        TEST = ModItemsRegister.registerItem("test", () -> new Item(new Item.Properties().tab(ModCreativeTab.AWK_TAB).stacksTo(16)));
    }

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Awakenings.ITEMS.register(name, itemSupplier);
    }

}
