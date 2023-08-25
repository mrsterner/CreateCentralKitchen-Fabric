package plus.dragons.create_central_kitchen.foundation.ponder.entry;

import com.sammy.minersdelight.setup.MDBlocks;
import plus.dragons.create_central_kitchen.entry.item.MDItemEntries;

public class MDPonderEntries {

    public static void register() {
        FDPonderEntries.BLAZE_STOVE_INTRO
            .addComponent(MDItemEntries.MINERS_COOKING_GUIDE);
        FDPonderEntries.BLAZE_STOVE_CONFIGURE
            .addComponent(MDItemEntries.MINERS_COOKING_GUIDE)
            .addComponent(MDBlocks.COPPER_POT.getId());
        FDPonderEntries.BLAZE_STOVE_HEAT_SOURCE
            .addComponent(MDItemEntries.MINERS_COOKING_GUIDE)
            .addComponent(MDBlocks.COPPER_POT.getId());
    }

}
