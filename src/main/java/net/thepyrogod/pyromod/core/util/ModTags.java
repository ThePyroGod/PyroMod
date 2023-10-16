package net.thepyrogod.pyromod.core.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.thepyrogod.pyromod.PyroMod;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NAME = tag("name"); //EXAMPLE

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(PyroMod.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> NAME = tag("name"); //EXAMPLE

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(PyroMod.MOD_ID, name));
        }
    }
}
