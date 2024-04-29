package com.uraneptus.snowpig.core.registry;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.common.entities.SnowPig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SPEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SnowPigMod.MOD_ID);

    public static final Supplier<EntityType<SnowPig>> SNOW_PIG = ENTITY_TYPES.register("snow_pig",
            () -> EntityType.Builder.of(SnowPig::new, MobCategory.CREATURE)
                    .sized(0.9f,0.9f)
                    .clientTrackingRange(10)
                    .build(SnowPigMod.modPrefix("snow_pig").toString()));
}
