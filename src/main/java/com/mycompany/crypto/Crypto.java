/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.crypto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class Crypto {

    static String messageInput;

    public static void main(String[] args) {
        FrameCrypto frame = new FrameCrypto();
        frame.setVisible(true);
        //слушаем Закодировать
        frame.getBtnZakodirivat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInput = frame.getAreaInput().getText();
                frame.getAreaOutput().setText(getCryptoMessage(messageInput));
            }
        });
        //слушаем Разкодировать
        frame.getBtnRazkodirovat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageInput = frame.getAreaInput().getText();
                frame.getAreaOutput().setText(getDeCryptoMessage(messageInput));
            }
        });
    }

    //разкодировать сообщение
    public static String getDeCryptoMessage(String message) {
        String upper;
        char[] masChar;
        String str = "";
        String deCryptoMessage = "";
        String[] listMessage = message.split("[ .,/\n=]");
        for (String string : listMessage) {
            upper = string.replaceAll("[^А-Я]+", "");
            if (upper.length() == string.length()) {
                masChar = upper.toCharArray();
                for (char c : masChar) {
                    str += getSimvolRazkodirovat(c);
                }
                deCryptoMessage += str + " ";
                str = "";
            } else {
                deCryptoMessage += string + " ";
            }
        }
        return deCryptoMessage;
    }

    //закодировать сообщение
    public static String getCryptoMessage(String message) {
        String cryptoMessage;
        String[] listMessage = message.split("[ .,/\n=]");
        cryptoMessage = getCryptoMessage(listMessage);
        return cryptoMessage;
    }

    //исчем цыфры
    public static String getCryptoMessage(String[] strArr) {
        Pattern pattern = Pattern.compile("\\d");//шаблон для поиска цыфр
        Matcher matcher;
        String str = "";
        String strCrypto = "";
        String c = null;
        Integer val;
        for (int i = 0; i < strArr.length; i++) {
            matcher = pattern.matcher(strArr[i]);//Создаем объект Matcher для работы со строкой           
            while (matcher.find()) {
                c = matcher.group();
                val = Integer.valueOf(c);
                c = getSimvolZakodirovat(val);
                str += c;
            }
            if (strArr[i].length() != str.length()) {
                str = strArr[i];
            }
            strCrypto = strCrypto + str + " ";
            str = "";
        }
        return strCrypto;
    }

    public static int getSimvolRazkodirovat(char a) {
        switch (a) {
            case 'Б' -> {
                return 1;
            }
            case 'Ф' -> {
                return 2;
            }
            case 'Р' -> {
                return 3;
            }
            case 'А' -> {
                return 4;
            }
            case 'П' -> {
                return 5;
            }
            case 'С' -> {
                return 6;
            }
            case 'Ж' -> {
                return 7;
            }
            case 'Н' -> {
                return 8;
            }
            case 'Е' -> {
                return 9;
            }
            case 'Х' -> {
                return 0;
            }
        }
        return 0;
    }

    public static String getSimvolZakodirovat(int a) {
        switch (a) {
            case 1 -> {
                return "Б";
            }
            case 2 -> {
                return "Ф";
            }
            case 3 -> {
                return "Р";
            }
            case 4 -> {
                return "А";
            }
            case 5 -> {
                return "П";
            }
            case 6 -> {
                return "С";
            }
            case 7 -> {
                return "Ж";
            }
            case 8 -> {
                return "Н";
            }
            case 9 -> {
                return "Е";
            }
            case 0 -> {
                return "Х";
            }
        }
        return "NULL";
    }
}
