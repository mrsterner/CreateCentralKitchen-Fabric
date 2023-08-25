package plus.dragons.create_central_kitchen.entry.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.cooking.CookingGuide;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

@ModLoadSubscriber(modid = Mods.FD)
public class FDCapabilityEntries {
    
    public static final Capability<CookingGuide> COOKING_GUIDE = CapabilityManager.get(new CapabilityToken<>() {});
    
    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(CookingGuide.class);
    }
    
}
