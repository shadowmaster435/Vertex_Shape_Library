package shadowmaster435.vertexshapes.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import shadowmaster435.vertexshapes.util.VertexShapes.VertexShape;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow private int ticks;

    /**
     * @author shadowmaster435
     */
    @Overwrite
    private static void drawShapeOutline(MatrixStack matrices, VertexConsumer vertexConsumer, VoxelShape voxelShape, double d, double e, double f, float g, float h, float i, float j) {
        MatrixStack.Entry entry = matrices.peek();
        ClientWorld world = MinecraftClient.getInstance().world;
        assert MinecraftClient.getInstance().player != null;
        BlockPos pos = MinecraftClient.getInstance().player.getBlockPos();
        assert world != null;
        BlockPos pos1 = new BlockPos(new BlockPos(Math.floor(d + pos.getX()) + 0.5, Math.floor(e + pos.getY() + 1.5), Math.floor(f + pos.getZ()  + 1)));
        Vec3d posd1 = new Vec3d(pos.getX(),pos.getY() + 1.5,pos.getZ());
        Vec3d posd2 = new Vec3d(pos1.getX(),pos1.getY(),pos1.getZ());
        // The pain of raycasting this crap... and yet still isn't targetting the selected block right AAA
        System.out.println(world.raycast(new RaycastContext(posd1, posd2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, MinecraftClient.getInstance().player)).getBlockPos());
        if (VertexShape.vsshapeblock.contains(world.getBlockState(world.raycast(new RaycastContext(posd1, posd2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, MinecraftClient.getInstance().player)).getBlockPos()).getBlock())) {
            if (MinecraftClient.getInstance().crosshairTarget != null && MinecraftClient.getInstance().player != null) {

                // Iterate Through Verticies then draw lines accordingly

                for (int n = 0; n < VertexShape.vec3fvertindex.size() - 1; ++n) {
                        int nextindex;
                        if (n >= (VertexShape.vec3fvertindex.size() - 1)) {
                            nextindex = -(VertexShape.vec3fvertindex.size() - 1);
                        } else {
                            nextindex = 1;
                        }
                        float x = (VertexShape.vec3fvertindex.get(n).getX());
                        float y = (VertexShape.vec3fvertindex.get(n).getY());
                        float z = (VertexShape.vec3fvertindex.get(n).getZ());
                        float x1 = (VertexShape.vec3fvertindex.get(n + nextindex).getX());
                        float y1 = (VertexShape.vec3fvertindex.get(n + nextindex).getY());
                        float z1 = (VertexShape.vec3fvertindex.get(n + nextindex).getZ());
                        float q = x - x1;
                        float r = y - y1;
                        float s = z - z1;
                        float t = MathHelper.sqrt(q * q + r * r + s * s);

                        //Wip not yet working code
                        /*if (Objects.equals(VertexShape.shapeType, "slope")) {
                            switch (n) {
                                case 10 :
                                    vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, 0).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                                    vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, 0).normal(entry.getNormal(), q, r, s).next();
                                case 11 :
                                    vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, 0).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                                    vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, 0).normal(entry.getNormal(), q, r, s).next();
                                case 12 :
                                    vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, 0).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                                    vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, 0).normal(entry.getNormal(), q, r, s).next();
                                default :
                                    vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, j).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                                    vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, j).normal(entry.getNormal(), q, r, s).next();
                            }
                        } else {
                            vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, j).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                            vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, j).normal(entry.getNormal(), q, r, s).next();
                        }*/
                    vertexConsumer.vertex(entry.getModel(), (float) (x + d), (float) (y + e), (float) (z + f)).color(g, h, i, j).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                    vertexConsumer.vertex(entry.getModel(), (float) (x1 + d), (float) (y1 + e), (float) (z1 + f)).color(g, h, i, j).normal(entry.getNormal(), q, r, s).next();

                }
            }
        } else {
            voxelShape.forEachEdge((k, l, m, n, o, p) -> {
                float q = (float) (n - k);
                float r = (float) (o - l);
                float s = (float) (p - m);
                float t = MathHelper.sqrt(q * q + r * r + s * s);
                vertexConsumer.vertex(entry.getModel(), (float) (k + d), (float) (l + e), (float) (m + f)).color(g, h, i, j).normal(entry.getNormal(), q /= t, r /= t, s /= t).next();
                vertexConsumer.vertex(entry.getModel(), (float) (n + d), (float) (o + e), (float) (p + f)).color(g, h, i, j).normal(entry.getNormal(), q, r, s).next();
            });
        }
    }
}
