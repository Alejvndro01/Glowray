package com.alejvndro.glowray;

import com.alejvndro.glowray.common.registry.ModEntities;
import com.alejvndro.glowray.creativetab.ModCreativeTabs;
import com.alejvndro.glowray.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.alejvndro.glowray.common.world.ModSpawnPlacements;

@Mod(Glowray.MOD_ID)
public class Glowray {
    public static final String MOD_ID = "glowray";

    public Glowray() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registros (MOD bus)
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Nota: atributos ahora se registran en ModEntityAttributes (EventBusSubscriber)
    }
}