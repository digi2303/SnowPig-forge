package com.uraneptus.snowpig.core.data.server.datapack_registries;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.core.registry.SPEntityTypes;
import com.uraneptus.snowpig.core.tags.SPBiomeTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class SPBiomeModifiers {

    public static void create(BootstrapContext<BiomeModifier> context) {
        register(context, "snow_pig", () -> addSingleSpawnModifier(context, SPBiomeTags.SNOWPIG_SPAWN_IN, SPEntityTypes.SNOW_PIG.get(), 20, 1, 4));
    }

    private static BiomeModifiers.AddSpawnsBiomeModifier addSingleSpawnModifier(BootstrapContext<BiomeModifier> context, TagKey<Biome> biomeTag, EntityType<?> entity, int weight, int minCount, int maxCount) {
        return BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(context.lookup(Registries.BIOME).getOrThrow(biomeTag), new MobSpawnSettings.SpawnerData(entity, weight, minCount, maxCount));
    }

    private static void register(BootstrapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.register(ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, SnowPigMod.modPrefix(name)), modifier.get());
    }
}