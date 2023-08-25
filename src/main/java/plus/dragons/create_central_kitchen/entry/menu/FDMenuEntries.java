package plus.dragons.create_central_kitchen.entry.menu;

import com.tterrag.registrate.util.entry.MenuEntry;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.cooking.CookingGuideMenu;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.cooking.CookingGuideScreen;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;


@ModLoadSubscriber(modid = Mods.FD)
public class FDMenuEntries {
    
    public static final MenuEntry<CookingGuideMenu> COOKING_GUIDE = REGISTRATE.menu("cooking_guide",
        CookingGuideMenu::new, () -> CookingGuideScreen::new).register();
    
}
