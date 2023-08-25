package plus.dragons.create_central_kitchen.entry.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;


@ModLoadSubscriber(modid = Mods.NEAPOLITAN)
public class NeapolitanItemEntries {
    
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_NEAPOLITAN_ICE_CREAM_CHOCOLATE = REGISTRATE
        .item("incomplete_neapolitan_ice_cream_chocolate", SequencedAssemblyItem::new)
        .lang("Incomplete Neapolitan Ice Cream")
        .properties(prop -> prop.stacksTo(16))
        .register();
    
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_NEAPOLITAN_ICE_CREAM_STRAWBERRY = REGISTRATE
        .item("incomplete_neapolitan_ice_cream_strawberry", SequencedAssemblyItem::new)
        .lang("Incomplete Neapolitan Ice Cream")
        .properties(prop -> prop.stacksTo(16))
        .register();
    
}
