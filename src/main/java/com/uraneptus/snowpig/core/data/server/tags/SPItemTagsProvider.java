package com.uraneptus.snowpig.core.data.server.tags;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.core.registry.SPItems;
import com.uraneptus.snowpig.core.tags.SPItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SPItemTagsProvider extends ItemTagsProvider {

    public SPItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, pProvider, blockProvider, SnowPigMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Mod Tags
        tag(SPItemTags.KNIVES);
        //tag(ItemTags.MUSIC_DISCS).add(SPItems.MUSIC_DISC_FROSTY_SNIG.get());
        tag(ItemTags.WOLF_FOOD).add(SPItems.FROZEN_PORKCHOP.get());
    }
}
