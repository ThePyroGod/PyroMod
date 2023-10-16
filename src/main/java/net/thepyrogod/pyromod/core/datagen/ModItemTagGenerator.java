package net.thepyrogod.pyromod.core.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.thepyrogod.pyromod.PyroMod;
import net.thepyrogod.pyromod.core.init.ItemInit;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,
                               @Nullable ExistingFileHelper fileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, PyroMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        System.out.println("ADDED TAG TO WEED DISC");
        System.out.println("ADDED TAG TO WEED DISC");
        System.out.println("ADDED TAG TO WEED DISC");
        System.out.println("ADDED TAG TO WEED DISC");
        System.out.println("ADDED TAG TO WEED DISC");
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ItemInit.WEED_MUSIC_DISC.get());
        System.out.println(ItemInit.WEED_MUSIC_DISC.get().asItem());
    }
}
