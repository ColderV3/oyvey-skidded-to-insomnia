package me.alpha432.insomnia.features.modules.client;

import me.alpha432.insomnia.Insomnia;
import me.alpha432.oyvey.event.impl.Render2DEvent;
import me.alpha432.oyvey.features.modules.Module;

public class HudModule extends Module {
    public HudModule() {
        super("Hud", "hud", Category.CLIENT, true, false, false);
    }

    @Override public void onRender2D(Render2DEvent event) {
        event.getContext().drawTextWithShadow(
                mc.textRenderer,
                Insomnia.NAME + " " + Insomnia.VERSION

                2, 2,
                -1
        );
    }
}
