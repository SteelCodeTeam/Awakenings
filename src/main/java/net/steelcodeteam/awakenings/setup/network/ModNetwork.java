package net.steelcodeteam.awakenings.setup.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.steelcodeteam.awakenings.Awakenings;
import net.steelcodeteam.awakenings.data.player.IInvestedPlayerData;
import net.steelcodeteam.awakenings.setup.network.packets.InvestedDataPacket;
import net.steelcodeteam.awakenings.setup.registries.DataTagRegister;

public class ModNetwork {

    private static final String VERSION = Awakenings.VERSION;

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Awakenings.MOD_ID, "network_tunnel"), () -> VERSION, VERSION::equals, VERSION::equals);

    private static int index = 0;

    private static int nextIndex() {
        return index++;
    }

    public static void registerPackets() {
        INSTANCE.registerMessage(nextIndex(), InvestedDataPacket.class, InvestedDataPacket::encode, InvestedDataPacket::decode, InvestedDataPacket::handle);
    }

    public static void sendTo(Object msg, PacketDistributor.PacketTarget target) {
        INSTANCE.send(target, msg);
    }
    public static void sync(Object msg, Player player) {
        sendTo(msg, PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player));
    }
    public static void syncInvestedDataPacket(IInvestedPlayerData capability, Player player) {
        sync(new InvestedDataPacket(capability, player), player);
    }
    public static void syncInvestedDataPacket(Player player) {
        player.getCapability(DataTagRegister.PLAYER_CAP).ifPresent(data -> syncInvestedDataPacket(data, player));
    }
}
