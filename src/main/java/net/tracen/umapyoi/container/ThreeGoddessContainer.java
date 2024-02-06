package net.tracen.umapyoi.container;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.tracen.umapyoi.block.BlockRegistry;
import net.tracen.umapyoi.block.entity.ThreeGoddessBlockEntity;
import net.tracen.umapyoi.item.ItemRegistry;

import java.util.Objects;

public class ThreeGoddessContainer extends AbstractContainerMenu {
    public final ThreeGoddessBlockEntity tileEntity;
    private final ContainerData containerData;
    private final ContainerLevelAccess canInteractWithCallable;

    public ThreeGoddessContainer(final int windowId, final Inventory playerInventory, FriendlyByteBuf buf) {
        this(windowId, playerInventory, getTileEntity(playerInventory, buf), new SimpleContainerData(4));
    }

    public ThreeGoddessContainer(final int windowId, final Inventory playerInventory,
                                 final ThreeGoddessBlockEntity tileEntity, ContainerData dataIn) {
        super(ContainerRegistry.THREE_GODDESS.get(), windowId);
        this.tileEntity = tileEntity;
        this.containerData = dataIn;
        this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());
        int startX = 8;

        this.addSlot(new ThreeGoddessJewelSlot(tileEntity, 0, 80, 27));

        this.addSlot(new ThreeGoddessFactorSlot(tileEntity, 1, 50, 78));
        this.addSlot(new ThreeGoddessFactorSlot(tileEntity, 2, 109, 78));

        this.addSlot(new CommonResultSlot(playerInventory.player, tileEntity, 3, 80, 79));

        // Main Player Inventory
        int startPlayerInvY = 137;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * 18),
                        startPlayerInvY + (row * 18)));
            }
        }

        // Hotbar
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * 18), 195));
        }

        this.addDataSlots(dataIn);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();

            if (index >= 0 && index <= 3) {
                if (!this.moveItemStackTo(itemStack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack1, itemStack);
            } else if (index >= 4) {
                if (index >= 4 && index < 40) {
                    if (!this.moveItemStackTo(itemStack1, 0, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }
            
            if (itemStack1.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemStack1);
        }

        return itemStack;
    }

    private static ThreeGoddessBlockEntity getTileEntity(final Inventory playerInventory, FriendlyByteBuf buf) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        final Player player = playerInventory.player;
        final BlockEntity tileAtPos = player.level().getBlockEntity(buf.readBlockPos());
        if (tileAtPos instanceof ThreeGoddessBlockEntity) {
            return (ThreeGoddessBlockEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(canInteractWithCallable, playerIn, BlockRegistry.THREE_GODDESS.get());
    }

    @Environment(EnvType.CLIENT)
    public int getProgressionScaled() {
        int i = this.containerData.get(0);
        return i != 0 ? i * 158 / ThreeGoddessBlockEntity.MAX_PROCESS_TIME : 0;
    }

    public static class ThreeGoddessJewelSlot extends Slot {

        public ThreeGoddessJewelSlot(ThreeGoddessBlockEntity container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            if (stack.is(ItemRegistry.BLANK_UMA_SOUL.get())) {
                String name = stack.getOrCreateTag().getString("name");
                return !(name.equals(container.getItem(1).getOrCreateTag().getString("name"))
                        || name.equals(container.getItem(2).getOrCreateTag().getString("name")));
            }
            return false;
        }

        @Override
        public int getMaxStackSize(ItemStack stack) {
            return 1;
        }
    }

    public static class ThreeGoddessFactorSlot extends Slot {
        public ThreeGoddessFactorSlot(ThreeGoddessBlockEntity container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            boolean result = stack.is(ItemRegistry.UMA_FACTOR_ITEM.get());
            boolean factorFlag = false;
            var soulStack = container.getItem(0);
            boolean soulFlag = !soulStack.isEmpty() && stack.getOrCreateTag().getString("name")
                    .equals(soulStack.getOrCreateTag().getString("name"));

            switch (this.getContainerSlot()) {
            case 1: {
                factorFlag = stack.getOrCreateTag().getString("name")
                        .equals(container.getItem(2).getOrCreateTag().getString("name"));
                break;
            }
            case 2: {
                factorFlag = stack.getOrCreateTag().getString("name")
                        .equals(container.getItem(1).getOrCreateTag().getString("name"));
                break;
            }
            default:
                break;
            }

            return result && !soulFlag && !factorFlag;
        }
    }

}
