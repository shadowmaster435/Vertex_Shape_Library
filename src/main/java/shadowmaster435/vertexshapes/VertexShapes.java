package shadowmaster435.vertexshapes;

import net.fabricmc.api.ModInitializer;
import shadowmaster435.vertexshapes.init.VertexShapesBlocks;

public class VertexShapes implements ModInitializer {
    @Override
    public void onInitialize() {
        VertexShapesBlocks.init();
    }
}
