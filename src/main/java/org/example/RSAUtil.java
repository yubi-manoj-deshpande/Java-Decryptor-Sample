package org.example;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {
    public static PrivateKey getPrivateKey(String filename) throws Exception {
        String key = new String(Files.readAllBytes(Paths.get(filename)))
                .replaceAll("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "")
                ;

        String key1 = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCieeMwfvF1/Nu+yNpabBoaXNq3qAlzae3YyySVLCG1mY6xfIyqfAjKtcmj6rTF7Io1rQID8uVBplokqjGJBNp06QNLOEA0sorjn4jDy4Vf+Psxh1O/zLPIhUPPsGp3lt9HXILJ9ZllU4oS6FdcBeGl4x1+1Dzh8N8E6YkGfM64ZmfmUaqBW7uIv6yfali8lVrbgKDJvkLaj4UwryifRHoa+9ESKnV3/8PW95DxvtUnF72c+ug7DL9ms1aALnyfuq0zrpOkhFfuLFoz71viPg8gTGr5ZiakNFEhT4VmrxfQRcb0Y6sx1bRNG47zFbQHrDzIzB6htbHoZbklxvBec3clAgMBAAECggEAHLLa5l4F2IlpZzGjIAWoNq/gEkCkKrazRG/dblv1OFZ/VepiDlsKUoP5sfJrK+q0HvcIPBpTVF1F3uQRC9rHm47s/gRZkvVWgw5S4gK49FLOS9lTebV2rByd9bl7lNQZbEly8KlpBvTSlrRjeeWwDdUoCJcEigQ54Gw/v92bxgZIlYIYnYFcGFxnFqgtlLpyHWrF6WH9qBOB9+kkKp8QZr12VmzPP8iwbk9YnCRZHxhVYckV3okDfGRv5oZAeuzS1JpiSpHapL4P1l3muIExX73astfmkDd9kHLtFR3zMSCEDTTa3aVlQyRcsjMfsrX3/EH6p4bm6f5WY88hQqucAQKBgQDPBwaDBKdH/sOwD/Lt0J5RN72B3wKbRcbk/lepTq8Idut9u33OUtjiXOLh84FDHYm/6J44GzB+AKygxM5+J34W7t7L+U8PJnbC5sTFEQijY+4tpwCBMIELMTmMn7KmhbKamKGmJDktLZXMn9fBhpOUMlRvfR/hr4v+A87scuh8IQKBgQDI6Pb7ns5sP1BjdXnNAKntVfy4656pTf2n58pnWQEetwqNSBj6Xy6pD+9gt+T+w/5pZo1ZFty91D9n0peRdlmmsMsHEp0FDTjwjAWtf3l+HVYMH5Bt5a2pMKZkKljJarEigFwdDwVgMHh+a6keEu2bn5+xDkJXuKVa14qRahu6hQKBgAv8+SiPFWy62PQSCFwzD2felW+2zTzWjozmGYdpUgNod3yBZeiTrZF2FYFGC38qb7aYLslK8cTqHxT0MIznloqXbHldR3G2JXxlxpEuylRDziAAoqvYdjCCujVlbf/skAoZuoqXYGQ4VotR2jmPpG4ZeAA4u6bi9nVQHSReBw5hAoGBAJhaocDaAqtvr+RcV4swL6w9ArKwatb0v6AuU/zfL8w8/hF5VQe4Wkf2P47WpR7VPf5ruFCQ18BUTejLeAjk+MNBWhT49n24My+m3z9cZaNPV8tFvF66R2D/9Y4L1tyWvdDuCew3UdpJp3Ym6k5WCD11ZMH9kC25ZhtnTDtNfc2JAoGALFyEiVgp6qCn4WQYKtTlsmXrMhyaeOeyjMDIngoF/8TMPQq17Su5LSLJKeUXuqMkDXdkCdb1BsYVuA4Mp73E6YRBRuv2uFLObZi/oLdwOZz2kvSd29PHPdw1vCqb56Ic8Dy6ZW0xWfVb36cg+CWKE+TMqcdOy4Gc7/Vw3OimwQY=";

        System.out.println(key1.equals(key));

        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
