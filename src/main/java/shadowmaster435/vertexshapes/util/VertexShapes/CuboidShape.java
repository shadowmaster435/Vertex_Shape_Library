package shadowmaster435.vertexshapes.util.VertexShapes;

import net.minecraft.util.math.Vec3f;

import java.util.ArrayList;

public class CuboidShape {
    public static Vec3f vert1;
    public static Vec3f vert2;
    public static Vec3f vert3;
    public static Vec3f vert4;
    public static Vec3f vert5;
    public static Vec3f vert6;
    public static Vec3f vert7;
    public static Vec3f vert8;
    public static Vec3f vert9;
    public static Vec3f vert10;
    public static Vec3f vert11;
    public static Vec3f vert12;
    public static Vec3f vert13;
    public static Vec3f vert14;
    public static Vec3f vert15;
    public static Vec3f vert16;

    public static ArrayList<Vec3f> rot = new ArrayList<>();
    public static ArrayList<Vec3f> cubeverts = new ArrayList<>(8);

    public CuboidShape(Vec3f start, Vec3f end) {
        float x = start.getX() / 16;
        float y = start.getY() / 16;
        float z = start.getZ() / 16;
        float x1 = end.getX() / 16;
        float y1 = end.getY() / 16;
        float z1 = end.getZ() / 16;

        // Listed directions are correspondent to which direction the next vertex is in

        vert1 = new Vec3f(x, y, z);

        //up
        vert2 = new Vec3f(x, y1, z);

        //south
        vert3 = new Vec3f(x, y1, z1);

        //down
        vert4 = new Vec3f(x, y, z1);

        //up
        vert5 = new Vec3f(x, y1, z1);

        //east
        vert6 = new Vec3f(x1, y1, z1);

        //down
        vert7 = new Vec3f(x1, y, z1);

        //up
        vert8 = new Vec3f(x1, y1, z1);

        //north
        vert9 = new Vec3f(x1, y1, z);

        //down
        vert10 = new Vec3f(x1, y, z);

        //up
        vert11 = new Vec3f(x1, y1, z);

        //west
        vert12 = new Vec3f(x, y1, z);

        //down
        vert13 = new Vec3f(x, y, z);

        //south
        vert14 = new Vec3f(x, y, z1);

        //east
        vert15 = new Vec3f(x1, y, z1);

        //north
        vert16 = new Vec3f(x1, y, z);

        cubeverts.add(vert1);
        cubeverts.add(vert2);
        cubeverts.add(vert3);
        cubeverts.add(vert4);
        cubeverts.add(vert5);
        cubeverts.add(vert6);
        cubeverts.add(vert7);
        cubeverts.add(vert8);
        cubeverts.add(vert9);
        cubeverts.add(vert10);
        cubeverts.add(vert11);
        cubeverts.add(vert12);
        cubeverts.add(vert13);
        cubeverts.add(vert14);
        cubeverts.add(vert15);
        cubeverts.add(vert16);
        cubeverts.add(start);
    }
    public static ArrayList<Vec3f> Cuboid(Vec3f start, Vec3f end, Vec3f rotations) {
        new CuboidShape(start, end);
        for (int i = 0; i < (cubeverts.size() - 1); ++i) {
            rot = Rotate.rotate(rotations.getX(), rotations.getY(), rotations.getZ(), cubeverts);
        }
        VertexShape.vec3fvertindexindex.add(rot);
        return rot;
    }
}
