package plus.dragons.create_central_kitchen.integration.jei.transfer;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveGuideSyncPacket;
import plus.dragons.create_central_kitchen.content.logistics.item.guide.brewing.BrewingGuideMenu;
import plus.dragons.create_central_kitchen.entry.menu.FRMenuEntries;
import plus.dragons.create_central_kitchen.entry.network.FDNetworkEntries;
import umpaz.farmersrespite.common.crafting.KettleRecipe;
import umpaz.farmersrespite.integration.jei.JEIFRRecipeTypes;

import java.util.Optional;

public class BrewingGuideTransferHandler implements IRecipeTransferHandler<BrewingGuideMenu, KettleRecipe> {
    
    @Override
    public Class<BrewingGuideMenu> getContainerClass() {
        return BrewingGuideMenu.class;
    }
    
    @Override
    public Optional<MenuType<BrewingGuideMenu>> getMenuType() {
        return Optional.of(FRMenuEntries.BREWING_GUIDE.get());
    }
    
    @Override
    public RecipeType<KettleRecipe> getRecipeType() {
        return JEIFRRecipeTypes.BREWING;
    }
    
    @Override
    @Nullable
    public IRecipeTransferError transferRecipe(BrewingGuideMenu container, KettleRecipe recipe, IRecipeSlotsView recipeSlots, Player player, boolean maxTransfer, boolean doTransfer) {
        if (!doTransfer)
            return null;
        var inputs = recipe.getIngredients();
        for (int i = 0; i < 2; ++i) {
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
