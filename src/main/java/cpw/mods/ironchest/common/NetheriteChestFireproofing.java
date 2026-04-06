package cpw.mods.ironchest.common;

import cpw.mods.ironchest.common.entity.EntityItemNetheriteChest;
import cpw.mods.ironchest.common.items.chest.ItemIronChest;
import cpw.mods.ironchest.common.items.shulker.ItemIronShulkerBox;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NetheriteChestFireproofing {
    //Mostly derived from https://github.com/Jboymercs/nether_backport/blob/20b89ea14bd43c244c63675b028b8a7cdb887cfa/src/main/java/com/unseen/nb/common/EntityEvents.java
    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {
        World world = event.getWorld();
        if (!event.getWorld().isRemote) {
            if (event.getEntity() instanceof EntityItem entityItem) {
                if (!(event.getEntity() instanceof EntityItemNetheriteChest)) {
                    ItemStack item = entityItem.getItem();

                    if (item.getItem() instanceof ItemIronChest && item.getItemDamage() == 9 ||
                            (item.getItem() instanceof ItemIronShulkerBox && item.getItemDamage() == 7)) {
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