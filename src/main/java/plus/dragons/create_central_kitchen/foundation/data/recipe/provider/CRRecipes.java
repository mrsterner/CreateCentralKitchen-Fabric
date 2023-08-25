package plus.dragons.create_central_kitchen.foundation.data.recipe.provider;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider.GeneratedRecipe;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import plus.dragons.create_central_kitchen.CentralKitchen;
import plus.dragons.create_central_kitchen.entry.fluid.CRFluidEntries;
import plus.dragons.create_central_kitchen.entry.fluid.NeapolitanFluidEntries;
import plus.dragons.create_central_kitchen.entry.item.CRItemEntries;
import plus.dragons.create_central_kitchen.foundation.data.tag.ForgeItemTags;
import plus.dragons.create_central_kitchen.foundation.utility.Mods;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

public class CRRecipes extends DatapackRecipes {
    private final GeneratedRecipe
        FILLING_CANDIED_LIME = add(filling("candied_lime")
            .output(CRItems.CANDIED_LIME.get())
            .withCondition(enabled(CRItems.CANDIED_LIME))
            .require(AllTags.AllFluidTags.HONEY.tag, 50)
            .require(CRItems.LIME_SLICE.get())),
        COMPACTING_LIME_COOKIE = add(compacting("lime_cookie")
            .output(CRItems.LIME_COOKIE.get())
            .withCondition(enabled(CRItems.LIME_COOKIE))
            .require(CRItemTags.FRUITS_LIME)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)),
        MIXING_LIMEADE = add(mixing("limeade")
            .output(CRFluidEntries.LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.LIMEADE))
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_LIME)
            .require(Items.SUGAR)),
        MIXING_BERRY_LIMEADE = add(mixing("berry_limeade")
            .output(CRFluidEntries.BERRY_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.BERRY_LIMEADE))
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_LIME)
            .require(ForgeTags.BERRIES)
            .require(ForgeTags.BERRIES)
            .require(ForgeTags.BERRIES)
            .require(Items.SUGAR)),
        MIXING_BERRY_LIMEADE_FROM_LIMEADE = add(mixing("berry_limeade_from_limeade")
            .output(CRFluidEntries.BERRY_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.BERRY_LIMEADE))
            .withCondition(enabled(CRItems.LIMEADE))
            .require(CRFluidEntries.LIMEADE.get(), 250)
            .require(ForgeTags.BERRIES)
            .require(ForgeTags.BERRIES)
            .require(ForgeTags.BERRIES)),
        MIXING_MINT_LIMEADE = add(mixing("mint_limeade")
            .output(CRFluidEntries.MINT_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.MINT_LIMEADE))
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_LIME)
            .require(NeapolitanItems.MINT_LEAVES.get())
            .require(NeapolitanItems.MINT_LEAVES.get())
            .require(Items.SUGAR)),
        MIXING_MINT_LIMEADE_FROM_LIMEADE = add(mixing("mint_limeade_from_limeade")
            .output(CRFluidEntries.MINT_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.MINT_LIMEADE))
            .withCondition(enabled(CRItems.LIMEADE))
            .require(CRFluidEntries.LIMEADE.get(), 250)
            .require(NeapolitanItems.MINT_LEAVES.get())
            .require(NeapolitanItems.MINT_LEAVES.get())),
        MIXING_PINK_LIMEADE = add(mixing("pink_limeade")
            .output(CRFluidEntries.PINK_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.PINK_LIMEADE))
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(Items.SUGAR)),
        MIXING_PINK_LIMEADE_FROM_LIMEADE = add(mixing("pink_limeade_from_limeade")
            .output(CRFluidEntries.PINK_LIMEADE.get(), 250)
            .withCondition(enabled(CRItems.PINK_LIMEADE))
            .withCondition(enabled(CRItems.LIMEADE))
            .require(CRFluidEntries.LIMEADE.get(), 250)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(CRItemTags.FRUITS_POMEGRANATE)),
        MIXING_LIME_ICE_CREAM = add(mixing("lime_ice_cream")
            .output(CRFluidEntries.LIME_ICE_CREAM.get(), 500)
            .withCondition(enabled(CRItems.LIME_ICE_CREAM))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(NeapolitanItems.ICE_CUBES.get())
            .require(Items.SUGAR)
            .require(CRItemTags.FRUITS_LIME)
            .require(Tags.Fluids.MILK, 250)),
        CRAFTING_LIME_CAKE_FROM_DOUGH = add(shaped("lime_cake_from_dough")
            .output(CRItems.LIME_CAKE.get())
            .withCondition(enabled(CRItems.LIME_CAKE))
            .define('m', ForgeTags.MILK)
            .define('s', Items.SUGAR)
            .define('e', ForgeTags.EGGS)
            .define('#', CRItemTags.FRUITS_LIME)
            .define('w', ForgeTags.DOUGH_WHEAT)
            .pattern("mmm")
            .pattern("ses")
            .pattern("#w#")),
        COMPACTING_LIME_CAKE = add(compacting("lime_cake")
            .output(CRItems.LIME_CAKE.get())
            .withCondition(enabled(CRItems.LIME_CAKE))
            .require(Tags.Items.EGGS)
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)
            .require(CRItemTags.FRUITS_LIME)
            .require(CRItemTags.FRUITS_LIME)
            .require(Tags.Fluids.MILK, 1000)),
        MIXING_LIME_MILKSHAKE = add(mixing("lime_milkshake")
            .output(CRFluidEntries.LIME_MILKSHAKE.get(), 750)
            .withCondition(enabled(CRItems.LIME_MILKSHAKE))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(CRItemTags.FRUITS_LIME)
            .require(NeapolitanFluidEntries.VANILLA_ICE_CREAM.get(), 500)
            .require(Tags.Fluids.MILK, 250)),
        MIXING_LIME_MILKSHAKE_FROM_ICE_CREAM = add(mixing("lime_milkshake_from_ice_cream")
            .output(CRFluidEntries.LIME_MILKSHAKE.get(), 750)
            .withCondition(enabled(CRItems.LIME_MILKSHAKE))
            .withCondition(enabled(CRItems.LIME_ICE_CREAM))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(NeapolitanItems.DRIED_VANILLA_PODS.get())
            .require(CRFluidEntries.LIME_ICE_CREAM.get(), 500)
            .require(Tags.Fluids.MILK, 250)),
        MIXING_POMEGRANATE_ICE_CREAM = add(mixing("pomegranate_ice_cream")
            .output(CRFluidEntries.POMEGRANATE_ICE_CREAM.get(), 500)
            .withCondition(enabled(CRItems.POMEGRANATE_ICE_CREAM))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(NeapolitanItems.ICE_CUBES.get())
            .require(Items.SUGAR)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(Tags.Fluids.MILK, 250)),
        MIXING_LIME_GREEN_TEA = add(mixing("lime_green_tea")
            .output(CRFluidEntries.LIME_GREEN_TEA.get(), 250)
            .withCondition(enabled(CRItems.LIME_GREEN_TEA))
            .require(CRItemTags.FRUITS_LIME)
            .require(FRItems.GREEN_TEA_LEAVES.get())
            .require(Fluids.WATER,250)
            .requiresHeat(HeatCondition.HEATED)),
        MIXING_POMEGRANATE_BLACK_TEA = add(mixing("pomegranate_black_tea")
            .output(CRFluidEntries.POMEGRANATE_BLACK_TEA.get(), 250)
            .withCondition(enabled(CRItems.POMEGRANATE_BLACK_TEA))
            .require(CRItems.POMEGRANATE_SLICE.get())
            .require(FRItems.BLACK_TEA_LEAVES.get())
            .require(Fluids.WATER,250)
            .requiresHeat(HeatCondition.HEATED)),
        MIXING_POMEGRANATE_SMOOTHIE = add(mixing("pomegranate_smoothie")
            .output(CRFluidEntries.POMEGRANATE_SMOOTHIE.get(), 250)
            .withCondition(enabled(CRItems.POMEGRANATE_SMOOTHIE))
            .require(CRItems.POMEGRANATE_SLICE.get())
            .require(CRItems.POMEGRANATE_SLICE.get())
            .require(NeapolitanItems.BANANA.get())),
        CRAFTING_POMEGRANATE_CAKE_FROM_DOUGH = add(shaped("pomegranate_cake_from_dough")
            .output(CRItems.POMEGRANATE_CAKE.get())
            .withCondition(enabled(CRItems.POMEGRANATE_CAKE))
            .define('m', ForgeTags.MILK)
            .define('s', Items.SUGAR)
            .define('e', ForgeTags.EGGS)
            .define('#', CRItemTags.FRUITS_POMEGRANATE)
            .define('w', ForgeTags.DOUGH_WHEAT)
            .pattern("mmm")
            .pattern("ses")
            .pattern("#w#")),
        COMPACTING_POMEGRANATE_CAKE = add(compacting("pomegranate_cake")
            .output(CRItems.POMEGRANATE_CAKE.get())
            .withCondition(enabled(CRItems.POMEGRANATE_CAKE))
            .require(Tags.Items.EGGS)
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)
            .require(ForgeItemTags.FLOUR__WHEAT.tag)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(Tags.Fluids.MILK, 1000)),
        COMPACTING_STRAWBERRY_JAM_BUM= add(compacting("strawberry_jam_bum")
            .output(CRItems.STRAWBERRY_JAM_BUN.get())
            .withCondition(enabled(CRItems.STRAWBERRY_JAM_BUN))
            .require(Items.WHEAT)
            .require(NeapolitanItems.STRAWBERRIES.get())
            .require(CRItemTags.LIME_OR_SLICE)
            .require(Tags.Fluids.MILK, 1000)),
        MIXING_POMEGRANATE_MILKSHAKE = add(mixing("pomegranate_milkshake")
            .output(CRFluidEntries.POMEGRANATE_MILKSHAKE.get(), 750)
            .withCondition(enabled(CRItems.POMEGRANATE_MILKSHAKE))
            .withCondition(enabled(CRItems.POMEGRANATE_ICE_CREAM))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(CRItemTags.FRUITS_POMEGRANATE)
            .require(NeapolitanFluidEntries.VANILLA_ICE_CREAM.get(), 500)
            .require(Tags.Fluids.MILK, 250)),
        MIXING_POMEGRANATE_MILKSHAKE_FROM_ICE_CREAM = add(mixing("pomegranate_milkshake_from_ice_cream")
            .output(CRFluidEntries.POMEGRANATE_MILKSHAKE.get(), 750)
            .withCondition(enabled(CRItems.POMEGRANATE_MILKSHAKE))
            .whenModLoaded(Mods.NEAPOLITAN)
            .require(NeapolitanItems.DRIED_VANILLA_PODS.get())
            .require(CRFluidEntries.POMEGRANATE_ICE_CREAM.get(), 500)
            .require(Tags.Fluids.MILK, 250)),
        SEQUENCED_ASSEMBLY_PORTOBELLO_BURGER = add(sequencedAssembly("portobello_burger")
            .require(ForgeTags.BREAD)
            .transitionTo(CRItemEntries.INCOMPLETE_PORTOBELLO_BURGER.get())
            .addOutput(CRItems.PORTOBELLO_BURGER.get(), 1)
            .withCondition(enabled(CRItems.PORTOBELLO_BURGER))
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(CRItems.BAKED_PORTOBELLO_CAP.get()))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.SALAD_INGREDIENTS))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.CROPS_TOMATO))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.CROPS_ONION))),
        SEQUENCED_PORTOBELLO_QUICHE = add(sequencedAssembly("portobello_quiche")
            .require(ModItems.PIE_CRUST.get())
            .transitionTo(CRItemEntries.INCOMPLETE_PORTOBELLO_QUICHE.get())
            .addOutput(CRItems.PORTOBELLO_QUICHE.get(), 1)
            .withCondition(enabled(CRItems.PORTOBELLO_QUICHE))
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(CRItems.BAKED_PORTOBELLO_CAP.get()))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.CROPS_ONION))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.EGGS))
            .addStep(FillingRecipe::new, builder -> builder.require(Tags.Fluids.MILK, 250))),
        SEQUENCED_ASSEMBLY_LIME_PIE = add(sequencedAssembly("lime_pie")
            .require(ModItems.PIE_CRUST.get())
            .transitionTo(CRItemEntries.INCOMPLETE_LIME_PIE.get())
            .addOutput(CRItems.LIME_PIE.get(), 1)
            .withCondition(enabled(CRItems.LIME_PIE))
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(CRItemTags.FRUITS_LIME))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(Items.SUGAR))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.EGGS))
            .addStep(FillingRecipe::new, builder -> builder.require(Tags.Fluids.MILK, 250))),

        SEQUENCED_ASSEMBLY_VEGGIE_WARP = add(sequencedAssembly("veggie_wrap")
            .require(com.ncpbails.culturaldelights.item.ModItems.TORTILLA.get())
            .transitionTo(CRItemEntries.INCOMPLETE_VEGGIE_WRAP.get())
            .addOutput(CRItems.PORTOBELLO_WRAP.get(), 1)
            .withCondition(enabled(CRItems.PORTOBELLO_WRAP))
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ForgeTags.SALAD_INGREDIENTS))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(ModItems.ONION.get()))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(Items.CARROT))
            .addStep(DeployerApplicationRecipe::new, builder -> builder.require(CRItems.BAKED_PORTOBELLO_CAP.get()))
            .addStep(FillingRecipe::new, builder -> builder.require(Tags.Fluids.MILK, 250)));
    
    private static EnabledCondition enabled(RegistryObject<? extends ItemLike> item) {
        return new EnabledCondition(item.getId().getPath());
    }
    
    public CRRecipes(DataGenerator generator) {
        super(Mods.CR, CentralKitchen.REGISTRATE, generator);
    }
    
}
