package net.irreleven.mintstate.block.entity;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.irreleven.mintstate.item.ModItems;
import net.irreleven.mintstate.recipe.TheCrucibleRecipe;
import net.irreleven.mintstate.screen.TheCrucibleScreenHandler;
import net.minecraft.SharedConstants;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.Optional;

public class TheCrucibleBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize (9, ItemStack.EMPTY);
    private static final int FUEL_SLOT_INDEX = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int INPUT_SLOT_4 = 3;
    private static final int OUTPUT_SLOT_1 = 4;
    private static final int OUTPUT_SLOT_2 = 5;
    private static final int OUTPUT_SLOT_3 = 6;
    private static final int OUTPUT_SLOT_4 = 7;
    private static final int OUTPUT_SLOT_5 = 8;



    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;


    public TheCrucibleBlockEntity(BlockPos pos, BlockState state) {
        super (ModBlockEntities.THE_CRUCIBLE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate () {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> TheCrucibleBlockEntity.this.progress;
                    case 1 -> TheCrucibleBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> TheCrucibleBlockEntity.this.progress = value;
                    case 1 -> TheCrucibleBlockEntity.this.maxProgress = value;

                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos (this.pos);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable ("The Crucible");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt (nbt);
        Inventories.writeNbt (nbt, inventory);
        nbt.putInt ("the_crucible.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt (nbt);
        Inventories.readNbt (nbt, inventory);
        progress = nbt.getInt ("the_crucible.progress");

    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TheCrucibleScreenHandler (syncId, playerInventory, this, this.propertyDelegate);
    }


    public void tick(World world, BlockPos pos, BlockState state) {

        if(world.isClient()) {

            return;

        }

        if(isOutputSlotEmptyOrRecievable()) {
            if(this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty (world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }

            }else {
                this.resetProgress();
            }
        }else{
            this.resetProgress();
            markDirty (world, pos, state);
        }

    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<TheCrucibleRecipe>> recipe = getCurrentRecipe();

        this.removeStack (FUEL_SLOT_INDEX & INPUT_SLOT_2 & INPUT_SLOT_3 & INPUT_SLOT_4,1);


        this.setStack (OUTPUT_SLOT_1, new ItemStack (recipe.get ().value ().getResult (null).getItem (), getStack (OUTPUT_SLOT_1).getCount () + recipe.get ().value ().getResult (null).getCount ()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {

        Optional<RecipeEntry<TheCrucibleRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent () && canInsertAmountIntoOutputSlot(recipe.get ().value ().getResult (null))
                && canInsertItemIntoOutputSlot(recipe.get ().value ().getResult (null).getItem ());
    }

    private Optional<RecipeEntry<TheCrucibleRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory (this.size ());
        for (int i = 0; i < this.size (); i++) {
            inv.setStack (i, this.getStack (i));
            
        }
        return getWorld ().getRecipeManager ().getFirstMatch (TheCrucibleRecipe.Type.INSTANCE, inv, getWorld ());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack (OUTPUT_SLOT_1 & OUTPUT_SLOT_2 & OUTPUT_SLOT_3 & OUTPUT_SLOT_4 & OUTPUT_SLOT_5).getItem () == item || this.getStack (OUTPUT_SLOT_1 & OUTPUT_SLOT_2 & OUTPUT_SLOT_3 & OUTPUT_SLOT_4 & OUTPUT_SLOT_5).isEmpty ();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack (OUTPUT_SLOT_1 & OUTPUT_SLOT_2 & OUTPUT_SLOT_3 & OUTPUT_SLOT_4 & OUTPUT_SLOT_5).getCount () + result.getCount () > getStack (OUTPUT_SLOT_1 & OUTPUT_SLOT_2 & OUTPUT_SLOT_3 & OUTPUT_SLOT_4 & OUTPUT_SLOT_5).getMaxCount ();
    }

    private boolean isOutputSlotEmptyOrRecievable() {
        return this.getStack(OUTPUT_SLOT_1).isEmpty ()
                || this.getStack (OUTPUT_SLOT_2).isEmpty ()
                || this.getStack (OUTPUT_SLOT_3).isEmpty ()
                || this.getStack (OUTPUT_SLOT_4).isEmpty ()
                || this.getStack (OUTPUT_SLOT_5).isEmpty ()
                || this.getStack (OUTPUT_SLOT_1).getCount () < this.getStack (OUTPUT_SLOT_1).getMaxCount ()
                || this.getStack (OUTPUT_SLOT_2).getCount () < this.getStack (OUTPUT_SLOT_2).getMaxCount ()
                || this.getStack (OUTPUT_SLOT_3).getCount () < this.getStack (OUTPUT_SLOT_3).getMaxCount ()
                || this.getStack (OUTPUT_SLOT_4).getCount () < this.getStack (OUTPUT_SLOT_4).getMaxCount ()
                || this.getStack (OUTPUT_SLOT_5).getCount () < this.getStack (OUTPUT_SLOT_5).getMaxCount ();
    }


}
