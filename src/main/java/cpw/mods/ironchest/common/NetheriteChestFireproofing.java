package cpw.mods.ironchest.common;

import cpw.mods.ironchest.common.entity.EntityItemNetheriteChest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Objects;

public class NetheriteChestFireproofing {
    public static Item IRON_CHEST_ITEM = null;

    //Mostly derived from https://github.com/Jboymercs/nether_backport/blob/20b89ea14bd43c244c63675b028b8a7cdb887cfa/src/main/java/com/unseen/nb/common/EntityEvents.java
    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {
        World world = event.getWorld();
        if (!event.getWorld().isRemote) {
            if (event.getEntity() instanceof EntityItem entityItem) {
                if (!(event.getEntity() instanceof EntityItemNetheriteChest)) {
                    ItemStack item = entityItem.getItem();

                    if (IRON_CHEST_ITEM == null) {
                        IRON_CHEST_ITEM = Item.REGISTRY.getObject(new ResourceLocation("ironchest:iron_chest"));
                    }

                    //find a better way to do this
                    if (item.getItem() == IRON_CHEST_ITEM && item.getItemDamage() == 9 ||
                            (item.getItem().getRegistryName().toString().startsWith("ironchest:iron_shulker_box_") && item.getItemDamage() == 7)) {
                        if (!item.isEmpty()) {
                            EntityItemNetheriteChest chest = new EntityItemNetheriteChest(world, entityItem, item);
                            entityItem.setDead();
                            world.spawnEntity(chest);
                        }
                    }
                }
            }
        }
    }
}