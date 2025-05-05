package team.steelcode.awakenings.modules.events.server_events;

import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.ModAttributes;

@EventBusSubscriber(modid = Awakenings.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityAttributeModificationEvent {


    @SubscribeEvent
    public static void onEntityAttributeModificationEvent(EntityAttributeModificationEvent event) {
        if (!event.has(EntityType.PLAYER, ModAttributes.BREATHS)) {
            event.add(EntityType.PLAYER, ModAttributes.BREATHS);
        }
    }
}
