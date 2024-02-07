package net.tracen.umapyoi.attributes;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.tracen.umapyoi.Umapyoi;

public class ExtraAttributes {
    public static final Attribute STEP_HEIGHT_ADDITION = new RangedAttribute("umapyoi.step_height", 0.0D, -512.0D, 512.0D).setSyncable(true);
    public static final Attribute SWIM_SPEED = new RangedAttribute("umapyoi.swim_speed", 1.0D, 0.0D, 1024.0D).setSyncable(true);

    public static void register() {
        Registry.register(BuiltInRegistries.ATTRIBUTE, new ResourceLocation(Umapyoi.MODID, "step_height_addition"), STEP_HEIGHT_ADDITION);
        Registry.register(BuiltInRegistries.ATTRIBUTE, new ResourceLocation(Umapyoi.MODID, "swim_speed"), SWIM_SPEED);
    }
}
