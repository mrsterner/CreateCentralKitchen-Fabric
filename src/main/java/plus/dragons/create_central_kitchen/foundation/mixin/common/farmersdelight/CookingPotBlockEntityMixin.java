package plus.dragons.create_central_kitchen.foundation.mixin.common.farmersdelight;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import plus.dragons.create_central_kitchen.content.contraptions.blazeStove.BlazeStoveBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

@Mixin(value = CookingPotBlockEntity.class, remap = false)
public abstract class CookingPotBlockEntityMixin extends SyncedBlockEntity {
    
    private CookingPotBlockEntityMixin(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn, pos, state);
    }
    
    @Inject(method = "processCooking", at = @At(value = "INVOKE", target = "Lvectorwing/farmersdelight/common/block/entity/CookingPotBlockEntity;setRecipeUsed(Lnet/minecraft/world/item/crafting/Recipe;)V", remap = true))
    private void cck$notifyBlazeStove(CookingPotRecipe recipe, CookingPotBlockEntity cookingPot, CallbackInfoReturnable<Boolean> cir) {
        assert this.level != null;
        BlockPos posBelow = this.worldPosition.below();
        if (this.level.getBlockState(posBelow).getBlock() instanceof BlazeStoveBlock stove) {
            stove.startSignal(this.level, posBelow);
        }
    }
    
}
