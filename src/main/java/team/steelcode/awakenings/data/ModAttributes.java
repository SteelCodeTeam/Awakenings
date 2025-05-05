package team.steelcode.awakenings.data;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.steelcode.awakenings.Awakenings;

public class ModAttributes {

    public static DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            BuiltInRegistries.ATTRIBUTE, Awakenings.MODID);

    public static final Holder<Attribute> BREATHS =
            ATTRIBUTES.register("breaths", () -> new RangedAttribute(
                    "attribute.name.breaths", 10, 0, 1_000_000).setSyncable(true));

    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
    }
}
