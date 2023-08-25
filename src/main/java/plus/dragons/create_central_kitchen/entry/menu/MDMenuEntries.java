package plus.dragons.create_central_kitchen.entry.menu;

import com.tterrag.registrate.util.entry.MenuEntry;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuideMenu;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuideScreen;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;

@ModLoadSubscriber(modid = Mods.MD)
public class MDMenuEntries {

    public static final MenuEntry<MinersCookingGuideMenu> MINERS_COOKING_GUIDE = REGISTRATE.menu("miners_cooking_guide",
        MinersCookingGuideMenu::new, () -> MinersCookingGuideScreen::new).register();


}
