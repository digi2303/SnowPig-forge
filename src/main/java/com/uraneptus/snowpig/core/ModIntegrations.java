package com.uraneptus.snowpig.core;

import net.neoforged.fml.ModList;


public class ModIntegrations {

    public static final String FD_MODID = "farmersdelight";
    public static final Boolean IS_FD_LOADED = ModList.get().isLoaded(FD_MODID);
    public static final Boolean IS_AD_LOADED = ModList.get().isLoaded("abnormals_delight");

    /*
    public static CreativeModeTab getFdTab() {
        return ModCreativeTabs.TAB_FARMERS_DELIGHT.get();
    }

    public static Item getHam() {
        return ModItems.HAM.get();
    }


     */

}
