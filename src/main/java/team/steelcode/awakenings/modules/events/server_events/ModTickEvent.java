package team.steelcode.awakenings.modules.events.server_events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.ModAttributes;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = Awakenings.MODID)
public class ModTickEvent {

    @SubscribeEvent
    public static void onPlayerTickEvent(PlayerTickEvent.Post event) {

        if (!event.getEntity().level().isClientSide()) {

            if (event.getEntity().tickCount % 40 != 0) {
                return;
            }

            // CADA 2 SEGUNDOS
            if (event.getEntity().getAttribute(ModAttributes.BREATHS) != null) {
                double breaths = event.getEntity().getAttribute(ModAttributes.BREATHS).getBaseValue();


                if (breaths <= 0) {
                    event.getEntity().addEffect(
                            new MobEffectInstance(
                                    MobEffects.DIG_SLOWDOWN, 40, 0, false, false, false));
                    event.getEntity().addEffect(
                            new MobEffectInstance(
                                    MobEffects.HUNGER, 40, 0, true, true, true));
                    event.getEntity().addEffect(
                            new MobEffectInstance(
                                    MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, true, true));
                } else {
                    if (breaths >= 50 && breaths < 200) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DAMAGE_RESISTANCE, 40, 0, true, true, true));
                    } else if (breaths >= 200 && breaths < 600) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DAMAGE_RESISTANCE, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.LUCK, 40, 1, true, true, true));
                    } else if (breaths >= 600 && breaths < 1000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DAMAGE_RESISTANCE, 40, 1, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.LUCK, 40, 3, true, true, true));
                    } else if (breaths >= 1000 && breaths < 2000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 0, true, true, true));
                    } else if (breaths >= 2000 && breaths < 3500) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 1, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                    } else if (breaths >= 3500 && breaths < 5000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 1, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DIG_SPEED, 40, 0, true, true, true));
                    } else if (breaths >= 5000 && breaths < 10000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 2, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DIG_SPEED, 40, 0, true, true, true));
                    } else if (breaths >= 10000 && breaths < 20000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 3, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DIG_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.SATURATION, 40, 1, true, true, true));
                    } else if (breaths >= 20000 && breaths < 50000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 3, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DIG_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.SATURATION, 40, 1, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.FIRE_RESISTANCE, 40, 0, true, true, true));
                    } else if (breaths >= 50000) {
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.REGENERATION, 40, 3, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.MOVEMENT_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DIG_SPEED, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.SATURATION, 40, 1, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.FIRE_RESISTANCE, 40, 0, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DAMAGE_RESISTANCE, 40, 3, true, true, true));
                        event.getEntity().addEffect(
                                new MobEffectInstance(
                                        MobEffects.DAMAGE_BOOST, 40, 3, true, true, true));
                    }
                }
            }
        }
    }
}
