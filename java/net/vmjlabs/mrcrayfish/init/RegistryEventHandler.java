package net.vmjlabs.mrcrayfish.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.vmjlabs.mrcrayfish.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryEventHandler {
    //This Registers the items to the games registry
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //event.getRegistry().registerAll(ModItems.ITEMS);
        ModBlocks.registerBlocks();
        for(Block block : ModBlocks.BLOCKS) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            System.out.println("REGISTERED: "+block.getUnlocalizedName());
        }
        System.out.println("Registered all Items & Blocks");
    }

    //This is the model registerer
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        for(Item item: ModItems.ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }

    }
}
