package team.steelcode.awakenings.modules.items;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import team.steelcode.awakenings.data.ModAttributes;
import team.steelcode.awakenings.modules.material.ModToolMaterial;
import team.steelcode.awakenings.setup.registries.ModItems;


public class NightbloodSwordItem extends SwordItem {


    public NightbloodSwordItem(Properties properties) {
        super(ModToolMaterial.NETHERITE_INVESTED, 4.5f, -1.3f, properties);
    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide()) {
            if (player instanceof ServerPlayer servPlayer) {


                ItemStack actualSword = servPlayer.getItemInHand(hand);


                boolean hasSheath = false;
                int slotSheath = -1;

                for (int i = 0; i < servPlayer.getInventory().getContainerSize(); i++) {
                    ItemStack itemInSlot = servPlayer.getInventory().getItem(i);

                    if (itemInSlot.is(ModItems.SWORD_SHEATH.get())) {
                        hasSheath = true;
                        slotSheath = i;
                        break;
                    }
                }

                if (hasSheath) {

                    servPlayer.getInventory().removeItem(slotSheath, 1);

                    ItemStack swordSheathed = new ItemStack(ModItems.NIGHTBLOOD_SHEATHED.get(), 1);

                    for (Object2IntMap.Entry<Holder<Enchantment>> enchantment : actualSword.getTagEnchantments().entrySet()) {
                        swordSheathed.enchant(enchantment.getKey(), enchantment.getIntValue());
                    }

                    servPlayer.setItemInHand(hand, swordSheathed);

                    return InteractionResult.SUCCESS_SERVER;
                } else {
                    servPlayer.sendSystemMessage(
                            Component.translatable("msg.awakenings.nightblood_says")
                                    .append(Component.translatable("msg.awakenings.nightblood_sheath_not_found")));
                }

            }

        }
        return super.use(level, player, hand);
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (level.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getOffhandItem().is(stack.getItem()) || isSelected) {
                    generateParticles(entity, level);
                }
            } else {
                if (isSelected) {
                    generateParticles(entity, level);
                }
            }

        } else {
            if (entity instanceof ServerPlayer servPlayer) {
                if (entity.tickCount % 10 == 0) {
                    if (servPlayer.getAttributes().hasAttribute(ModAttributes.BREATHS)) {

                        double breaths = servPlayer.getAttribute(ModAttributes.BREATHS).getBaseValue();

                        if (breaths <= 0) {
                            servPlayer.addEffect(
                                    new MobEffectInstance(MobEffects.WITHER, 60, 3, true, true, true));
                        } else {
                            servPlayer.getAttribute(ModAttributes.BREATHS).setBaseValue(breaths - 1);
                        }
                    }
                }
            }
        }
    }

    private void generateParticles(Entity entity, Level level) {
        if (entity.tickCount % 3 == 0) {
            double x = entity.getX();
            double y = entity.getY() + entity.getBbHeight() / 2; // Altura del jugador
            double z = entity.getZ();

            for (int i = 0; i < 5; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 0.5;
                double offsetY = level.random.nextDouble() * 0.5;
                double offsetZ = (level.random.nextDouble() - 0.5) * 0.5;

                level.addParticle(
                        ParticleTypes.ASH,
                        x + offsetX,
                        y + offsetY,
                        z + offsetZ,
                        0, 0.1, 0
                );

                level.addParticle(
                        ParticleTypes.SQUID_INK,
                        x + offsetX,
                        y + offsetY-0.5,
                        z + offsetZ,
                        0, -0.1, 0
                );
            }
        }
    }
}
