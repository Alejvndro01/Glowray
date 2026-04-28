package com.alejvndro.glowray.client.render.renderer;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.model.LuciernagaAbisalModel;
import com.alejvndro.glowray.common.entity.LuciernagaAbisalEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class LuciernagaAbisalRenderer extends MobRenderer<LuciernagaAbisalEntity, LuciernagaAbisalModel<LuciernagaAbisalEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/luciernaga_abisal.png");
    private static final ResourceLocation GLOW_TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/luciernaga_abisal_glow.png");

    public LuciernagaAbisalRenderer(EntityRendererProvider.Context context) {
        super(context, new LuciernagaAbisalModel<>(context.bakeLayer(LuciernagaAbisalModel.LAYER_LOCATION)), 0.2F);
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(GLOW_TEXTURE);
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(LuciernagaAbisalEntity entity) {
        return TEXTURE;
    }
}
