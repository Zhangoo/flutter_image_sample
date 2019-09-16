package com.zhangoo.flutter_image_sample.utils

import android.graphics.*
import kotlin.math.roundToInt

class ImageUtil {
    companion object {

        fun getSampleBitmapForImagePath(path: String, reqWidth: Int, reqHeight: Int): Bitmap {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(path, options)
            val sampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
            options.inJustDecodeBounds = false
            options.inSampleSize = sampleSize
            return BitmapFactory.decodeFile(path, options)
        }

        private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
            val width = options.outWidth
            val height = options.outHeight
            var inSampleSize = 1
            if (width > reqWidth || height > reqHeight) {
                val partHeight = height / 2
                val partWidth = width / 2
                while ((partHeight / inSampleSize) > reqHeight && (partWidth / inSampleSize) > reqWidth) {
                    inSampleSize *= 2;
                }
            }
            return inSampleSize
        }

        fun getImageSize(path: String): List<Int> {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(path, options)
            val sizeList = ArrayList<Int>()
            sizeList.add(options.outWidth)
            sizeList.add(options.outHeight)
            return sizeList
        }
    }
}