package net.steelcodeteam.awakenings.modules.logic.server.server_events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.steelcodeteam.awakenings.data.player.IInvestedPlayerData;
import net.steelcodeteam.awakenings.modules.error_handling.error_utils.PlayerException;
import net.steelcodeteam.awakenings.setup.network.ModNetwork;
import net.steelcodeteam.awakenings.utils.CapabilityUtils;

public class OnJoinWorldEvent {

    public static void joinWorld(ServerPlayer serverPlayer) {
        try {
            IInvestedPlayerData capability = CapabilityUtils.getCapability(serverPlayer);

            if (capability.getFirstLogin()) {
                capability.addQtyBreaths(1);
                capability.setFirstLogin(false);
            }

            ModNetwork.syncInvestedDataPacket(serverPlayer);


        } catch (PlayerException ex) {
            ex.printCompleteLog();
        }
    }
}
