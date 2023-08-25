package plus.dragons.create_central_kitchen.entry.fluid;

import cn.mcmod.corn_delight.item.ItemRegistry;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import plus.dragons.create_central_kitchen.CentralKitchen;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.foundation.fluid.VirtualFluidFromItem.milky;
import static plus.dragons.create_central_kitchen.foundation.fluid.VirtualFluidFromItem.virtual;

@ModLoadSubscriber(modid = Mods.CORN_DELIGHT)
public class CornDelightFluidEntries {
    public static final FluidEntry<VirtualFluid>

    CORN_SOUP = virtual(CentralKitchen.genRL("fluid/corn_soup_still"),CentralKitchen.genRL("fluid/corn_soup_still"),
                    ItemRegistry.CORN_SOUP, 250)
            .register(),

    CREAMY_CORN_DRINK = milky(ItemRegistry.CREAMY_CORN_DRINK, 15321972)
            .register();
}
