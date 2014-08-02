package com.jared.mysticaltrinkets.tileentities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPedestal extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	private int timer, spellID;
	private boolean startInfusion, infoCollected;
	private List<TileEntityPedestalItem> tiles = new ArrayList<TileEntityPedestalItem>(), tilesToGetFrom = new ArrayList<TileEntityPedestalItem>();
	private List<ItemStack> tempInventory = new ArrayList<ItemStack>();

	public TileEntityPedestal() {
		this.inventory = new ItemStack[1];
	}

	@Override
	public void updateEntity() {
		super.updateEntity();

		// tiles.clear();
	}

	public void spawnEffects() {
		worldObj.spawnParticle("flame", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("flame", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("flame", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("flame", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("flame", xCoord + 0.5, yCoord + 1.1, zCoord + 0.5, 0, 0, 0);
		worldObj.spawnParticle("smoke", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("smoke", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("smoke", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("smoke", xCoord + worldObj.rand.nextFloat(), yCoord + 1.1, zCoord + worldObj.rand.nextFloat(), 0, 0, 0);
		worldObj.spawnParticle("smoke", xCoord + 0.5, yCoord + 1.1, zCoord + 0.5, 0, 0, 0);
	}

	public void addPossibleTile(int x, int z) {
		TileEntity tile = worldObj.getTileEntity(xCoord + x, yCoord, zCoord + z);
		if (tile != null && tile instanceof TileEntityPedestalItem) {
			if (!tiles.contains(tile))
				tiles.add((TileEntityPedestalItem) tile);
		}
	}

	public void simpleReset() {
		this.spellID = -1;
		this.timer = 0;
		this.tiles.clear();
		for (TileEntityPedestalItem tile : this.tilesToGetFrom) {
			tile.setInventorySlotContents(0, null);
		}
		this.tilesToGetFrom.clear();
		this.startInfusion = false;
		this.infoCollected = false;
		this.tempInventory.clear();
	}

	public void reset() {
		this.spellID = -1;
		this.timer = 0;
		this.tiles.clear();
		this.tilesToGetFrom.clear();
		this.startInfusion = false;
		this.infoCollected = false;
		if (!this.tempInventory.isEmpty()) {
			for (ItemStack stack : this.tempInventory) {
				if (stack != null) {
					EntityItem ent = new EntityItem(worldObj, xCoord, yCoord, zCoord, stack);
					if (!worldObj.isRemote)
						worldObj.spawnEntityInWorld(ent);
				}
			}
		}
		this.tempInventory.clear();
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inventory[var1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.inventory[par1] != null) {
			ItemStack itemstack;

			if (this.inventory[par1].stackSize <= par2) {
				itemstack = this.inventory[par1];
				this.inventory[par1] = null;
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.inventory[par1].splitStack(par2);

				if (this.inventory[par1].stackSize == 0) {
					this.inventory[par1] = null;
				}

				this.markDirty();
				return itemstack;
			}
		} else
			return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack stack = this.getStackInSlot(var1);
		inventory[var1] = null;
		this.markDirty();
		return stack;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		inventory[var1] = var2;
		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return "Pedestal";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return inventory[var1] == null;
	}

	public void read(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.inventory.length)
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		read(nbt);
	}

	public void write(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i) {
			if (this.inventory[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		write(nbt);
	}

	@Override
	public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super.getDescriptionPacket();
		NBTTagCompound dataTag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		write(dataTag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, dataTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		NBTTagCompound tag = pkt != null ? pkt.func_148857_g() : new NBTTagCompound();
		read(tag);
	}
}