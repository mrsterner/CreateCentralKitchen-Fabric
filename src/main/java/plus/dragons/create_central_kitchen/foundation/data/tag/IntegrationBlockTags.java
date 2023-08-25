package plus.dragons.create_central_kitchen.foundation.data.tag;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBlocks;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.farmersrespite.common.registry.FRBlocks;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.Locale;

public enum IntegrationBlockTags {
    VERTICAL_SLABS("quark"),
    VERTICAL_SLABS__CHOCOLATE("quark");
    
    public final TagKey<Block> tag;
    
    IntegrationBlockTags(String modid, String path) {
        this.tag = TagKey.create(ForgeRegistries.Keys.BLOCKS, new ResourceLocation(modid, path));
    }
    
    IntegrationBlockTags(String modid) {
        String path = name().toLowerCase(Locale.ROOT).replace("__", "/");
        this.tag = TagKey.create(ForgeRegistries.Keys.BLOCKS, new ResourceLocation(modid, path));
    }
    
    public static void datagen(RegistrateTagsProvider<Block> prov) {
        prov.tag(VERTICAL_SLABS.tag).addTag(VERTICAL_SLABS__CHOCOLATE.tag);
        prov.tag(VERTICAL_SLABS__CHOCOLATE.tag)
            .addOptional(NeapolitanBlocks.CHOCOLATE_BRICK_VERTICAL_SLAB.getId())
            .addOptional(NeapolitanBlocks.CHOCOLATE_TILE_VERTICAL_SLAB.getId());
        prov.tag(ModTags.TRAY_HEAT_SOURCES)
            .add(AllBlocks.LIT_BLAZE_BURNER.get())
            .add(AllBlocks.BLAZE_BURNER.get());
        prov.tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
            .addOptional(ModBlocks.COOKING_POT.getId())
            .addOptional(FRBlocks.KETTLE.getId());
//            .addOptional(MDBlocks.COPPER_POT.getId());
    }
    
}
