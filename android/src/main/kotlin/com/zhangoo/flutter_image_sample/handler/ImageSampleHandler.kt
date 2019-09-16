package com.zhangoo.flutter_image_sample.handler

import android.graphics.Bitmap
import com.zhangoo.flutter_image_sample.utils.ImageUtil
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.concurrent.Executors

class ImageSampleHandler(private val call: MethodCall, channelResult: MethodChannel.Result) : ResultHandler(channelResult) {
    companion object {
        @JvmStatic
        private val executor = Executors.newFixedThreadPool(7)
    }

    fun handler() {
        executor.execute {
            val args: List<Any> = call.arguments as List<Any>
            val file = args[0] as String
            val reqWidth = args[1] as Int
            val reqHeight = args[2] as Int
            val bitmap = ImageUtil.getSampleBitmapForImagePath(file, reqWidth, reqHeight)
            var byteArrayOutputStream: ByteArrayOutputStream? = null
            try {
                byteArrayOutputStream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
                val data = byteArrayOutputStream.toByteArray()
                reply(data)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                byteArrayOutputStream?.close()
            }
            return@execute
        }
    }
}