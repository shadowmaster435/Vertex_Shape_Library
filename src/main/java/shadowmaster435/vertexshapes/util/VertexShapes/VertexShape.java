package shadowmaster435.vertexshapes.util.VertexShapes;

import net.minecraft.block.Block;
import net.minecraft.util.math.Vec3f;

import java.util.ArrayList;

public class VertexShape {

    public static ArrayList<Vec3f> vec3fvertindex = new ArrayList<>(8);
    public static ArrayList<ArrayList<Vec3f>> vec3fvertindexindex = new ArrayList<>();

    public static String shapeType;
    public static boolean hasshape = false;
    public static ArrayList<Block> vsshapeblock = new ArrayList<>();


    public VertexShape(ArrayList<Vec3f> verts, String type, boolean hasshape) {
        shapeType = type;
        VertexShape.hasshape = hasshape;
        for (Vec3f vert : verts) {
            vec3fvertindex.add(new Vec3f(vert.getX(), vert.getY(), vert.getZ()));
        }
        vec3fvertindexindex.add(verts);
    }

}
