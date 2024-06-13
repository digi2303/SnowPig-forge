package com.uraneptus.snowpig.core.registry;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.common.items.FrozenHam;
import com.uraneptus.snowpig.common.items.FrozenItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.JukeboxSongs;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SPItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SnowPigMod.MOD_ID);

    public static final DeferredItem<Item> FROZEN_PORKCHOP = ITEMS.register("frozen_porkchop",
            () -> new FrozenItem(400, new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3f).build())));

    public static final DeferredItem<Item> SNOW_PIG_EGG = ITEMS.register("snow_pig_spawn_egg",
            () -> new DeferredSpawnEggItem(SPEntityTypes.SNOW_PIG, 0x70CFF3, 0xE2FBFA, new Item.Properties()));

    /*
    public static final DeferredItem<Item> MUSIC_DISC_FROSTY_SNIG = ITEMS.register("music_disc_frosty_snig",
            () -> new JukeboxPlayable(12, SPSounds.MUSIC_DISC_FROSTY_SNIG, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3720));

     */
    public static final DeferredItem<Item> MUSIC_DISC_FROSTY_SNIG = ITEMS.registerSimpleItem("music_disc_frosty_snig", new Item.Properties()
            .stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SPJukeboxSongs.FROSTY_SNIG));

    public static final DeferredItem<Item> FROZEN_HAM = ITEMS.register("frozen_ham", () -> new FrozenHam(new Item.Properties().attributes(FrozenHam.createAttributes(2, -1.2F)).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.3F).build())));

}