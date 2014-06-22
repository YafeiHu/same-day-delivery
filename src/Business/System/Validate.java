/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.System;

/**
 *
 * @author hyf
 */
public class Validate {
     public boolean checkIfNullOrEmpty(String... input) {
        for (String s : input) {
            if (s == null || s.trim().isEmpty()) {
                return false;
            }

        }
        return true;
    }
}
