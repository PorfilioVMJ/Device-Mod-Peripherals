package net.vmjlabs.mrcrayfish.init;

import com.mrcrayfish.device.init.DeviceBlocks;
import com.mrcrayfish.device.item.ItemDevice;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.vmjlabs.mrcrayfish.block.BlockMonitor;

public class ModBlocks extends DeviceBlocks{

    public static final Block MONITOR;

    static{
        MONITOR = new BlockMonitor();
    }

    public static void register()
    {
        registerBlock(MONITOR, new ItemDevice(MONITOR));
    }

    private static void registerBlock(Block block)
    {
        registerBlock(block, new ItemBlock(block));
    }

    private static void registerBlock(Block block, ItemBlock item)
    {
        if(block.getRegistryName() == null)
            throw new IllegalArgumentException("A block being registered does not have a registry name and could be successfully registered.");

        RegistrationHandler.Blocks.add(block);
        item.setRegistryName(block.getRegistryName());
        RegistrationHandler.Items.add(item);
    }

}
