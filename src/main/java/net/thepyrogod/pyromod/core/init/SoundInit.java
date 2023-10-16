package net.thepyrogod.pyromod.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepyrogod.pyromod.PyroMod;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PyroMod.MOD_ID);

    public static final RegistryObject<SoundEvent> SOUND_WEED = registerSoundEventsVariable("sound_weed");

    public static final RegistryObject<SoundEvent> SOUND_DISC_WEED = registerSoundEventsVariable("sound_disc_weed");

    private static RegistryObject<SoundEvent> registerSoundEventsFixed(String name, float range) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(PyroMod.MOD_ID, name), range));
    }

    private static RegistryObject<SoundEvent> registerSoundEventsVariable(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PyroMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
