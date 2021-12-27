package shadowmaster435.vertexshapes.init;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import shadowmaster435.vertexshapes.block.Test;

public class VertexShapesBlocks {
    public static final Test TEST = new Test(Block.Settings.of(Material.STONE).nonOpaque());

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier("vertexshapes", "test"), TEST);
        Registry.register(Registry.ITEM, new Identifier("vertexshapes", "test"), new BlockItem(TEST, new Item.Settings().group(ItemGroup.MISC)));
    }
    public static void initclient() {
    }
}
