package net.thepyrogod.pyromod.common.items;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.thepyrogod.pyromod.core.init.SoundInit;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class Weed extends Item {
    public Weed(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.translatable("This has caused me so much anguish"));
        if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(Component.translatable("\u00A75Doom Metal haha lol"));
        }
        else tooltip.add(Component.translatable("tooltip.special_item.hold_shift"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        if(!playerIn.getCooldowns().isOnCooldown(this)) {
            playerIn.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
            playerIn.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
            playerIn.getCooldowns().addCooldown(this, 800);//12,000
            playerIn.playSound(SoundInit.SOUND_WEED.get(), 1, 1);

            return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
        }
        return InteractionResultHolder.fail(playerIn.getItemInHand(handIn));
    }
}
