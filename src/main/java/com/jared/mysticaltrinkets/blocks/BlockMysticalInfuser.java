package com.jared.mysticaltrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.api.MysticalTrinketsAPI;
import com.jared.mysticaltrinkets.items.MysticalItems;
import com.jared.mysticaltrinkets.items.tools.MysticalTools;
import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalInfuser;

public class BlockMysticalInfuser extends BlockContainer {

	public static ItemStack currentPlayerItem = null;

	protected BlockMysticalInfuser() {
		super(Material.iron);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		world.getTileEntity(x, y, z);
		TileEntityMysticalInfuser tile = (TileEntityMysticalInfuser) world.getTileEntity(x, y, z);
		currentPlayerItem = player.getHeldItem();

		if (!world.isRemote) {
			addPower(tile, world, player, 1, 0, 0, 0, 0, new ItemStack(MysticalItems.mysticalIngot));
			addPower(tile, world, player, 0, 0, 0, 0, 1, new ItemStack(MysticalItems.airShard));
			addPower(tile, world, player, 0, 1, 0, 0, 0, new ItemStack(MysticalItems.fireShard));
			addPower(tile, world, player, 0, 0, 0, 1, 0, new ItemStack(MysticalItems.waterShard));
			addPower(tile, world, player, 0, 0, 1, 0, 0, new ItemStack(MysticalItems.natureShard));
			MysticalTrinketsAPI mapi = new MysticalTrinketsAPI();

			if (currentPlayerItem != null && mapi.canReadPower(currentPlayerItem) || currentPlayerItem != null && currentPlayerItem.getItem() == MysticalItems.mysticalReader) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power " + EnumChatFormatting.RESET + "stored."));
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.YELLOW + tile.getAirBuffer() + " Air Power " + EnumChatFormatting.RESET + "stored."));
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.RED + tile.getFireBuffer() + " Fire Power" + EnumChatFormatting.RESET + " stored."));
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.DARK_AQUA + tile.getWaterBuffer() + " Water Power " + EnumChatFormatting.RESET + "stored."));
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.GREEN + tile.getNatureBuffer() + " Nature Power" + EnumChatFormatting.RESET + " stored."));
				}

			}
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Item.getItemFromBlock(MysticalBlocks.mysticalBlock) && tile.getMysticalBuffer() < tile.getPowerCap() && tile.getMysticalBuffer() + 9 <= tile.getPowerCap()) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() + 9);
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(MysticalBlocks.mysticalBlock));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power " + EnumChatFormatting.RESET + "stored."));
			}
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Item.getItemFromBlock(MysticalBlocks.floatingShardBlock) && tile.getAirBuffer() < tile.getPowerCap() && tile.getAirBuffer() + 9 <= tile.getPowerCap()) {
				tile.setAirBuffer(tile.getAirBuffer() + 9);
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(MysticalBlocks.floatingShardBlock));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.YELLOW + tile.getAirBuffer() + " Air Power " + EnumChatFormatting.RESET + "stored."));
			}
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Item.getItemFromBlock(MysticalBlocks.burntShardBlock) && tile.getFireBuffer() < tile.getPowerCap() && tile.getFireBuffer() + 9 <= tile.getPowerCap()) {
				tile.setFireBuffer(tile.getFireBuffer() + 9);
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(MysticalBlocks.burntShardBlock));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.RED + tile.getFireBuffer() + " Fire Power" + EnumChatFormatting.RESET + " stored."));
			}
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Item.getItemFromBlock(MysticalBlocks.waterShardBlock) && tile.getWaterBuffer() < tile.getPowerCap() && tile.getWaterBuffer() + 9 <= tile.getPowerCap()) {
				tile.setWaterBuffer(tile.getWaterBuffer() + 9);
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(MysticalBlocks.waterShardBlock));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.DARK_AQUA + tile.getWaterBuffer() + " Water Power " + EnumChatFormatting.RESET + "stored."));
			}
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Item.getItemFromBlock(MysticalBlocks.natureShardBlock) && tile.getNatureBuffer() < tile.getPowerCap() && tile.getNatureBuffer() + 9 <= tile.getPowerCap()) {
				tile.setNatureBuffer(tile.getNatureBuffer() + 9);
				player.inventory.consumeInventoryItem(Item.getItemFromBlock(MysticalBlocks.natureShardBlock));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.GREEN + tile.getNatureBuffer() + " Nature Power" + EnumChatFormatting.RESET + " stored."));
			}

		}

		if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock)) {
			if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.airRitualBlock)) {
				if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock)) {
					if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock)) {

						registerRitualRecipe(tile, world, player, 4, new ItemStack(MysticalItems.ironRing), new ItemStack(MysticalItems.mysticalRing));
						registerRitualRecipe(tile, world, player, 8, new ItemStack(MysticalItems.ironBelt), new ItemStack(MysticalItems.mysticalBelt));
						registerRitualRecipe(tile, world, player, 8, new ItemStack(MysticalItems.ironAmulet), new ItemStack(MysticalItems.mysticalAmulet));
						registerRitualRecipe(tile, world, player, 1, new ItemStack(Items.iron_ingot), new ItemStack(MysticalItems.mysticalIngot));

						registerRitualRecipe(tile, world, player, 3, new ItemStack(Items.iron_pickaxe), new ItemStack(MysticalTools.mysticalPickAxe));
						registerRitualRecipe(tile, world, player, 3, new ItemStack(Items.iron_axe), new ItemStack(MysticalTools.mysticalAxe));
						registerRitualRecipe(tile, world, player, 2, new ItemStack(Items.iron_sword), new ItemStack(MysticalTools.mysticalSword));
						registerRitualRecipe(tile, world, player, 1, new ItemStack(Items.iron_shovel), new ItemStack(MysticalTools.mysticalSpade));
						registerRitualRecipe(tile, world, player, 2, new ItemStack(Items.iron_hoe), new ItemStack(MysticalTools.mysticalHoe));

						registerRitualRecipe(tile, world, player, 8, new ItemStack(MysticalItems.goldBelt), new ItemStack(MysticalItems.jumpingBelt));

						registerRitualRecipe(tile, world, player, 64, new ItemStack(MysticalItems.goldAmulet), new ItemStack(MysticalItems.witherlessAmulet));
						registerRitualRecipe(tile, world, player, 4, new ItemStack(MysticalItems.goldRing), new ItemStack(MysticalItems.nightVisionRing));

					}
				}
			}
		}
		if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) && checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock) && checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) && checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock)) {
			registerFireRitualRecipe(tile, world, player, 4, 20, new ItemStack(MysticalItems.mysticalRing), new ItemStack(MysticalItems.fireResistanceRing));
			registerFireRitualRecipe(tile, world, player, 4, 8, new ItemStack(MysticalItems.ironRing), new ItemStack(MysticalItems.burntRing));
			registerFireRitualRecipe(tile, world, player, 20, 64, new ItemStack(MysticalItems.burntRing), new ItemStack(MysticalItems.lavaSwimmerRing));
		}

		if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) && checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock) && checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) && checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock)) {
			registerNatureRitualRecipe(tile, world, player, 8, 32, new ItemStack(MysticalItems.mysticalBelt), new ItemStack(MysticalItems.steppingBelt));
			registerNatureRitualRecipe(tile, world, player, 32, 48, new ItemStack(MysticalItems.mysticalAmulet), new ItemStack(MysticalItems.absoptionAmulet));
		}

		if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) && checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.airRitualBlock) && checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) && checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.airRitualBlock)) {
			registerAirRitualRecipe(tile, world, player, 8, 40, new ItemStack(MysticalItems.mysticalBelt), new ItemStack(MysticalItems.speedBelt));
			registerAirRitualRecipe(tile, world, player, 8, 64, new ItemStack(MysticalItems.goldBelt), new ItemStack(MysticalItems.slowFallBelt));

		}

		if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) && checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock) && checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) && checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock)) {
			registerWaterRitualRecipe(tile, world, player, 8, 40, new ItemStack(MysticalItems.mysticalAmulet), new ItemStack(MysticalItems.waterBreathingAmulet));
		}
		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityMysticalInfuser();
	}

	public boolean checkForBlock(World world, int x, int y, int z, Block block) {

		if (world.getBlock(x, y, z) == block) {
			return true;
		} else {
			return false;
		}

	}

	public void addPower(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int mysticalPower, int firePower, int naturePower, int waterPower, int airPower, ItemStack input) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getAirBuffer() + airPower <= tile.getPowerCap()) {
				tile.setAirBuffer(tile.getAirBuffer() + airPower);
			}

			if (tile.getFireBuffer() + firePower <= tile.getPowerCap()) {
				tile.setFireBuffer(tile.getFireBuffer() + firePower);
			}
			if (tile.getWaterBuffer() + waterPower <= tile.getPowerCap()) {
				tile.setWaterBuffer(tile.getWaterBuffer() + waterPower);
			}

			if (tile.getNatureBuffer() + naturePower <= tile.getPowerCap()) {
				tile.setNatureBuffer(tile.getNatureBuffer() + naturePower);
			}

			if (tile.getMysticalBuffer() + mysticalPower <= tile.getPowerCap()) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() + mysticalPower);
			}

			tile.updateEntity();
			player.inventory.consumeInventoryItem(input.getItem());

			if (!world.isRemote) {
				if (airPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.YELLOW + tile.getAirBuffer() + " Air Power" + EnumChatFormatting.RESET + " left."));
				}
				if (firePower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.RED + tile.getFireBuffer() + " Fire Power" + EnumChatFormatting.RESET + " left."));
				}
				if (naturePower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.GREEN + tile.getNatureBuffer() + " Nature Power" + EnumChatFormatting.RESET + " left."));
				}
				if (waterPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.DARK_AQUA + tile.getWaterBuffer() + " Water Power" + EnumChatFormatting.RESET + " left."));
				}
				if (mysticalPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				}
			}

		}
	}

	public void registerRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getMysticalBuffer() >= usedMysticalPower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.updateEntity();
				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.LIGHT_PURPLE + "Mystical Power" + EnumChatFormatting.RESET + "!"));

				}
			}
		}
	}

	public void registerFireRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, int usedFirePower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getMysticalBuffer() >= usedMysticalPower && tile.getFireBuffer() >= usedFirePower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.setFireBuffer(tile.getFireBuffer() - usedFirePower);
				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.RED + tile.getFireBuffer() + " Fire Power" + EnumChatFormatting.RESET + " left."));
			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.LIGHT_PURPLE + "Mystical Power" + EnumChatFormatting.RESET + "!"));
				}
			} else if (tile.getFireBuffer() <= usedFirePower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.RED + "Fire Power" + EnumChatFormatting.RESET + "!"));

				}
			}
		}
	}

	public void registerNatureRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, int usedNaturePower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getMysticalBuffer() >= usedMysticalPower && tile.getNatureBuffer() >= usedNaturePower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.setNatureBuffer(tile.getNatureBuffer() - usedNaturePower);
				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.GREEN + tile.getNatureBuffer() + " Nature Power" + EnumChatFormatting.RESET + " left."));
			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.LIGHT_PURPLE + "Mystical Power" + EnumChatFormatting.RESET + "!"));
				}
			} else if (tile.getNatureBuffer() <= usedNaturePower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.GREEN + "Nature Power" + EnumChatFormatting.RESET + "!"));

				}
			}
		}
	}

	public void registerAirRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, int usedAirPower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getMysticalBuffer() >= usedMysticalPower && tile.getAirBuffer() >= usedAirPower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.setAirBuffer(tile.getAirBuffer() - usedAirPower);
				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.YELLOW + tile.getAirBuffer() + " Air Power" + EnumChatFormatting.RESET + " left."));
			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.LIGHT_PURPLE + "Mystical Power" + EnumChatFormatting.RESET + "!"));
				}
			} else if (tile.getAirBuffer() <= usedAirPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.YELLOW + "Air Power" + EnumChatFormatting.RESET + "!"));

				}
			}
		}
	}

	public void registerWaterRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, int usedWaterPower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == input.getItem()) {
			if (tile.getMysticalBuffer() >= usedMysticalPower && tile.getWaterBuffer() >= usedWaterPower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.setWaterBuffer(tile.getWaterBuffer() - usedWaterPower);
				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.DARK_AQUA + tile.getWaterBuffer() + " Water Power" + EnumChatFormatting.RESET + " left."));
			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.LIGHT_PURPLE + "Mystical Power" + EnumChatFormatting.RESET + "!"));
				}
			} else if (tile.getWaterBuffer() <= usedWaterPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough " + EnumChatFormatting.DARK_AQUA + "Water Power" + EnumChatFormatting.RESET + "!"));

				}
			}
		}
	}

	public void registerRitualRecipe(TileEntityMysticalInfuser tile, World world, EntityPlayer player, int usedMysticalPower, int usedFirePower, int usedNaturePower, int usedAirPower, int usedWaterPower, ItemStack input, ItemStack output) {
		if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem() == input) {
			if (tile.getMysticalBuffer() >= usedMysticalPower && tile.getNatureBuffer() >= usedNaturePower && tile.getAirBuffer() >= usedAirPower && tile.getFireBuffer() >= usedFirePower && tile.getWaterBuffer() >= usedWaterPower) {
				tile.setMysticalBuffer(tile.getMysticalBuffer() - usedMysticalPower);
				tile.setWaterBuffer(tile.getWaterBuffer() - usedWaterPower);
				tile.setNatureBuffer(tile.getNatureBuffer() - usedNaturePower);
				tile.setAirBuffer(tile.getAirBuffer() - usedAirPower);
				tile.setFireBuffer(tile.getFireBuffer() - usedFirePower);

				player.inventory.consumeInventoryItem(input.getItem());
				player.inventory.addItemStackToInventory(output);

				if (usedAirPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.YELLOW + tile.getAirBuffer() + " Air Power" + EnumChatFormatting.RESET + " left."));
				}
				if (usedFirePower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.RED + tile.getFireBuffer() + " Fire Power" + EnumChatFormatting.RESET + " left."));
				}
				if (usedNaturePower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.GREEN + tile.getNatureBuffer() + " Nature Power" + EnumChatFormatting.RESET + " left."));
				}
				if (usedWaterPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.DARK_AQUA + tile.getWaterBuffer() + " Water Power" + EnumChatFormatting.RESET + " left."));
				}
				if (usedMysticalPower >= 0) {
					player.addChatComponentMessage(new ChatComponentText("You have: " + EnumChatFormatting.LIGHT_PURPLE + tile.getMysticalBuffer() + " Mystical Power" + EnumChatFormatting.RESET + " left."));
				}

			} else if (tile.getMysticalBuffer() <= usedMysticalPower) {
				if (!world.isRemote) {
					player.addChatComponentMessage(new ChatComponentText("You don't have enough Power!"));
				}
			}
		}
	}

}
