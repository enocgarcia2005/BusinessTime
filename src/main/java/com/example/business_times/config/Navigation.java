package com.example.business_times.config;

import android.content.Context;
import android.content.Intent;

public class Navigation {
    public Intent createIntent(Context context,Class<?> clas){return new Intent(context,clas);}
}

