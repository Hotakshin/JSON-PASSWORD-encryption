package com.jinho.prj.common;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.SEEDEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class BouncyModule {
	private final String key = "!@#2352egasaegrf";
	
    public byte[] encrypt(String plainText) { // 암호화
        byte[] keyBytes = key.getBytes();
        byte[] textByte = plainText.getBytes();
        // 블록 암호 운용
        // 블록보다 데이터가 짧을 경우 패딩을 사용함
        // 블록 암호 알고리즘으로는 SEED 알고리즘을 사용함
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new SEEDEngine());
        cipher.init(true, new KeyParameter(keyBytes));
        return getBytes(textByte, cipher);
    }

    public byte[] decrypt(String cipherText) { // 복호화
        byte[] keyBytes = key.getBytes();
        byte[] textByte = cipherText.getBytes();
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new SEEDEngine());
        cipher.init(false, new KeyParameter(keyBytes));

        return getBytes(textByte, cipher);
    }

    private byte[] getBytes(byte[] targetData, BufferedBlockCipher cipher) {
        byte[] outputData = new byte[cipher.getOutputSize(targetData.length)];

        int tam = cipher.processBytes(targetData, 0, targetData.length, outputData, 0);

        try {
            cipher.doFinal(outputData, tam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputData;
    }
}

