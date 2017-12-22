package net.vmjlabs.mrcrayfish.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.vmjlabs.mrcrayfish.block.BlockMonitor;

import java.util.ArrayList;

public class ModBlocks {
    public static ArrayList<Block> BLOCKS = new ArrayList<>();

   // @GameRegistry.ObjectHolder("pc_monitor")
    public static final Block monitor = new BlockMonitor();

    public static void registerBlocks(){
        BLOCKS.add(monitor);
    }

    public void register(){

    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(monitor);
    }

}
