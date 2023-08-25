package plus.dragons.create_central_kitchen.entry.menu;

import com.tterrag.registrate.util.entry.MenuEntry;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing.BrewingGuideMenu;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing.BrewingGuideScreen;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;

@ModLoadSubscriber(modid = Mods.FR)
public class FRMenuEntries {
    
    public static final MenuEntry<BrewingGuideMenu> BREWING_GUIDE = REGISTRATE.menu("brewing_guide",
        BrewingGuideMenu::new, () -> BrewingGuideScreen::new).register();
    
}
