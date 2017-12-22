package net.vmjlabs.mrcrayfish.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.vmjlabs.mrcrayfish.init.RegistryEventHandler;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new RegistryEventHandler());

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
