package net.steelcodeteam.awakenings.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.steelcodeteam.awakenings.Awakenings;
import org.jetbrains.annotations.NotNull;

public class ModCreativeTab {

    public static CreativeModeTab AWK_TAB = new CreativeModeTab(Awakenings.MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.SADDLE);
        }
    };

}
