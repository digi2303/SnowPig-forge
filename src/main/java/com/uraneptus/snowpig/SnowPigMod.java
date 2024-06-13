package com.uraneptus.snowpig;

import com.uraneptus.snowpig.common.entities.SnowPig;
import com.uraneptus.snowpig.core.data.client.SPItemModelProvider;
import com.uraneptus.snowpig.core.data.client.SPLangProvider;
import com.uraneptus.snowpig.core.data.client.SPSoundDefinitionsProvider;
import com.uraneptus.snowpig.core.data.server.SPRecipeProvider;
import com.uraneptus.snowpig.core.data.server.datapack_registries.SPBiomeModifiers;
import com.uraneptus.snowpig.core.data.server.datapack_registries.SPJukeboxSongProvider;
import com.uraneptus.snowpig.core.data.server.loot.SPLootTableProvider;
import com.uraneptus.snowpig.core.data.server.tags.SPBiomeTagsProvider;
import com.uraneptus.snowpig.core.data.server.tags.SPBlockTagsProvider;
import com.uraneptus.snowpig.core.data.server.tags.SPEntityTagsProvider;
import com.uraneptus.snowpig.core.data.server.tags.SPItemTagsProvider;
import com.uraneptus.snowpig.core.registry.SPAttachmentTypes;
import com.uraneptus.snowpig.core.registry.SPEntityTypes;
import com.uraneptus.snowpig.core.registry.SPItems;
import com.uraneptus.snowpig.core.registry.SPSounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(SnowPigMod.MOD_ID)
public class SnowPigMod {
    public static final String MOD_ID = "snowpig";
    private static final RegistrySetBuilder SET_BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, SPBiomeModifiers::create)
            .add(Registries.JUKEBOX_SONG, SPJukeboxSongProvider::create);

    public static ResourceLocation modPrefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(SnowPigMod.MOD_ID, path);
    }

    public SnowPigMod(IEventBus bus) {
        bus.addListener(this::gatherData);

        SPSounds.SOUNDS.register(bus);
        SPItems.ITEMS.register(bus);
        SPEntityTypes.ENTITY_TYPES.register(bus);
        SPAttachmentTypes.ATTACHMENT_TYPES.register(bus);
    }

    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new SPItemModelProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new SPSoundDefinitionsProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new SPLangProvider(packOutput));

        SPBlockTagsProvider blockTagProvider = new SPBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagProvider);
        generator.addProvider(includeServer, new SPItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new SPEntityTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new SPBiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new SPLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new SPRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, SET_BUILDER, Set.of(MOD_ID)));
    }

}
