package plus.dragons.create_central_kitchen.entry.item;

import com.simibubi.create.AllCreativeModeTabs;

import com.tterrag.registrate.util.entry.ItemEntry;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing.BrewingGuideItem;
import plus.dragons.create_central_kitchen.foundation.data.recipe.provider.DatapackRecipes;
import plus.dragons.create_central_kitchen.foundation.data.recipe.provider.Recipes;
import plus.dragons.create_central_kitchen.foundation.data.tag.ForgeItemTags;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;
import umpaz.farmersrespite.common.tag.FRTags;
import vectorwing.farmersdelight.common.registry.ModItems;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;

@ModLoadSubscriber(modid = Mods.FR)
public class FRItemEntries {
    static {
        REGISTRATE.creativeModeTab(() -> AllCreativeModeTabs.BASE_CREATIVE_TAB);
    }
    
    public static final ItemEntry<BrewingGuideItem> BREWING_GUIDE = REGISTRATE.item("brewing_guide", BrewingGuideItem::new)
        .properties(prop -> prop.stacksTo(1))
        .transform(DatapackRecipes.addRecipe(Mods.FR, (ctx, prov) -> prov.add(Recipes.shapeless(ctx.getId())
            .output(ctx.get())
            .require(ForgeItemTags.create("plates/obsidian"))
            .require(ModItems.CANVAS.get())
            .require(FRTags.TEA_LEAVES))))
        .register();
    
}
