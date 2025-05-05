package team.steelcode.awakenings.modules.events.server_events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.ModAttributes;

@EventBusSubscriber(modid = Awakenings.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModLivingDeathEvent {

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {


        if (event.getEntity() == null) {
            return;
        }

        if (event.getEntity().level().isClientSide) {
            return;
        }

        if (event.getSource().getEntity() instanceof ServerPlayer source) {

            if (source.getAttribute(ModAttributes.BREATHS) != null) {
                double sourceBreaths = source.getAttribute(ModAttributes.BREATHS).getBaseValue();


                if (event.getEntity() instanceof Player target) {
                    if (target.getAttribute(ModAttributes.BREATHS) != null) {
                        double targetBreaths = target.getAttribute(ModAttributes.BREATHS).getBaseValue();

                        source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + ((int) targetBreaths / 2));
                    } else {
                        source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + 1);
                    }

                } else if (event.getEntity() instanceof EnderDragon) {
                    source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + 200);
                } else if (event.getEntity() instanceof WitherBoss) {
                    source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + 100);
                } else if (event.getEntity() instanceof Warden) {
                    source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + 150);
                } else if (event.getEntity() instanceof ArmorStand) {
                    source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths);
                } else {
                    source.getAttribute(ModAttributes.BREATHS).setBaseValue(sourceBreaths + 1);
                }
            } else {
                return;
            }
        }

        if (event.getEntity() instanceof ServerPlayer target) {
            double targetBreaths = target.getAttribute(ModAttributes.BREATHS).getBaseValue();

            if (event.getSource().getEntity() instanceof ServerPlayer) {
                target.getAttribute(ModAttributes.BREATHS).setBaseValue((int) targetBreaths / 2);

            } else if (event.getSource().getEntity() instanceof Mob) {
                target.getAttribute(ModAttributes.BREATHS).setBaseValue((int) targetBreaths - (targetBreaths / 10));
            } else {
                target.getAttribute(ModAttributes.BREATHS).setBaseValue((int) targetBreaths - 10);
            }
        }
    }
}
