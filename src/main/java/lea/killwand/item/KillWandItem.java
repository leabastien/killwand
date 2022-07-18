package lea.killwand.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class KillWandItem extends Item {

    public KillWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.killwand.kill_wand.tooltip").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            Integer i = 0;
            for (Entity entity : ((ServerWorld) world).iterateEntities() ) {
                if (entity != null) {
                    if (!(entity instanceof PlayerEntity)) {
                        entity.kill();
                        i++;
                    }
                }
            }
            user.sendMessage(Text.literal("Killed " + i + " entities"));
        }
        return super.use(world, user, hand);
    }
}
