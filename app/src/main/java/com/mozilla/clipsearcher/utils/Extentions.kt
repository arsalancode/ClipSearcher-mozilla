package com.mozilla.clipsearcher.utils

import android.content.ClipDescription
import android.content.ClipboardManager
import android.net.Uri


fun String.getUrl(): String = Uri.Builder().scheme("https")
    .authority("duckduckgo.com")
    .appendQueryParameter("q", this).build().toString()

fun ClipboardManager.getData(): String = primaryClip?.getItemAt(0)?.text?.toString() ?: ""

fun ClipboardManager.containsData(): Boolean = when {
    !hasPrimaryClip() -> false
    (primaryClipDescription?.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) == false -> false
    else -> true
}
