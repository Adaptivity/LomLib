package net.lomeli.lomlib.client.gui.pages;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.lomeli.lomlib.client.ProxyClient;
import net.lomeli.lomlib.client.render.SmallFontRenderer;
import net.lomeli.lomlib.libs.Strings;

@SideOnly(Side.CLIENT)
public class PageBase {
    public static final FontRenderer largeFontRenderer = FMLClientHandler.instance().getClient().fontRenderer;
    public static final SmallFontRenderer smallFontRenderer = ProxyClient.smallFontRenderer;
    protected static RenderItem itemRenderer = new RenderItem();
    public int width = 106, height = 180, x = 0, y = 0;
    public GuiScreen gui;
    protected Minecraft mc;
    protected ResourceLocation prop = new ResourceLocation(Strings.MOD_ID.toLowerCase(), "textures/images/imageSheet1.png");
    private String tag;
    private boolean requiresTag;

    public PageBase(GuiScreen gui) {
        this.gui = gui;
        this.mc = Minecraft.getMinecraft();
        requiresTag = false;
    }

    public PageBase(int x, int y, GuiScreen gui) {
        this.gui = gui;
        this.mc = Minecraft.getMinecraft();
        requiresTag = false;
        this.setPos(x, y);
    }

    public PageBase setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public void draw() {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public String getTag() {
        return tag;
    }

    public PageBase setTag(String tag) {
        this.tag = tag;
        requiresTag = true;
        return this;
    }

    public boolean needsTag() {
        return requiresTag;
    }

    public void bindTexture(ResourceLocation texture) {
        mc.renderEngine.bindTexture(texture);
    }
}
