package net.thepyrogod.pyromod.common.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thepyrogod.pyromod.PyroMod;
import net.thepyrogod.pyromod.core.init.ItemInit;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PyroMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.pyro_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemInit.EXAMPLE_ITEM.get());
                        pOutput.accept(ItemInit.WEED.get());
                        pOutput.accept(ItemInit.WEED_MUSIC_DISC.get());

                        pOutput.accept(Items.DIAMOND);

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
