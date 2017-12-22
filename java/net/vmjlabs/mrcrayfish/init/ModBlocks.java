package net.vmjlabs.mrcrayfish.init;

import com.mrcrayfish.device.item.ItemDevice;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.vmjlabs.mrcrayfish.block.BlockMonitor;

import java.util.ArrayList;

public class ModBlocks {
    public static ArrayList<Block> BLOCKS = new ArrayList<>();

   // @GameRegistry.ObjectHolder("pc_monitor")
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

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(monitor);
    }

}
