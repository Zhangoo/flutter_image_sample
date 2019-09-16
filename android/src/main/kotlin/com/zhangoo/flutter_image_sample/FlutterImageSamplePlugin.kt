package com.zhangoo.flutter_image_sample

import com.zhangoo.flutter_image_sample.handler.ImageSampleHandler
import com.zhangoo.flutter_image_sample.handler.ImageSizeHandler
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterImageSamplePlugin : MethodCallHandler {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "flutter_image_sample")
            channel.setMethodCallHandler(FlutterImageSamplePlugin())
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getImageSize" -> ImageSizeHandler(call, result).handler()
            "getSampleImage" -> ImageSampleHandler(call, result).handler()
            else -> result.notImplemented()
        }
    }
}
