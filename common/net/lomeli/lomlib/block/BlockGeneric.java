package net.lomeli.lomlib.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

/**
 * Meant to be a very generic block that is already ready for custom mod
 * textures and not require a generic block class
 * 
 * @author Lomeli12
 */
public class BlockGeneric extends Block {
    protected String modID;
    protected String blockTexture;
    protected int drop;
    protected World worldObj;

    /**
     * 
     * @param id
     *            Block Id
     * @param material
     *            Block material
     * @param mod
     *            The mod id
     * @param texture
     *            The block's texture file (without .png)
     */
    public BlockGeneric(int id, Material material, String mod, String texture) {
        super(id, material);
        this.modID = mod;
        this.blockTexture = texture;
        this.drop = id;
    }

    public BlockGeneric(int id, Material material, String mod, String texture,
            int dropID) {
        super(id, material);
        this.modID = mod;
        this.blockTexture = texture;
        this.drop = dropID;
    }

    public String getBlockTexture() {
        return this.blockTexture;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(modID + ":" + blockTexture);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return drop;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        this.worldObj = world;
        this.worldObj.markBlockForUpdate(x, y, z);
    }
}
