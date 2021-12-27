package shadowmaster435.vertexshapes.block;

import net.minecraft.block.Block;
import net.minecraft.util.math.Vec3f;
import shadowmaster435.vertexshapes.util.VertexShapes.SlopeShape;
import shadowmaster435.vertexshapes.util.VertexShapes.VertexShape;

import java.util.ArrayList;

public class Test extends Block {

    public static ArrayList<Vec3f> verts;

    public Test(Settings settings) {
        super(settings);
        VertexShape.vsshapeblock.add(this);
        // Cuboid Example
        // verts = CuboidShape.Cuboid(new Vec3f(2f, 2f, 2f), new Vec3f(4f, 4f, 4f), new Vec3f(25, 0 ,0));

        // Slope/Prism Example
        verts = SlopeShape.Slope(new Vec3f(0f,0f,1f) /*Vertex 1/Start Vertex */, new Vec3f(16f,0f,0f) /*Vertex 2*/, new Vec3f(8f, 16f, 0f) /*Vertex 3*/, 14f /*16 = 1 full block*/, "x" /*Axis Aligned Rotation*/);

        new VertexShape(verts, "slope", true);
    }
}
