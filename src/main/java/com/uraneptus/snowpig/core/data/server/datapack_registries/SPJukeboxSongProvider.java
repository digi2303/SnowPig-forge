package com.uraneptus.snowpig.core.data.server.datapack_registries;

import com.uraneptus.snowpig.core.registry.SPJukeboxSongs;
import com.uraneptus.snowpig.core.registry.SPSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.JukeboxSong;

import java.util.function.Supplier;

public class SPJukeboxSongProvider {
    public static void create(BootstrapContext<JukeboxSong> context) {
        register(context, SPJukeboxSongs.FROSTY_SNIG, SPSounds.MUSIC_DISC_FROSTY_SNIG, 3720, 12);
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Supplier<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(Holder.direct(soundEvent.get()), Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())), (float) lengthInSeconds, comparatorOutput));
    }
}
