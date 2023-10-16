package net.thepyrogod.pyromod.common.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.UUID;

public class ModItem extends TieredItem {
    protected final EquipmentSlot slot;
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public ModItem(Tier tier, EquipmentSlot slot, Properties builderIn, float attack, float armor, float toughness,
                   float knockback, float speed, float health, float attackSpeed) {
        super(tier, builderIn);
        this.slot = slot;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (attackSpeed < 0) {
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
                    (double) attack, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",
                    (double) attackSpeed, AttributeModifier.Operation.ADDITION));
        } else {
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "Weapon modifier",
                    (double) attack, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "Weapon modifier",
                    (double) attackSpeed, AttributeModifier.Operation.ADDITION));
        }
        builder.put(Attributes.ARMOR, new AttributeModifier(UUID.randomUUID(), "Armor modifier", (double) armor,
                AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "Armor modifier",
                (double) toughness, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "Armor modifier",
                (double) knockback, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "Armor modifier",
                (double) speed, AttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(Attributes.MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), "Armor modifier", (double) health,
                AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, level, tooltip, flagIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return super.canAttackBlock(state, worldIn, pos, player);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }

    @SuppressWarnings("deprecation")
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == slot ? this.attributeModifiers : super.getDefaultAttributeModifiers(equipmentSlot);
    }
}