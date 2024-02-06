package net.tracen.umapyoi.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
/**
 * Replacement for Forge's AnvilUpdateEvent
 */
public interface AnvilUpdateCallback {
    class Result {
        public final boolean cancel;
        public final ItemStack output;
        public final int cost;
        public final int materialCost;

        private Result(boolean cancel, ItemStack output, int cost, int materialCost) {
            this.cancel = cancel;
            this.output = output;
            this.cost = cost;
            this.materialCost = materialCost;
        }

        public static Result cancelled() {
            return new Result(true, null, 0, 0);
        }

        public static Result empty() {
            return new Result(false, ItemStack.EMPTY, 0, 0);
        }

        public static Result pass(ItemStack output, int cost, int materialCost) {
            return new Result(false, output, cost, materialCost);
        }
    }

    Result callback(ItemStack left, ItemStack right, String name, int baseCost, Player player);

    Event<AnvilUpdateCallback> EVENT = EventFactory.createArrayBacked(AnvilUpdateCallback.class,
            (listeners) -> (left, right, name, baseCost, player) -> {
                var result = Result.empty();
                for (AnvilUpdateCallback listener : listeners) {
                    var tmp = listener.callback(left, right, name, baseCost, player);
                    if (tmp.cancel) return tmp;
                    if (!tmp.output.isEmpty()) result = tmp;
                }
                return result;
            });

    static Result invoke(ItemStack left, ItemStack right, String name, int baseCost, Player player) {
        return EVENT.invoker().callback(left, right, name, baseCost, player);
    }
}
