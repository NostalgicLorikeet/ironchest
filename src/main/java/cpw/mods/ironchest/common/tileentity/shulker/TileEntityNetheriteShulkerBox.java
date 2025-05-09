package cpw.mods.ironchest.common.tileentity.shulker;

import cpw.mods.ironchest.common.blocks.shulker.IronShulkerBoxType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;

import javax.annotation.Nullable;

public class TileEntityNetheriteShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntityNetheriteShulkerBox()
    {
        this(null);
    }

    public TileEntityNetheriteShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(colorIn, IronShulkerBoxType.NETHERITE);
    }

    public static void registerFixesShulkerBox(DataFixer fixer)
    {
        fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityNetheriteShulkerBox.class, new String[] { "Items" }));
    }
}