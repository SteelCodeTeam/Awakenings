package team.steelcode.awakenings.setup;

import net.neoforged.bus.api.IEventBus;
import team.steelcode.awakenings.data.ModAttributes;
import team.steelcode.awakenings.setup.registries.ModBlocks;
import team.steelcode.awakenings.setup.registries.ModCreativeTabs;
import team.steelcode.awakenings.setup.registries.ModItems;

public class ModRegisters {

    public static void register(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModAttributes.register(modEventBus);
    }
}
