import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:io';

import 'package:flutter/services.dart';
import 'package:flutter_image_sample/flutter_image_sample.dart';
import 'package:path_provider/path_provider.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _imageWidth = "Unknown";
  String _imageHeight = "Unknown";
  Uint8List _imageData;

  @override
  void initState() {
    super.initState();
    getExternalStorageDirectory().then((value) {
      final imagePath = value.path + Platform.pathSeparator + "1.png";
      FlutterImageSample.getImageSize(imagePath).then((size) {
        setState(() {
          _imageWidth = size[0].toString();
          _imageHeight = size[1].toString();
        });
      });
      FlutterImageSample.getImageSample(imagePath, 150, 150).then((value){
        setState(() {
          _imageData = value;
        });
      });
    });
  }

  Widget _createImage() {
    if (_imageData == null) {
      return Text("");
    } else {
      return Image.memory(_imageData);
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Container(
            child: Column(
              children: <Widget>[
                Row(
                  children: <Widget>[
                    Text("Width:"),
                    Text("$_imageWidth",style:TextStyle(color: Colors.blue)),
                    Padding(
                        padding: EdgeInsets.only(left: 10),
                        child: Text("Height:")),
                    Text("$_imageHeight",style: TextStyle(color: Colors.blue),)
                  ],
                ),
                _createImage()
              ],
            ),
            width: double.infinity,
            height: double.infinity),
      ),
    );
  }
}
