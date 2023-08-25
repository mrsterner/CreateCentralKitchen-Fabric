package plus.dragons.create_central_kitchen.foundation.mixin.common.farmersrespite;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import plus.dragons.create_central_kitchen.foundation.config.CentralKitchenConfigs;
import umpaz.farmersrespite.common.block.CoffeeBushTopBlock;

@Mixin(CoffeeBushTopBlock.class)
public abstract class CoffeeBushTopBlockMixin extends BushBlock implements BonemealableBlock {

    public CoffeeBushTopBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        if(CentralKitchenConfigs.COMMON.integration.enableHarvesterSupportForFarmersRespite.get()) return Shapes.empty();
        return super.getCollisionShape(pState,pLevel,pPos,pContext);
    }

    @Deprecated
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        if(CentralKitchenConfigs.COMMON.integration.enableHarvesterSupportForFarmersRespite.get()) return Shapes.empty();
        return super.getOcclusionShape(pState,pLevel,pPos);
    }
}
