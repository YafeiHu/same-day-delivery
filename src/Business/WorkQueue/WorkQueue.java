/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    public void add(RegisterRequest registerRequest){
        workRequestList.add(registerRequest);
    }
     public void add(ReturnRequest returnRequest){
        workRequestList.add(returnRequest);
    }
     public void add(ServiceRequest serviceRequest){
        workRequestList.add(serviceRequest);
    }
       public void add(ReturnAfterRequest serviceRequest) {
        workRequestList.add(serviceRequest);
    }

    public void add(ChangeRequest serviceRequest) {
        workRequestList.add(serviceRequest);
    }

    public void add(RepairRequest serviceRequest) {
        workRequestList.add(serviceRequest);
    }

    public void add(ReturnProductRequest serviceRequest) {
        workRequestList.add(serviceRequest);
    }

    public void add(ComplainRequest serviceRequest) {
        workRequestList.add(serviceRequest);
    }
}