/*
 * Copyright (c) 2016 BeiJing JZYT Technology Co. Ltd
 * www.idsmanager.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * BeiJing JZYT Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with BeiJing JZYT Technology Co. Ltd.
 */
package com.idsmanager.plugin.sm2.ende;

import com.idsmanager.sm.sm2.*;

/**
 * 2021/12/6
 *
 * @author zhangdh
 */
public class EnDeTest {

    public static void main(String[] args) throws Exception {
        final SM2KeyPair keyPair = SM2KeyPairGenerator.generateKeyPair(true);

        final String privateKey = keyPair.getBase64PrivateKey();
        final String publicKey = keyPair.getBase64PublicKey();
        //SM2的加密与解密
        String enPassword = SM2Encrypt.encryptUseBase64(publicKey, "zhangdh", true);
        System.out.println(enPassword);
        SM2DecryptResult result = SM2Decrypt.decryptUseBase64(privateKey, enPassword, true);
        System.out.println(new String(result.getPlainText()));
    }
}