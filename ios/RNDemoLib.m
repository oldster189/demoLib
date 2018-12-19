#import "RNDemoLib.h"

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
             @"isEmulator": @"Codemobiles Co.,Ltd",
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
@end
