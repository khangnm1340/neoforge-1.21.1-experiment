package net.pampam.tutorialmod.item;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pampam.tutorialmod.TutorialMod;
import net.pampam.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
      public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
                  .create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

      public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TABS = CREATIVE_MODE_TAB.register("bismuth_items_tab",
                  () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                              .title(Component.translatable("creativetab.pamtutorialmod.bismuth_items"))
                              .displayItems((parameters, output) -> {
                                    output.accept(ModItems.BISMUTH);
                                    output.accept(ModItems.RAW_BISMUTH);
                              })
                              .build());

      public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TABS = CREATIVE_MODE_TAB.register(
                  "bismuth_blocks_tab",
                  () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                              .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                                          "bismuth_items_tab"))
                              .title(Component.translatable("creativetab.pamtutorialmod.bismuth_blocks"))
                              .displayItems((parameters, output) -> {
                                    output.accept(ModBlocks.BISMUTH_BLOCK);
                                    output.accept(ModBlocks.BISMUTH_ORE);
                              })
                              .build());

      public static void register(IEventBus eventBus) {

            CREATIVE_MODE_TAB.register(eventBus);
      }
}
