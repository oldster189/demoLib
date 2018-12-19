#import "RNDemoLib.h"
#import <sys/utsname.h>

@implementation RNDemoLib

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (NSDictionary *)constantsToExport
{
    return @{
        @"isEmulator": @(self.isEmulator),
    };
}

- (BOOL) isEmulator
{
    struct utsname systemInfo;
    
    uname(&systemInfo);
    
    NSString* deviceId = [NSString stringWithCString:systemInfo.machine
                                            encoding:NSUTF8StringEncoding];
    if ([deviceId isEqualToString:@"i386"] || [deviceId isEqualToString:@"x86_64"] ) {
        deviceId = [NSString stringWithFormat:@"%s", getenv("SIMULATOR_MODEL_IDENTIFIER")];
        return YES;
    } else {
        return NO;
    }
}

RCT_EXPORT_METHOD(findEvents:(RCTResponseSenderBlock)callback) {
    NSArray *events;
    events = [NSArray arrayWithObjects:  @"foo", @"bar", nil];
    callback(@[[NSNull null], events]);
}

//RCT_EXPORT_METHOD(subStract:(int)number1 number2:(int)number2 resolve(RCTPromiseResolveBlock)resolve
//                 rejecter:(RCTPromiseRejectBlock)reject)
//{
//    @try {
//        int answer = number1 + number2;
//        resolve(answer)
//    } @catch (NSException *exception) {
//        reject(@"Error naja");
//    }
//}
@end
