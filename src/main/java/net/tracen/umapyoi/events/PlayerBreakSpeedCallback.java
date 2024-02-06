package net.tracen.umapyoi.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;

public interface PlayerBreakSpeedCallback {
    float callback(Player player, float origSpeed);

    Event<PlayerBreakSpeedCallback> EVENT = EventFactory.createArrayBacked(PlayerBreakSpeedCallback.class,
            (listeners) -> (player, origSpeed) -> {
                var newSpeed = origSpeed;
                for (PlayerBreakSpeedCallback listener : listeners) {
                    newSpeed = listener.callback(player, origSpeed);
                }
                return newSpeed;
            });

    static float invoke(Player player, float origSpeed) {
        return EVENT.invoker().callback(player, origSpeed);
    }
}
