package plus.dragons.create_central_kitchen.integration.jei;

import com.sammy.minersdelight.jei.CopperPotCookingRecipeCategory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.ResourceLocation;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing.BrewingGuideScreen;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuideScreen;
import plus.dragons.create_central_kitchen.integration.jei.transfer.BlazeStoveGuideGhostIngredientHandler;
import plus.dragons.create_central_kitchen.integration.jei.transfer.MinersCookingGuideTransferHandler;

public class MDSubJeiPlugin extends AbstractJeiPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return CentralKitchenJeiPlugin.ID;
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGhostIngredientHandler(BrewingGuideScreen.class, new BlazeStoveGuideGhostIngredientHandler<>());
        registration.addRecipeClickArea(MinersCookingGuideScreen.class, 116, 24, 42, 30, CopperPotCookingRecipeCategory.COOKING);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(new MinersCookingGuideTransferHandler(), CopperPotCookingRecipeCategory.COOKING);
    }

}