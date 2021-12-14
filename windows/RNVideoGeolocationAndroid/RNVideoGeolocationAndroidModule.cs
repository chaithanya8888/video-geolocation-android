using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Video.Geolocation.Android.RNVideoGeolocationAndroid
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNVideoGeolocationAndroidModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNVideoGeolocationAndroidModule"/>.
        /// </summary>
        internal RNVideoGeolocationAndroidModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNVideoGeolocationAndroid";
            }
        }
    }
}
