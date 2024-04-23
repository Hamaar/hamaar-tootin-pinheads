import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'hamaar-tootin-pinheads' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const HamaarTootinPinheads = NativeModules.HamaarTootinPinheads
  ? NativeModules.HamaarTootinPinheads
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export default {
  isHamaarTootinTrust: () => HamaarTootinPinheads.isHamaarTootinTrust || false,
  isHamaarDetectXuniles: () =>
    HamaarTootinPinheads.isHamaarDetectXuniles || false,
  setHamaarPinHeads: (
    pinUrlServer: string,
    pinSHA256: string,
    successCalback: any,
    errorCallback: any
  ) =>
    HamaarTootinPinheads.setHamaarPinHeads(
      pinUrlServer,
      pinSHA256,
      successCalback,
      errorCallback
    ),
  closeHamaarApplication: () => HamaarTootinPinheads.closeHamaarApplication(),
};
