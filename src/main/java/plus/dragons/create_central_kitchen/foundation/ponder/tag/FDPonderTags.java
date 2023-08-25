package plus.dragons.create_central_kitchen.foundation.ponder.tag;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;
import plus.dragons.create_central_kitchen.CentralKitchen;
import plus.dragons.create_central_kitchen.entry.item.FDItemEntries;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FDPonderTags {
    
    public static final PonderTag COOKING = create("cooking_automation");
    
    private static PonderTag create(String id) {
        return new PonderTag(CentralKitchen.genRL(id));
    }
    
    public static void register() {
        COOKING.item(FDItemEntries.COOKING_GUIDE.get(), true, false)
            .defaultLang("Cooking Automation", "Components which automate the cooking process")
            .addToIndex();
        PonderRegistry.TAGS.forTag(COOKING)
            .add(AllBlocks.BLAZE_BURNER)
            .add(FDItemEntries.COOKING_GUIDE)
            .add(ModBlocks.COOKING_POT.get());
    }
    
}
