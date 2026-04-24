package com.alejvndro.glowray.registry;

import com.alejvndro.glowray.Glowray;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Glowray.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GLOWRAY_TAB = CREATIVE_MODE_TABS.register("glowray_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GLOWRAY_TAB_ICON.get()))
                    .title(Component.translatable("creativetab.glowray_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STING_RAY_SPAWN_EGG.get());
                        output.accept(ModItems.GLOW_RABBIT_SPAWN_EGG.get());
                        output.accept(ModItems.SNAIL_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private ModCreativeTabs() {}
}