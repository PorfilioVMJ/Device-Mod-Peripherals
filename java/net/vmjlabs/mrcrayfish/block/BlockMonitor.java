package net.vmjlabs.mrcrayfish.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMonitor extends Block {

    public BlockMonitor() {
        super(Material.IRON, MapColor.IRON);
        setRegistryName("pcmonitor");
        setUnlocalizedName("pcmonitor");
    }

}
