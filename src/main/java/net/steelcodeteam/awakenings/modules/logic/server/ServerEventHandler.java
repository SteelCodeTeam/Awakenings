package net.steelcodeteam.awakenings.modules.logic.server;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.steelcodeteam.awakenings.modules.error_handling.error_utils.PlayerException;
import net.steelcodeteam.awakenings.modules.logic.server.server_events.OnJoinWorldEvent;

@Mod.EventBusSubscriber
public class ServerEventHandler {

    @SubscribeEvent
    public static void onJoinWorld(final PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer serverPlayer) {
                OnJoinWorldEvent.joinWorld(serverPlayer);
            }
        }
    }
}
