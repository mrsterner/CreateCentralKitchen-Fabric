package plus.dragons.create_central_kitchen.integration.jei.transfer;

import com.sammy.minersdelight.jei.CopperPotCookingRecipeCategory;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveGuideSyncPacket;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.minersCooking.MinersCookingGuideMenu;
import plus.dragons.create_central_kitchen.entry.menu.MDMenuEntries;
import plus.dragons.create_central_kitchen.entry.network.FDNetworkEntries;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.Optional;

public class MinersCookingGuideTransferHandler implements IRecipeTransferHandler<MinersCookingGuideMenu, CookingPotRecipe> {

    @Override
    public Class<MinersCookingGuideMenu> getContainerClass() {
        return MinersCookingGuideMenu.class;
    }
    
    @Override
    public Optional<MenuType<MinersCookingGuideMenu>> getMenuType() {
        return Optional.of(MDMenuEntries.MINERS_COOKING_GUIDE.get());
    }
    
    @Override
    public RecipeType<CookingPotRecipe> getRecipeType() {
        return CopperPotCookingRecipeCategory.COOKING;
    }
    
    @Override
    @Nullable
    public IRecipeTransferError transferRecipe(MinersCookingGuideMenu container, CookingPotRecipe recipe, IRecipeSlotsView recipeSlots, Player player, boolean maxTransfer, boolean doTransfer) {
        var inputs = recipe.getIngredients();
        if (!doTransfer)
            return null;
        for (int i = 0; i < 4; ++i) {
            ItemStack input;
            if (i < inputs.size()) {
                var items = inputs.get(i).getItems();
                input = items.length == 0 ? ItemStack.EMPTY : items[0];
            } else input = ItemStack.EMPTY;
            container.getSlot(36 + i).set(input);
        }
        FDNetworkEntries.CHANNEL.sendToServer(new BlazeStoveGuideSyncPacket(container));
        return null;
    }

}
