package team.steelcode.awakenings.modules.events.server_events;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import team.steelcode.awakenings.setup.registries.ModBlocks;
import team.steelcode.awakenings.setup.registries.ModCreativeTabs;
import team.steelcode.awakenings.setup.registries.ModItems;

public class ModCreativeTabEvents {

    public static void addCustomItemsToCustomCreativeTab(BuildCreativeModeTabContentsEvent event) {

        if (event.getTab() == ModCreativeTabs.AWAKENINGS_TAB.get()) {
            event.accept(ModItems.ALUMINUM_NUGGET.get());
            event.accept(ModItems.ALUMINUM_INGOT.get());
            event.accept(ModItems.ALUMINUM_RAW.get());
            event.accept(ModBlocks.ALUMINUM_ORE.asItem());
            event.accept(ModBlocks.ALUMINUM_BLOCK.asItem());
            event.accept(ModItems.ALUMINUM_PLATE.get());
            event.accept(ModItems.NETHERITE_PLATE.get());
            event.accept(ModItems.NIGHTBLOOD.get());
            event.accept(ModItems.NIGHTBLOOD_SHEATHED.get());
            event.accept(ModItems.SWORD_SHEATH.get());
        }
    }

    public static void addCustomItemsToMinecraftCreativeTab(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(ModItems.ALUMINUM_NUGGET.get());
            event.accept(ModItems.ALUMINUM_INGOT.get());
            event.accept(ModItems.ALUMINUM_RAW.get());
            event.accept(ModBlocks.ALUMINUM_BLOCK.asItem());
        }
    }
}
