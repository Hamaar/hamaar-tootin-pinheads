package com.hamaartootinpinheads.pin;

import java.net.URL;
import java.security.cert.Certificate;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.facebook.react.bridge.Callback;

public class PinUtils {
  public static void HamaarPinHeads(String pinUrlServer, String pinSHA256, Callback successHamaarConnection, Callback failedHamaarConnection) {
    try {
      URL urlObject = new URL(pinUrlServer);
      String nameServer = urlObject.getHost();
      CertificatePinner certificatePinner = new CertificatePinner.Builder()
        .add(nameServer, pinSHA256)
        .build();
      OkHttpClient client = (new OkHttpClient.Builder()).certificatePinner(certificatePinner).build();
      Request request = new Request.Builder()
        .url(pinUrlServer)
        .build();

      try (Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
          failedHamaarConnection.invoke(response.body().toString());
        }

        for (Certificate certificate : response.handshake().peerCertificates()) {
           successHamaarConnection.invoke(CertificatePinner.pin(certificate));
        }
      }
    } catch (Exception e) {
      failedHamaarConnection.invoke(e.getMessage());
    }
  }
}
