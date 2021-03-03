/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listenerskybit;

/**
 *
 * @author SISPC-0100
 */
public class toByteArray {
    public static byte[] hexStringToByteArray(String command) {
        int commandLength = command.length();
        byte[] byteArray = new byte[commandLength / 2];
        for (int i = 0; i < commandLength; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(command.charAt(i), 16) << 4) + Character.digit(command.charAt(i + 1), 16));
        }
        return byteArray;
    }
}
