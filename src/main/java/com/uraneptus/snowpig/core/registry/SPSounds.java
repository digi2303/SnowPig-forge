package com.uraneptus.snowpig.core.registry;

import com.uraneptus.snowpig.SnowPigMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SPSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, SnowPigMod.MOD_ID);

    public static final Supplier<SoundEvent> SNOW_PIG_AMBIENT = SOUNDS.register("entity.snow_pig.ambient",
            () -> SoundEvent.createVariableRangeEvent(SnowPigMod.modPrefix("entity.snow_pig.ambient")));

    public static final Supplier<SoundEvent> SNOW_PIG_HURT = SOUNDS.register("entity.snow_pig.hurt",
            () -> SoundEvent.createVariableRangeEvent(SnowPigMod.modPrefix("entity.snow_pig.hurt")));

    public static final Supplier<SoundEvent> SNOW_PIG_DEATH = SOUNDS.register("entity.snow_pig.death",
            () -> SoundEvent.createVariableRangeEvent(SnowPigMod.modPrefix("entity.snow_pig.death")));

    public static final Supplier<SoundEvent> SNOW_PIG_STEP = SOUNDS.register("entity.snow_pig.step",
            () -> SoundEvent.createVariableRangeEvent(SnowPigMod.modPrefix("entity.snow_pig.step")));

    public static final Supplier<SoundEvent> MUSIC_DISC_FROSTY_SNIG = SOUNDS.register("music_disc.frosty_snig",
            () -> SoundEvent.createVariableRangeEvent(SnowPigMod.modPrefix("music_disc.frosty_snig")));
}
