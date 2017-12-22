package net.vmjlabs.mrcrayfish;

import com.mrcrayfish.device.api.ApplicationManager;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.vmjlabs.mrcrayfish.app.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.vmjlabs.mrcrayfish.proxy.CommonProxy;

/**
 *  Author: PorfilioVMJ
 */
@Mod(name = Reference.MOD_NAME,modid = Reference.MODID, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = Reference.DEPENDS)
public class HomeManager {


    @SidedProxy(clientSide="net.vmjlabs.mrcrayfish.proxy.ClientProxy", serverSide="net.vmjlabs.mrcrayfish.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e){
        this.proxy.init(e);
        ApplicationManager.registerApplication(new ResourceLocation(Reference.MODID+":vmjmanager"), ManagerApp.class);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
}
