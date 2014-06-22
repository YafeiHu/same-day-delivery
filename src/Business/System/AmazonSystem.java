/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.System;

import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class AmazonSystem extends Enterprise{

    private static AmazonSystem syetem;
    private ArrayList<Network> networklist=new ArrayList<>();;

    public AmazonSystem(String name) {
        super(name);
    }
   
public static AmazonSystem getInstance(){
    if (syetem == null){
    syetem = new AmazonSystem("");
    }
    return syetem;
    }

    public ArrayList<Network> getNetworklist() {
        return networklist;
    }

    public void setNetworklist(ArrayList<Network> networklist) {
        this.networklist = networklist;
    }

    
        public Network createNetwork() {
         Network network=new Network();
        networklist.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
