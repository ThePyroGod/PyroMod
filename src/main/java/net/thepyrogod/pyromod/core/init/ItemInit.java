package net.thepyrogod.pyromod.core.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepyrogod.pyromod.PyroMod;
import net.thepyrogod.pyromod.common.items.Weed;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PyroMod.MOD_ID);
    // Normal Items
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WEED_MUSIC_DISC = ITEMS.register("weed_music_disc", () ->
            new RecordItem(6, SoundInit.SOUND_DISC_WEED, new Item.Properties().stacksTo(1), 1840)); //ticks are seconds x 20(frames)

    public static final RegistryObject<Item> WEED = ITEMS.register("weed", () -> new Weed(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
