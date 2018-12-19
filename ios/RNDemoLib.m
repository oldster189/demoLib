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
             @"systemName": @"Codemobiles Co.,Ltd",
    };
} 
@end
