package team.steelcode.awakenings.setup.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.steelcode.awakenings.Awakenings;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Awakenings.MODID);


    public static final DeferredBlock<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .destroyTime(2.5f)
                    .requiresCorrectToolForDrops(),
            true);

    public static final DeferredBlock<Block> ALUMINUM_ORE = registerBlock("aluminum_ore",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                    .destroyTime(1.5f)
                    .requiresCorrectToolForDrops()
            ,
            true);


    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, Block> block, BlockBehaviour.Properties properties, boolean hasItem) {
        DeferredBlock<Block> deferredBlock = BLOCKS.registerBlock(name, block, properties);
        if (hasItem) {
            registerBlockItem(name, deferredBlock);
        }
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block, new Item.Properties());
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
