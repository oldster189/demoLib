using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Demo.Lib.RNDemoLib
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNDemoLibModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNDemoLibModule"/>.
        /// </summary>
        internal RNDemoLibModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNDemoLib";
            }
        }
    }
}
