package net.lomeli.lomlib.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import net.minecraftforge.event.AnvilUpdateEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilRecipeManager {
    private static List<IAnvilRecipe> recipeList = new ArrayList<IAnvilRecipe>();

    public static void addRecipe(IAnvilRecipe recipe) {
        if (recipe != null)
            recipeList.add(recipe);
    }

    public static List<IAnvilRecipe> getRegistry() {
        return recipeList;
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        for (int i = 0; i < recipeList.size(); i++) {
            IAnvilRecipe recipe = recipeList.get(i);
            if (recipe != null) {
                if (recipe.matches(event.left, event.right)) {
                    ItemStack output = recipe.getCraftingResult(event.left, event.right);
                    event.cost = recipe.recipeCost();
                    event.output = output;
                }
            }
        }
    }
}
