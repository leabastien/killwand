package lea.killwand;

import lea.killwand.item.KillWandItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Killwand implements ModInitializer {

    public static String modid = "killwand";

    public static final ItemGroup KILLWAND_ITEM_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(modid, modid))
            .icon(() -> new ItemStack(Killwand.KILL_WAND))
            .build();

    public static final Item KILL_WAND = new KillWandItem(new FabricItemSettings().group(Killwand.KILLWAND_ITEM_GROUP).maxCount(1));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(modid, "kill_wand"), KILL_WAND);

    }
}
