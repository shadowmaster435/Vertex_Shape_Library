package shadowmaster435.vertexshapes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import shadowmaster435.vertexshapes.init.VertexShapesBlocks;

@Environment(EnvType.CLIENT)
public class VertexShapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        VertexShapesBlocks.initclient();
    }
}
