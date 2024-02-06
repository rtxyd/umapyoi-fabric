package net.tracen.umapyoi.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface ResumeActionPointCallback {
    /**
     * @return Whether to cancel the event
     */
    boolean callback(LivingEntity entity, ItemStack soul);

    Event<ResumeActionPointCallback> EVENT = EventFactory.createArrayBacked(ResumeActionPointCallback.class,
            (listeners) -> (entity, soul) -> {
                for (ResumeActionPointCallback listener : listeners) {
                    if (listener.callback(entity, soul)) return true;
                }
                return false;
            });

    static boolean invoke(LivingEntity entity, ItemStack soul) {
        return EVENT.invoker().callback(entity, soul);
    }
}