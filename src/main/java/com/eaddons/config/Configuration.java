package com.eaddons.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Button;
import cc.polyfrost.oneconfig.config.annotations.Page;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import jdk.jfr.Category;

public class Configuration extends Config {

    // General
    @Switch(
            name = "Movement Detector",
            description = "Makes a noise when you get stuck or stop moving",
            size = OptionSize.DUAL, // optional, declares whether the element is single column or dual column
            category = "General", // optional
            subcategory = "Farming" // optional
    )
    public static boolean NoMovementDetector = false; // this is the default value.

    // Cosmetics
    @Switch(
            name = "Cats",
            size = OptionSize.DUAL,
            category = "Cosmetics",
            subcategory = "Cosmetics"
    )
    public static boolean Cats = false;
    @Slider(
            name = "Number Of Cats",
            min = 1f, max = 15f,        // min and max values for the slider
            // if you like, you can use step to set a step value for the slider,
            // giving it little steps that the slider snaps to.
            step = 1,
            category = "Cosmetics",
            subcategory = "Cats"
    )
    public static int numberOfCats = 1; // default value


    public Configuration() {
        // Available mod types: PVP, HUD, UTIL_QOL, HYPIXEL, SKYBLOCK
        super(new Mod("E Addons", ModType.SKYBLOCK), "eaddons/config.json");
        initialize();
    }

}