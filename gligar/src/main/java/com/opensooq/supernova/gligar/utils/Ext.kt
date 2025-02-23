package com.opensooq.supernova.gligar.utils

import android.content.Context
import android.database.Cursor
import android.os.Environment.DIRECTORY_PICTURES
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Hani AlMomani on 24,September,2019
 */

internal fun Cursor.doWhile(action: () -> Unit) {
    this.use {
        if (this.moveToFirst()) {
            do {
                action()
            } while (this.moveToNext())
        }
    }
}

@Throws(IOException::class)
internal fun createTempImageFile(context: Context): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val storageDir = context.getExternalFilesDir(DIRECTORY_PICTURES)
    return File.createTempFile(
        imageFileName,
        ".jpg",
        storageDir
    )
}