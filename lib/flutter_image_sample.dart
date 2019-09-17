import 'dart:async';

import 'package:flutter/services.dart';
import 'dart:typed_data';

class FlutterImageSample {
  static const MethodChannel _channel =
      const MethodChannel('flutter_image_sample');

  static Future<List> getImageSize(String path) async {
    final size = await _channel.invokeMethod('getImageSize', [path]) as List;
    return size;
  }

  static Future<Uint8List> getImageSample(
      String path, int width, int height) async {
    final data = await _channel
        .invokeMethod('getSampleImage', [path, width, height]) as Uint8List;
    return data;
  }
}
