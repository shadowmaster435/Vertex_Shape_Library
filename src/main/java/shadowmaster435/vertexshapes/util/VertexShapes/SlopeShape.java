package shadowmaster435.vertexshapes.util.VertexShapes;

import net.minecraft.util.math.Vec3f;

import java.util.ArrayList;
import java.util.Locale;

public class SlopeShape {
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

    public static ArrayList<Vec3f> rot = new ArrayList<>();
    public static ArrayList<Vec3f> slopeverts = new ArrayList<>();

    // Long and (possibly) janky way to do this but it works so im keeping this for now

    public SlopeShape(Vec3f bottomleft, Vec3f bottomright, Vec3f top, float depth, String axis) {
        float deepness = depth * 0.0625f;
        float x;
        float y;
        float z;
        float y1;
        float x1;
        float z1;
        float x2;
        float y2;
        float z2;
        Vec3f point1;
        Vec3f point2;
        Vec3f point3;
        Vec3f point4;
        Vec3f point5;
        Vec3f point6;
        Vec3f point7;
        Vec3f point8;
        Vec3f point9;
        Vec3f point10;
        Vec3f point11;
        Vec3f point12;

        switch (axis.toLowerCase(Locale.ROOT)) {
            case "x" -> {
                x = bottomleft.getZ() * 0.0625f;
                y = bottomleft.getY() * 0.0625f;
                z = bottomleft.getX() * 0.0625f;
                y1 = bottomright.getY() * 0.0625f;
                z1 = bottomright.getX() * 0.0625f;
                y2 = top.getY() * 0.0625f;
                z2 = top.getX() * 0.0625f;
                point1 = new Vec3f(x, y, z);
                point2 = new Vec3f(x, y2, z2);
                point3 = new Vec3f(x + deepness, y2 , z2);
                point4 = new Vec3f(x + deepness, y, z);
                point5 = point1;
                point6 = new Vec3f(x, y1, z1);
                point7 = new Vec3f(x, y2, z2);
                point8 = point6;
                point9 = new Vec3f(x + deepness, y1, z1);
                point10 = point3;
                point11 = point9;
                point12 = point4;
            }
            case "y" -> {
                x = bottomleft.getX() * 0.0625f;
                y = bottomleft.getZ() * 0.0625f;
                z = bottomleft.getY() * 0.0625f;
                x1 = bottomright.getX() * 0.0625f;
                z1 = bottomright.getY() * 0.0625f;
                x2 = top.getX() * 0.0625f;
                z2 = top.getY() * 0.0625f;
                point1 = new Vec3f(x, y, z);
                point2 = new Vec3f(x2, y, z2);
                point3 = new Vec3f(x2, y + deepness, z2);
                point4 = new Vec3f(x, y + deepness, z);
                point5 = point1;
                point6 = new Vec3f(x1, y, z1);
                point7 = new Vec3f(x2, y, z2);
                point8 = point6;
                point9 =  new Vec3f(x1, y + deepness, z1);
                point10 = point3;
                point11 = point9;
                point12 = point4;

            }
            case "z" -> {
                x = bottomleft.getX() * 0.0625f;
                y = bottomleft.getY() * 0.0625f;
                z = bottomleft.getZ() * 0.0625f;
                x1 = bottomright.getZ()  * 0.0625f;
                y1 = bottomright.getY() * 0.0625f;
                x2 = top.getX() * 0.0625f;
                y2 = top.getY() * 0.0625f;
                point1 = new Vec3f(x, y, z);
                point2 = new Vec3f(x2, y2, z);
                point3 = new Vec3f(x2, y2, z + deepness);
                point4 = new Vec3f(x, y, z + deepness);
                point5 = point1;
                point6 = new Vec3f(x1, y1, z);
                point7 = new Vec3f(x2, y2, z);
                point8 = point6;
                point9 =  new Vec3f(x1, y1, z + deepness);
                point10 = point3;
                point11 = point9;
                point12 = point4;
            }
            default -> {
                x = bottomleft.getX() * 0.0625f;
                y = bottomleft.getY() * 0.0625f;
                z = bottomleft.getZ() * 0.0625f;
                x1 = bottomright.getZ()  * 0.0625f;
                y1 = bottomright.getY() * 0.0625f;
                x2 = top.getX() * 0.0625f;
                y2 = top.getY() * 0.0625f;
                point1 = new Vec3f(x, y, z);
                point2 = new Vec3f(x2, y2, z);
                point3 = new Vec3f(x2, y2, z + deepness);
                point4 = new Vec3f(x, y, z + deepness);
                point5 = point1;
                point6 = new Vec3f(x1, y1, z);
                point7 = new Vec3f(x2, y2, z);
                point8 = point6;
                point9 =  new Vec3f(x1, y1, z + deepness);
                point10 = point3;
                point11 = point9;
                point12 = point4;
                System.out.println("Invalid Axis: " + axis + " Using Default");
            }
        }

        /*
              visualization helper

           ,.
          ╱ |
        ╱___|


              ⟋/|
           ⟋ ⟋| |
         ⟋_⟋__|_|
        /⟋    |/
       ⟋______/

        */



        vert1 = point1;

        vert2 = point2;

        vert3 = point3;

        vert4 = point4;

        vert5 = point5;

        vert6 = point6;

        vert7 = point7;

        vert8 = point8;

        vert9 = point9;

        vert10 = point10;

        vert11 = point11;

        vert12 = point12;


        slopeverts.add(vert1);
        slopeverts.add(vert2);
        slopeverts.add(vert3);
        slopeverts.add(vert4);
        slopeverts.add(vert5);
        slopeverts.add(vert6);
        slopeverts.add(vert7);
        slopeverts.add(vert8);
        slopeverts.add(vert9);
        slopeverts.add(vert10);
        slopeverts.add(vert11);
        slopeverts.add(vert12);
    }

    public static ArrayList<Vec3f> Slope(Vec3f p1, Vec3f p2, Vec3f p3, float depth, String axis) {
        new SlopeShape(p1, p2, p3, depth, axis);
        for (int i = 0; i < (slopeverts.size() - 1); ++i) {
            rot = slopeverts;
        }
        VertexShape.vec3fvertindexindex.add(rot);
        return rot;
    }
}
