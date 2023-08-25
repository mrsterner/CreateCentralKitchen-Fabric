package plus.dragons.create_central_kitchen.content.contraptions.components.actor;

import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.foundation.utility.BlockHelper;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.LimeBushBlock;
import net.brdle.collectorsreap.common.block.PomegranateBushBlock;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import plus.dragons.create_central_kitchen.foundation.utility.ModLoadSubscriber;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;

import static plus.dragons.create_central_kitchen.content.contraptions.components.actor.HarvesterMovementBehaviourExtension.REGISTRY;

@ModLoadSubscriber(modid = Mods.CR)
public class CRHarvesterMovementBehaviorExtensions {
    
    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            REGISTRY.put(CRBlocks.PORTOBELLO_COLONY.get(),
                FDHarvesterMovementBehaviorExtensions::harvestMushroomColony);
            REGISTRY.put(CRBlocks.LIME_BUSH.get(),
                CRHarvesterMovementBehaviorExtensions::harvestLimeBush);
            REGISTRY.put(CRBlocks.POMEGRANATE_BUSH.get(),
                CRHarvesterMovementBehaviorExtensions::harvestPomegranateBush);
        });
    }
    
    public static void harvestLimeBush(HarvesterMovementBehaviour behaviour,
                                       MovementContext context,
                                       BlockPos pos, BlockState state,
                                       boolean replant, boolean partial)
    {
        if (!(state.getBlock() instanceof LimeBushBlock limeBush))
            return;
        if (state.getValue(LimeBushBlock.STUNTED) || state.getValue(LimeBushBlock.HALF) == DoubleBlockHalf.LOWER)
            return;
        Level level = context.world;
        boolean destroy = partial;
        var ageProp = limeBush.getAgeProperty();
        if (state.getValue(ageProp) == limeBush.getMaxAge()) {
            behaviour.dropItem(context, new ItemStack(CRItems.LIME.get(), 2 + level.random.nextInt(2)));
            if (replant) {
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                    1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlockAndUpdate(pos, state.setValue(ageProp, 0));
                return;
            }
            destroy = true;
        }
        BlockPos posBelow = pos.below();
        BlockState stateBelow = level.getBlockState(posBelow);
        if (destroy && stateBelow.is(state.getBlock()) && stateBelow.getValue(LimeBushBlock.HALF) == DoubleBlockHalf.LOWER) {
            BlockHelper.destroyBlock(level, pos, 1, stack -> behaviour.dropItem(context, stack));
            BlockHelper.destroyBlock(level, posBelow, 1, stack -> behaviour.dropItem(context, stack));
        }
    }
    
    public static void harvestPomegranateBush(HarvesterMovementBehaviour behaviour,
                                              MovementContext context,
                                              BlockPos pos, BlockState state,
                                              boolean replant, boolean partial)
    {
        if (!(state.getBlock() instanceof PomegranateBushBlock pomegranateBush))
            return;
        if (state.getValue(PomegranateBushBlock.HALF) == DoubleBlockHalf.LOWER)
            return;
        Level level = context.world;
        boolean destroy = partial;
        var ageProp = pomegranateBush.getAgeProperty();
        if (state.getValue(ageProp) == pomegranateBush.getMaxAge()) {
            behaviour.dropItem(context, new ItemStack(CRItems.POMEGRANATE.get(), 1 + level.random.nextInt(2)));
            if (replant) {
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                    1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlockAndUpdate(pos, state.setValue(ageProp, 0));
                return;
            }
            destroy = true;
        }
        BlockPos posBelow = pos.below();
        BlockState stateBelow = level.getBlockState(posBelow);
        if (destroy && stateBelow.is(state.getBlock()) && stateBelow.getValue(PomegranateBushBlock.HALF) == DoubleBlockHalf.LOWER) {
            BlockHelper.destroyBlock(level, pos, 1, stack -> behaviour.dropItem(context, stack));
            BlockHelper.destroyBlock(level, posBelow, 1, stack -> behaviour.dropItem(context, stack));
        }
    }
    
}
