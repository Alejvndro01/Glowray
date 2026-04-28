package com.alejvndro.glowray.registry;

import com.alejvndro.glowray.Glowray;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Glowray.MOD_ID);

    public static final RegistryObject<Item> STING_RAY_SPAWN_EGG = ITEMS.register("sting_ray_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.STING_RAY, 0x1B1B1B, 0x5C5C5C, new Item.Properties()));

    public static final RegistryObject<Item> GLOW_RABBIT_SPAWN_EGG = ITEMS.register("glow_rabbit_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GLOW_RABBIT, 0xEADBC8, 0xFFD84A, new Item.Properties()));

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNAIL, 0x7A5A3A, 0xC2A27A, new Item.Properties()));

    public static final RegistryObject<Item> LUCIERNAGA_ABISAL_SPAWN_EGG = ITEMS.register("luciernaga_abisal_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LUCIERNAGA_ABISAL, 0x1A1A2E, 0x00FF88, new Item.Properties()));

    public static final RegistryObject<Item> GLOWRAY_TAB_ICON = ITEMS.register("glowray_tab_icon",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private ModItems() {}
}