package plus.dragons.create_central_kitchen.entry.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuide;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

@ModLoadSubscriber(modid = Mods.MD)
public class MDCapabilityEntries {

    public static final Capability<MinersCookingGuide> MINERS_COOKING_GUIDE = CapabilityManager.get(new CapabilityToken<>() {});

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(MinersCookingGuide.class);
    }

}
