package com.uraneptus.snowpig.core.registry;

import com.uraneptus.snowpig.SnowPigMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.JukeboxSong;

import java.util.HashMap;
import java.util.Map;

public class SPJukeboxSongs {
    public static final ResourceKey<JukeboxSong> FROSTY_SNIG = ResourceKey.create(Registries.JUKEBOX_SONG, SnowPigMod.modPrefix("frosty_snig"));
}
