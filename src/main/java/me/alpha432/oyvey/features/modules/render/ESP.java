package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.event.impl.Render3DEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.MinecraftClient;

public class ESP extends Module {
    public ESP() {
        super("ESP", "Draws boxes around entities", Category.RENDER, true, false, false);
    }

    @Override
    public void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        MatrixStack matrixStack = event.getMatrixStack();
        VertexConsumerProvider vertexConsumers = event.getVertexConsumers();
        Camera camera = mc.gameRenderer.getCamera();

        if (mc.world == null || mc.player == null) return;

        for (Entity entity : mc.world.getEntities()) {
            if (!(entity instanceof LivingEntity)) continue;
            if (entity == mc.player) continue; // Ignore toi-même

            // Ici on dessine une boîte autour de l'entité
            drawEntityBox(entity, matrixStack, vertexConsumers);
        }
    }

    private void drawEntityBox(Entity entity, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers) {
        // Position et taille de l'entité
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        double width = entity.getWidth() / 2.0;
        double height = entity.getHeight();

        // Pour un dessin simple, tu peux utiliser des utilitaires d’Oyvey/Insomnia 
        // ou directement OpenGL via RenderSystem (glLineWidth, glBegin(GL_LINES), etc.)
        // Exemple : dessiner une boîte filaire autour de l'entité (pas un vrai code, idée seulement)

        // TODO : Insomnia/Oyvey ont souvent une classe RenderUtil, cherche dans leur code pour drawBoundingBox ou drawOutlineBox

        // Exemple pseudo-code (à adapter) :
        // RenderUtil.drawBoundingBox(new Box(x - width, y, z - width, x + width, y + height, z + width), color);
    }
}
