package plus.dragons.create_central_kitchen.entry.block.entity;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveBlockEntity;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveRenderer;
import plus.dragons.create_central_kitchen.entry.block.FDBlockEntries;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;

@ModLoadSubscriber(modid = Mods.FD)
public class FDBlockEntityEntries {
    
    public static final BlockEntityEntry<BlazeStoveBlockEntity> BLAZE_STOVE = REGISTRATE
        .blockEntity("blaze_stove", BlazeStoveBlockEntity::new)
        .validBlocks(FDBlockEntries.BLAZE_STOVE)
        .renderer(() -> BlazeStoveRenderer::new)
        .register();

}
