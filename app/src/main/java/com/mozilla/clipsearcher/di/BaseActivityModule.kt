package com.mozilla.clipsearcher.di

import android.content.ClipboardManager
import android.content.Context
import com.mozilla.clipsearcher.MyApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

//@Module
//@InstallIn(ActivityComponent::class)
//object MainModule {
//
//    @Provides
//    fun context(app: MyApp) = app.applicationContext as Context
//
//    @Provides
//    fun provideClipboardManager(context: Context): ClipboardManager {
//        return context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//    }
//
//}