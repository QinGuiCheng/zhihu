package com.yiyi.zhihu.global;

/**
 *
 * Created by Administrator on 2016/12/27.
 */

public class Constants {
    public interface Key {
        String THEME_MODE = "theme_mode";
    }

    public interface Theme {
        String DAY_THEME = "day_theme";
        String NIGHT_THEME = "night_theme";
    }

    public interface DrawerMenuItemType {
        int ITEM_DRAWER_MENU_HEADER = 0;
        int ITEM_DRAWER_MENU_HOME = 1;
        int ITEM_DRAWER_MENU_CONTENT = 2;
    }

    public interface FragmentItemType {
        int ITEM_ATTICLE = 0;
        int ITEM_THEME_SECTION = 1;
    }

    public interface StoryType {
        String STORY_HOME = "home";
        String STORY_THEME = "theme";
    }

    public interface WebViewSetting {
        String SP_NO_IMAGE = "no_image";
        String SP_AUTO_CACHE = "auto_cache";
    }
}
