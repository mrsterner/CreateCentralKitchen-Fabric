package plus.dragons.create_central_kitchen.content.logistics.block.basket;

import com.simibubi.create.content.kinetics.belt.behaviour.DirectBeltInputBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import plus.dragons.create_central_kitchen.api.block.entity.DelegatingSmartTileEntity;
import plus.dragons.create_central_kitchen.foundation.mixin.common.farmersdelight.BasketBlockEntityAccessor;
import vectorwing.farmersdelight.common.block.BasketBlock;
import vectorwing.farmersdelight.common.block.entity.BasketBlockEntity;

import java.util.List;

public class SmartBasketBlockEntity extends DelegatingSmartTileEntity<BasketBlockEntity> {
    
    public SmartBasketBlockEntity(BasketBlockEntity basketBlockEntity) {
        super(basketBlockEntity);
    }
    
    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        behaviours.add(new DirectBeltInputBehaviour(this)
            .onlyInsertWhen(this::canInsert)
            .setInsertionHandler(this::tryInsertingFromSide)
        );
    }
    
    private boolean canInsert(Direction direction) {
        Direction facing = this.getBlockState().getValue(BasketBlock.FACING);
        boolean match = switch (facing) {
            case UP -> direction != Direction.UP;
            case DOWN -> direction == Direction.UP;
            default -> direction == facing.getOpposite();
        };
        return match && !((BasketBlockEntityAccessor)this.blockEntity).invokeIsOnTransferCooldown();
    }
    
    private ItemStack tryInsertingFromSide(TransportedItemStack inserted, Direction side, boolean simulate) {
        LazyOptional<IItemHandler> lazy = this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, side);
        if (!lazy.isPresent())
            return inserted.stack;
        ItemStack ret = ItemHandlerHelper.insertItemStacked(lazy.orElse(null), inserted.stack.copy(), simulate);
        if (!simulate && !ret.equals(inserted.stack, false)) {
            this.blockEntity.setTransferCooldown(8);
            this.blockEntity.setChanged();
        }
        return ret;
    }
    
}
