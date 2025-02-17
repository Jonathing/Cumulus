package com.aetherteam.cumulus.client.gui.screen;

import com.aetherteam.cumulus.Cumulus;
import com.aetherteam.cumulus.CumulusConfig;
import com.aetherteam.cumulus.api.Menu;
import com.aetherteam.cumulus.api.Menus;
import com.aetherteam.cumulus.client.CumulusClient;
import com.aetherteam.cumulus.client.gui.component.MenuSelectionList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MenuSelectionScreen extends Screen {
    public static final ResourceLocation LIST_FRAME = new ResourceLocation(Cumulus.MODID, "textures/gui/menu_api/list.png");

    private final Screen parentScreen;
    private MenuSelectionList menuList;
    private Button launchButton;
    private final List<Menu> menus;
    @Nullable
    private MenuSelectionList.MenuEntry selected = null;

    private static final int EXTERIOR_WIDTH_PADDING = 13;
    private static final int EXTERIOR_TOP_PADDING = 28;
    private static final int EXTERIOR_BOTTOM_PADDING = 33;
    public final int frameWidth = 141;
    public final int frameHeight = 168;

    private boolean setup = false;

    public MenuSelectionScreen(Screen parentScreen) {
        super(Component.literal(""));
        this.parentScreen = parentScreen;
        this.menus = Collections.unmodifiableList(Menus.getMenus());
    }

    @Override
    public void init() {
        this.menuList = new MenuSelectionList(this, this.frameWidth - (EXTERIOR_WIDTH_PADDING * 2), this.frameHeight, (this.height / 2) - (this.frameHeight / 2) + EXTERIOR_TOP_PADDING, (this.height / 2) + (this.frameHeight / 2) - EXTERIOR_BOTTOM_PADDING, 24);
        this.menuList.setRenderBackground(false);
        this.menuList.setRenderTopAndBottom(false);
        this.menuList.setLeftPos((this.width / 2) - (this.frameWidth / 2) + EXTERIOR_WIDTH_PADDING);
        this.addRenderableWidget(this.menuList);

        this.launchButton = Button.builder(Component.translatable("gui.cumulus_menus.button.menu_launch"), press -> {
            if (this.selected != null) {
                CumulusConfig.CLIENT.active_menu.set(this.selected.getMenu().toString());
                CumulusConfig.CLIENT.active_menu.save();
                CumulusClient.MENU_HELPER.setShouldFade(true);
                Minecraft.getInstance().setScreen(CumulusClient.MENU_HELPER.applyMenu(CumulusClient.MENU_HELPER.getActiveMenu()));
                Minecraft.getInstance().getMusicManager().stopPlaying();
            }
        }).bounds((this.width / 2) - (this.frameWidth / 2) + 34, (this.height / 2) + (this.frameHeight / 2) - 27, 72, 20).build();
        this.addRenderableWidget(this.launchButton);
        this.launchButton.active = false;
    }

    @Override
    public void tick() {
        if (!this.setup) {
            this.menuList.refreshList();
            this.launchButton.active = this.selected != null;
            this.setup = true;
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderDirtBackground(poseStack);
        this.renderListFrame(poseStack);
        this.menuList.render(poseStack, mouseX, mouseY, partialTick);
        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    public void renderDirtBackground(PoseStack poseStack) {
        RenderSystem.setShaderTexture(0, GuiComponent.LIGHT_DIRT_BACKGROUND);
        RenderSystem.setShaderColor(1.75F, 1.75F, 1.75F, 1.0F);
        blit(poseStack, 0, 0, 0, 0.0F, 0.0F, this.width, this.height, 32, 32);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundRendered(this, poseStack));
    }

    private void renderListFrame(PoseStack poseStack) {
        RenderSystem.setShaderTexture(0, LIST_FRAME);
        blit(poseStack, (this.width / 2) - (this.frameWidth / 2), this.height / 2 - (this.frameHeight / 2), 0.0F, 0.0F, 141, 168, 256, 256);
        drawCenteredString(poseStack, this.getFontRenderer(), Component.translatable("gui.cumulus_menus.title.menu_selection"), this.width / 2, ((this.height / 2) - (this.frameHeight / 2)) + 11, 0xFFFFFF);
    }

    public <T extends ObjectSelectionList.Entry<T>> void buildMenuList(Consumer<T> menuListViewConsumer, Function<Menu, T> newEntry) {
        this.menus.forEach((menu) -> menuListViewConsumer.accept(newEntry.apply(menu)));
    }

    @Nullable
    public Minecraft getMinecraftInstance() {
        return this.minecraft;
    }

    public Font getFontRenderer() {
        return this.font;
    }

    public void setSelected(MenuSelectionList.MenuEntry entry) {
        this.selected = entry == this.selected ? null : entry;
        this.launchButton.active = this.selected != null;
    }

    @Override
    public void onClose() {
        if (this.getMinecraftInstance() != null) {
            this.getMinecraftInstance().setScreen(this.parentScreen);
        }
    }
}
