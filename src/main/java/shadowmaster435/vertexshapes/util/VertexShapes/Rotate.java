package shadowmaster435.vertexshapes.util.VertexShapes;
import net.minecraft.util.math.Vec3f;

import java.util.ArrayList;

public class Rotate {

    public static float x;
    public static float y;
    public static float z;
    public static ArrayList<Vec3f> result = new ArrayList<>();

    // IDK Man weird math necromancy related to vertex rotation around a point

    public static ArrayList<Vec3f> rotate(float xrot, float yrot, float zrot, ArrayList<Vec3f> verts) {
        var cosa = Math.cos(xrot);
        var sina = Math.sin(xrot);

        var cosb = Math.cos(yrot);
        var sinb = Math.sin(yrot);

        var cosc = Math.cos(zrot);
        var sinc = Math.sin(zrot);

        var Axx = cosa*cosb;
        var Axy = cosa*sinb*sinc - sina*cosc;
        var Axz = cosa*sinb*cosc + sina*sinc;

        var Ayx = sina*cosb;
        var Ayy = sina*sinb*sinc + cosa*cosc;
        var Ayz = sina*sinb*cosc - cosa*sinc;

        var Azx = -sinb;
        var Azy = cosb*sinc;
        var Azz = cosb*cosc;

        for (int i = 0; i < verts.size() - 1; ++i) {
           if (new Vec3f(xrot, yrot, zrot).equals(new Vec3f(0f,0f,0f))) {
               result.add(verts.get(i));
           } else {
               float px = verts.get(i).getX();

            float py = verts.get(i).getY();
            float pz = verts.get(i).getZ();

            x = (float) (Axx * px + Axy * py + Axz * pz);
            y = (float) (Ayx * px + Ayy * py + Ayz * pz);
            z = (float) (Azx * px + Azy * py + Azz * pz);
            result.add(new Vec3f(x,y,z));
           }
        }
        return result;
    }
}
