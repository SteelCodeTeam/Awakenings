package team.steelcode.awakenings;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderDefines;
import net.minecraft.client.renderer.ShaderProgram;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import team.steelcode.awakenings.modules.events.server_events.ModCreativeTabEvents;
import team.steelcode.awakenings.setup.ModRegisters;

import java.io.IOException;


@Mod(Awakenings.MODID)
public class Awakenings {
    public static final String MODID = "awakenings";


    public Awakenings(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModRegisters.register(modEventBus);

        modEventBus.addListener(ModCreativeTabEvents::addCustomItemsToCustomCreativeTab);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


            Minecraft minecraft = Minecraft.getInstance();
            ResourceManager resourceManager = minecraft.getResourceManager();

            // Carga el archivo del shader desde los recursos
            ShaderProgram exampleShader = new ShaderProgram(
                    ResourceLocation.fromNamespaceAndPath(MODID, "shader"),
                    DefaultVertexFormat.NEW_ENTITY, // Nombre del shader (ubicado en `assets/modid/shaders/post/example.json`)
                    ShaderDefines.EMPTY); // Usar el tipo de programa básico disponible

        }
    }
}
