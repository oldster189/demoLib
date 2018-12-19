# react-native-demo-lib

## Getting started

`$ npm install react-native-demo-lib --save`

### Mostly automatic installation

`$ react-native link react-native-demo-lib`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-demo-lib` and add `RNDemoLib.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDemoLib.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.RNDemoLibPackage;` to the imports at the top of the file
  - Add `new RNDemoLibPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-demo-lib'
  	project(':react-native-demo-lib').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-demo-lib/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-demo-lib')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNDemoLib.sln` in `node_modules/react-native-demo-lib/windows/RNDemoLib.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Demo.Lib.RNDemoLib;` to the usings at the top of the file
  - Add `new RNDemoLibPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNDemoLib from 'react-native-demo-lib';

// TODO: What to do with the module?
RNDemoLib;
```
  