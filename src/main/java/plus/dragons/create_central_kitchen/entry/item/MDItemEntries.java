package plus.dragons.create_central_kitchen.entry.item;

import com.sammy.minersdelight.setup.MDItems;
import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuideItem;
import plus.dragons.create_central_kitchen.foundation.data.recipe.provider.DatapackRecipes;
import plus.dragons.create_central_kitchen.foundation.data.recipe.provider.Recipes;
import plus.dragons.create_central_kitchen.foundation.data.tag.ForgeItemTags;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;
import vectorwing.farmersdelight.common.registry.ModItems;

import static plus.dragons.create_central_kitchen.CentralKitchen.REGISTRATE;

@ModLoadSubscriber(modid = Mods.MD)
public class MDItemEntries {
    static {
        REGISTRATE.creativeModeTab(() -> AllCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    public static final ItemEntry<MinersCookingGuideItem> MINERS_COOKING_GUIDE = REGISTRATE.item("miners_cooking_guide", MinersCookingGuideItem::new)
        .lang("Miner's Cooking Guide")
        .properties(prop -> prop.stacksTo(1))
        .transform(DatapackRecipes.addRecipe(Mods.MD, (ctx, prov) -> prov.add(Recipes.shapeless(ctx.getId())
            .output(ctx.get())
            .require(ForgeItemTags.create("plates/obsidian"))
            .require(ModItems.CANVAS.get())
            .require(MDItems.CAVE_CARROT.get()))))
        .register();

}
