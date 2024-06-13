package com.uraneptus.snowpig.core.data.client;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.core.registry.SPEntityTypes;
import com.uraneptus.snowpig.core.registry.SPItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class SPLangProvider extends LanguageProvider {

    public SPLangProvider(PackOutput output) {
        super(output, SnowPigMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(SPItems.FROZEN_PORKCHOP, "Frozen Porkchop");
        addItem(SPItems.FROZEN_HAM, "Frozen Ham");
        addItem(SPItems.SNOW_PIG_EGG, "Snow Pig Spawn Egg");
        addItem(SPItems.MUSIC_DISC_FROSTY_SNIG, "Music Disc");
        add("jukebox_song.snowpig.frosty_snig", "Luz - Frosty Snig");

        addEntityType(SPEntityTypes.SNOW_PIG, "Snow Pig");

        addSubtitles("entity.snow_pig.ambient", "Snow Pig oinks");
        addSubtitles("entity.snow_pig.hurt", "Snow Pig hurts");
        addSubtitles("entity.snow_pig.death", "Snow Pig dies");
    }

    public void addSubtitles(String path, String name) {
        add("subtitles." + path, name);
    }
}