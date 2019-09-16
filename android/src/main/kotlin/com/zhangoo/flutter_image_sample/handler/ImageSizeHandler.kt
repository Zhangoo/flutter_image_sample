package com.zhangoo.flutter_image_sample.handler

import com.zhangoo.flutter_image_sample.utils.ImageUtil
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import java.util.concurrent.Executors

class ImageSizeHandler(private val call: MethodCall, channelResult: MethodChannel.Result) : ResultHandler(channelResult) {
    companion object {
        @JvmStatic
        private val executor = Executors.newFixedThreadPool(7)
    }

    fun handler() {
        executor.execute {
            val args: List<Any> = call.arguments as List<Any>
            val file = args[0] as String
            reply(ImageUtil.getImageSize(file))
            return@execute
        }
    }
}