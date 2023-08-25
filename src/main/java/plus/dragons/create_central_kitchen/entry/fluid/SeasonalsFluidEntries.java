package plus.dragons.create_central_kitchen.entry.fluid;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import plus.dragons.create_central_kitchen.foundation.fluid.VirtualFluidFromItem;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.foundation.fluid.VirtualFluidFromItem.virtual;

@ModLoadSubscriber(modid = Mods.SEASONALS)
public class SeasonalsFluidEntries {
    
    public static final FluidEntry<VirtualFluid>
        PUMPKIN_ICE_CREAM = virtual(SeasonalsItems.PUMPKIN_ICE_CREAM,
            Mods.seasonals("block/pumpkin_ice_cream_block"), 500).register(),
        SWEET_BERRY_ICE_CREAM = virtual(SeasonalsItems.SWEET_BERRY_ICE_CREAM,
            Mods.seasonals("block/sweet_berry_ice_cream_block"), 500).register(),
        PUMPKIN_MILKSHAKE = VirtualFluidFromItem.milky(SeasonalsItems.PUMPKIN_MILKSHAKE, 0xF49F49)
            .register(),
        SWEET_BERRY_MILKSHAKE = VirtualFluidFromItem.milky(SeasonalsItems.SWEET_BERRY_MILKSHAKE, 0xE57283)
            .register();
    
}
