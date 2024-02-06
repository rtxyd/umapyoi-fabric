package net.tracen.umapyoi.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.item.ItemStack;
import net.tracen.umapyoi.registry.training.SupportStack;

public interface ApplyTrainingSupportCallback {
    /**
     * @return Whether to cancel the event
     */
    boolean callback(SupportStack stack, ItemStack soul);

    interface Pre extends ApplyTrainingSupportCallback {
        Event<Pre> EVENT = EventFactory.createArrayBacked(Pre.class,
                (listeners) -> (stack, soul) -> {
                    for (Pre listener : listeners) {
                        if (listener.callback(stack, soul)) return true;
                    }

                    return false;
                });

        static boolean invoke(SupportStack stack, ItemStack soul) {
            return EVENT.invoker().callback(stack, soul);
        }
    }

    interface Post extends ApplyTrainingSupportCallback {
        Event<Post> EVENT = EventFactory.createArrayBacked(Post.class,
                (listeners) -> (stack, soul) -> {
                    for (Post listener : listeners) {
                        if (listener.callback(stack, soul)) return true;
                    }

                    return false;
                });

        static boolean invoke(SupportStack stack, ItemStack soul) {
            return EVENT.invoker().callback(stack, soul);
        }
    }
}
