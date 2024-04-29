package com.uraneptus.snowpig.core.registry;

import com.mojang.serialization.Codec;
import com.uraneptus.snowpig.SnowPigMod;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class SPAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, SnowPigMod.MOD_ID);

    public static final Supplier<AttachmentType<Integer>> FREEZE_TICKS = ATTACHMENT_TYPES.register("freeze_ticks", () -> AttachmentType.builder(() -> 300).serialize(Codec.INT).build());

}
