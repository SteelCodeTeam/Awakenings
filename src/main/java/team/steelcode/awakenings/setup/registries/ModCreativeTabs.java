package team.steelcode.awakenings.setup.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.steelcode.awakenings.Awakenings;

public class ModCreativeTabs {

    private static DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Awakenings.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AWAKENINGS_TAB =
            TABS.register("awakenings_tab",
                    () -> CreativeModeTab.builder()
                            .icon(Items.STICK::getDefaultInstance)
                            .title(Component.translatable("tab.awakenings.default"))
                            .build());

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}
