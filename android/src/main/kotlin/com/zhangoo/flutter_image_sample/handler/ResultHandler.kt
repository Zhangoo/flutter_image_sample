package com.zhangoo.flutter_image_sample.handler

import android.os.Handler
import android.os.Looper
import io.flutter.plugin.common.MethodChannel

abstract class ResultHandler(private val channelResult: MethodChannel.Result) {
    companion object {
        private val handler = Handler(Looper.getMainLooper())
    }

    fun reply(any: Any?) {
        handler.post {
            this.channelResult.success(any)
        }
    }

    fun replyError(code: String, message: String? = null, obj: Any? = null) {
        handler.post {
            this.channelResult.error(code, message, obj)
        }
    }
}