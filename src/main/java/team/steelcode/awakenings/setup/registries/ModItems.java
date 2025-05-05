package team.steelcode.awakenings.setup.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.modules.items.NightbloodSheathedSwordItem;
import team.steelcode.awakenings.modules.items.NightbloodSwordItem;

public class ModItems {

    protected static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Awakenings.MODID);

    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerItem(
            "aluminum_ingot",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> ALUMINUM_RAW = ITEMS.registerItem(
            "aluminum_raw",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> ALUMINUM_NUGGET = ITEMS.registerItem(
            "aluminum_nugget",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<SwordItem> NIGHTBLOOD = ITEMS.registerItem(
            "nightblood",
            NightbloodSwordItem::new,
            new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    public static final DeferredItem<SwordItem> NIGHTBLOOD_SHEATHED = ITEMS.registerItem(
            "nightblood_sheathed",
            NightbloodSheathedSwordItem::new,
            new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));

    public static final DeferredItem<Item> SWORD_SHEATH =
            ITEMS.registerItem("sword_sheath", Item::new, new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON));

    public static final DeferredItem<Item> NETHERITE_PLATE =
            ITEMS.registerItem("netherite_plate", Item::new, new Item.Properties().fireResistant());

    public static final DeferredItem<Item> ALUMINUM_PLATE =
            ITEMS.registerItem("aluminum_plate", Item::new, new Item.Properties());


    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
