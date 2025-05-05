package team.steelcode.awakenings.modules.events.client_events;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.modules.gui.ModGuiBreathsOverlay;

@EventBusSubscriber(modid = Awakenings.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRegisterGuiLayerEvent {

    @SubscribeEvent
    public static void onRegisterGuiLayersEvent(RegisterGuiLayersEvent event) {
        event.registerAboveAll(ResourceLocation.fromNamespaceAndPath(
                Awakenings.MODID, "breaths_overlay"), new ModGuiBreathsOverlay());
    }
}
