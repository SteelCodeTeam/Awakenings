package net.steelcodeteam.awakenings.setup.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.steelcodeteam.awakenings.Awakenings;
import net.steelcodeteam.awakenings.data.player.IInvestedPlayerData;

public class DataTagRegister {

        public static final Capability<IInvestedPlayerData> PLAYER_CAP = CapabilityManager.get(new CapabilityToken<IInvestedPlayerData>(){
            @Override
            public String toString() {
                return super.toString();
            }
        });

        public static final ResourceLocation IDENTIFIER = new ResourceLocation(Awakenings.MOD_ID, "awk_data");

        public static void register(final RegisterCapabilitiesEvent event) {
            event.register(IInvestedPlayerData.class);
        }


}
