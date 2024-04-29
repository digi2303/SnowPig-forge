package com.uraneptus.snowpig.core.events;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.common.entities.SnowPig;
import com.uraneptus.snowpig.core.registry.SPEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = SnowPigMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SPCommonModEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(SPEntityTypes.SNOW_PIG.get(), SnowPig.createAttributes().build());
    }
}
