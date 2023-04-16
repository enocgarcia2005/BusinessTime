package com.example.business_times.config;

import android.content.Context;
import android.content.Intent;

/**
 * The Navigation class has to unique task of create a intent to navigate between activities
 */
public class Navigation {
    /**
     * createIntent how your name say he creates the Intent that serve for navigate between activities
     * @param context-context that finds in this moment the app
     * @param clas- name of class that is connect the activity for navigate to she
     * @return return the Intent created with the parameters previous.
     */
    public Intent createIntent(Context context,Class<?> clas){return new Intent(context,clas);}

}

