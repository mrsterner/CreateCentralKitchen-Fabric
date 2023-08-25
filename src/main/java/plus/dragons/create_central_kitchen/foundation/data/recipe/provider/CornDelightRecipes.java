package plus.dragons.create_central_kitchen.foundation.data.recipe.provider;

import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import plus.dragons.create_central_kitchen.CentralKitchen;
import plus.dragons.create_central_kitchen.entry.fluid.CornDelightFluidEntries;
import plus.dragons.create_central_kitchen.foundation.data.tag.ForgeItemTags;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;
import vectorwing.farmersdelight.common.tag.ForgeTags;

public class CornDelightRecipes extends DatapackRecipes {

    private final CreateRecipeProvider.GeneratedRecipe
            MIXING_CORN_SOUP = add(mixing("cord_soup")
                    .output(CornDelightFluidEntries.CORN_SOUP.get(), 250)
                    .require(Tags.Fluids.MILK, 250)
                    .require(ForgeItemTags.CORPS__CORN.tag)
                    .require(ForgeTags.CROPS_CABBAGE)
                    .require(Items.SUGAR)
                    .requiresHeat(HeatCondition.HEATED)),

            MIXING_CREAM_CORN_DRINK = add(mixing("cream_corn_drink")
                    .output(CornDelightFluidEntries.CREAMY_CORN_DRINK.get(), 250)
                    .require(Tags.Fluids.MILK, 250)
                    .require(ForgeItemTags.CORPS__CORN.tag)
                    .require(Items.SUGAR)
                    .requiresHeat(HeatCondition.HEATED));

    public CornDelightRecipes(DataGenerator generator) {
        super(Mods.CORN_DELIGHT, CentralKitchen.REGISTRATE, generator);
    }
}
