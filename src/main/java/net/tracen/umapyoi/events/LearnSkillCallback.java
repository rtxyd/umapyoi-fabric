package net.tracen.umapyoi.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.resources.ResourceLocation;

public interface LearnSkillCallback {
    void callback(ResourceLocation skill);

    Event<LearnSkillCallback> EVENT = EventFactory.createArrayBacked(LearnSkillCallback.class,
            (listeners) -> (skill) -> {
                for (LearnSkillCallback listener : listeners) {
                    listener.callback(skill);
                }
            });

    static void invoke(ResourceLocation skill) {
        EVENT.invoker().callback(skill);
    }
}
