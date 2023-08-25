package plus.dragons.create_central_kitchen.entry;

import com.jozufozu.flywheel.core.PartialModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import plus.dragons.create_central_kitchen.CentralKitchen;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CentralKitchen.ID, bus = Bus.MOD)
public class CentralKitchenPartialModels {
    
    public static final PartialModel BLAZE_STOVE_HAT = block("blaze_stove/hat");
    
    private static PartialModel block(String path) {
        return new PartialModel(CentralKitchen.genRL("block/" + path));
    }
    
    private static PartialModel entity(String path) {
        return new PartialModel(CentralKitchen.genRL("entity/" + path));
    }
    
}
