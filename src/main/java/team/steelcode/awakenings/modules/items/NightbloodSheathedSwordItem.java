package team.steelcode.awakenings.modules.items;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.neoforged.neoforge.common.Tags;
import team.steelcode.awakenings.modules.material.ModToolMaterial;
import team.steelcode.awakenings.setup.registries.ModItems;

import java.util.Set;

public class NightbloodSheathedSwordItem extends SwordItem {

    public NightbloodSheathedSwordItem(Properties properties) {
        super(ModToolMaterial.ALUMINUM, 1.0f, -3.5f, properties);
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

                ItemStack swordSheath = new ItemStack(ModItems.SWORD_SHEATH.get(), 1);

                ItemStack swordWithoutSheath = new ItemStack(ModItems.NIGHTBLOOD.get());


                for (Object2IntMap.Entry<Holder<Enchantment>> enchantment : actualSword.getTagEnchantments().entrySet()) {
                    swordWithoutSheath.enchant(enchantment.getKey(), enchantment.getIntValue());
                }

                if (!servPlayer.getInventory().add(swordSheath)) {
                    ItemEntity itemEntity = new ItemEntity(level,
                            servPlayer.getX(), servPlayer.getY() + 0.75, servPlayer.getZ(),
                            swordSheath);

                    level.addFreshEntity(itemEntity);
                }
                servPlayer.setItemInHand(hand, swordWithoutSheath);

                return InteractionResult.SUCCESS_SERVER;
            }

        }
        return super.use(level, player, hand);
    }
}
