#import "FlutterImageSamplePlugin.h"
#import <flutter_image_sample/flutter_image_sample-Swift.h>

@implementation FlutterImageSamplePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterImageSamplePlugin registerWithRegistrar:registrar];
}
@end
