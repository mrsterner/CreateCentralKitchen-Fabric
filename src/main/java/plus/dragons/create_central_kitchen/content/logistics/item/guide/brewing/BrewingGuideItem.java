package plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveBlockEntity;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveGuideItem;
import plus.dragons.create_central_kitchen.entry.capability.FRCapabilityEntries;
import plus.dragons.create_central_kitchen.entry.menu.FRMenuEntries;

public class BrewingGuideItem extends BlazeStoveGuideItem<BrewingGuide> {
    
    public BrewingGuideItem(Properties properties) {
        super(properties);
    }
    
    @Override
    protected Capability<BrewingGuide> getGuideCapability() {
        return FRCapabilityEntries.BREWING_GUIDE;
    }
    
    @Override
    protected BrewingGuideMenu createGuideMenu(int syncId, Inventory inventory, ItemStack guide) {
        return new BrewingGuideMenu(FRMenuEntries.BREWING_GUIDE.get(), syncId, inventory, guide);
    }
    
    @Override
    protected BrewingGuideMenu createGuideMenu(int syncId, Inventory inventory, BlazeStoveBlockEntity stove) {
        return new BrewingGuideMenu(FRMenuEntries.BREWING_GUIDE.get(), syncId, inventory, stove);
    }
    
    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new BrewingGuide(stack);
    }
    
}
