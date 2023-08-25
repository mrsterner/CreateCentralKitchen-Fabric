package plus.dragons.create_central_kitchen.foundation.ponder.entry;

import plus.dragons.create_central_kitchen.entry.item.FRItemEntries;
import umpaz.farmersrespite.common.registry.FRItems;

public class FRPonderEntries {
    
    public static void register() {
        FDPonderEntries.BLAZE_STOVE_INTRO
            .addComponent(FRItemEntries.BREWING_GUIDE);
        FDPonderEntries.BLAZE_STOVE_CONFIGURE
            .addComponent(FRItemEntries.BREWING_GUIDE)
            .addComponent(FRItems.KETTLE);
        FDPonderEntries.BLAZE_STOVE_HEAT_SOURCE
            .addComponent(FRItemEntries.BREWING_GUIDE)
            .addComponent(FRItems.KETTLE);
    }
    
}
