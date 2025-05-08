package cpw.mods.ironchest.common;

import cpw.mods.ironchest.common.entity.EntityItemNetheriteChest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NetheriteChestFireproofing {
    //Mostly derived from https://github.com/Jboymercs/nether_backport/blob/20b89ea14bd43c244c63675b028b8a7cdb887cfa/src/main/java/com/unseen/nb/common/EntityEvents.java
    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {
        if(event.getEntity().getClass() == EntityItem.class) {
            World world = event.getWorld();

            EntityItem entityItem = (EntityItem)event.getEntity();
            ItemStack item = entityItem.getItem();

            if (item.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("ironchest:iron_chest")) && item.getItemDamage() == 9) {
                if(!item.isEmpty()) {
                    EntityItemNetheriteChest chest = new EntityItemNetheriteChest(world, entityItem, item);
                    world.spawnEntity(chest);
                    entityItem.setDead();
                }
            }
        }
    }
}