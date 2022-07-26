package com.mozilla.clipsearcher.utils

import android.net.Uri


fun String.getUrl(): String = Uri.Builder().scheme("https")
    .authority("duckduckgo.com")
    .appendQueryParameter("q", this).build().toString()

