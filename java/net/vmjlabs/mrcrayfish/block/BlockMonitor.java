package net.vmjlabs.mrcrayfish.block;

import com.mrcrayfish.device.MrCrayfishDeviceMod;
import com.mrcrayfish.device.block.BlockDevice;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMonitor extends BlockDevice {

    public BlockMonitor() {
        super(Material.ANVIL);
        this.setCreativeTab(MrCrayfishDeviceMod.TAB_DEVICE);
        this.setUnlocalizedName("pcmonitor");
        this.setRegistryName("pcmonitor");
    }

}
