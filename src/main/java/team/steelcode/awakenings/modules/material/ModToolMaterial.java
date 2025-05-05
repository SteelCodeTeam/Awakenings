package team.steelcode.awakenings.modules.material;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterial {

    public static final ToolMaterial NETHERITE_INVESTED = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1,
            -4.0f,
            10f,
            15,
            ItemTags.NETHERITE_TOOL_MATERIALS);

    public static final ToolMaterial ALUMINUM = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            1,
            -4.0f,
            1.5f,
            15,
            ItemTags.IRON_TOOL_MATERIALS);
}
