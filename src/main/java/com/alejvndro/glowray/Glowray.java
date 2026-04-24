package com.alejvndro.glowray;

import com.alejvndro.glowray.registry.ModCreativeTabs;
import com.alejvndro.glowray.registry.ModEntities;
import com.alejvndro.glowray.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Glowray.MOD_ID)
public class Glowray {
    public static final String MOD_ID = "glowray";

    public Glowray() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        // Atributos y spawn placements se registran via @EventBusSubscriber
    }
}