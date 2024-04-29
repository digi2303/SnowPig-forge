package com.uraneptus.snowpig.core.events;

import com.uraneptus.snowpig.SnowPigMod;
import com.uraneptus.snowpig.core.registry.SPAttachmentTypes;
import com.uraneptus.snowpig.core.registry.SPEntityTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Pig;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = SnowPigMod.MOD_ID)
public class SPCommonNeoEvents {

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        Entity entity = event.getEntity();

        if (entity instanceof Pig pig) {
            if (pig.isInPowderSnow) {
                if (pig.isFullyFrozen()) {
                    int freezeTicks = pig.getData(SPAttachmentTypes.FREEZE_TICKS);

                    if (freezeTicks > 0) {
                        pig.setData(SPAttachmentTypes.FREEZE_TICKS, pig.getData(SPAttachmentTypes.FREEZE_TICKS) - 1);
                    }
                    if (freezeTicks == 0) {
                        pig.convertTo(SPEntityTypes.SNOW_PIG.get(), true);
                    }

                    System.out.println(freezeTicks);
                }
            }
        }
    }
}