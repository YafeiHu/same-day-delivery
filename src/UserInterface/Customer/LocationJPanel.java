/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.WarehouseOrganization;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserCommandEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author hyf
 */
public class LocationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LocationJPanel
     */
    /* JPanel userProcessContainer;
     UserAccount user;
     Network network;
     AmazonSystem system;*/
    protected static final String LS = System.getProperty("line.separator");
    JPanel userProcessContainer;
    AmazonSystem system;
    Order order;
    String location;
    String originInMap;
    String origin;
    ArrayList<String> result;
    ArrayList<WarehouseOrganization> organizations;
    WarehouseOrganization supplier;
    OrderItem orderItem;
    UserAccount user;
    int count=1;
    public LocationJPanel(JPanel userProcessContainer, Order order, OrderItem orderItem, UserAccount user, AmazonSystem system) throws ParseException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.orderItem = orderItem;
        this.user = user;
        result = new ArrayList<>();
        supplier = new WarehouseOrganization();
        count++;
        // resultDurations=new ArrayList<>();
        final JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.setBarsVisible(false);
        webBrowser.setStatusBarVisible(true);
        webBrowser.setSize(800, 800);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        String day = df.format(new Date());
        Date endTime = sdf.parse(day + " 24:00");
        long interval = (endTime.getTime() - currentTime.getTime()) / 1000;//秒
        // /////  System.out.println(interval);
        ///////   System.out.println(endTime);
        //  location='"'+"var destinationC = new google.maps.LatLng(42.3011, -71.0869);"+'"'+'+'+'L'+'S'+'+';
        location = " var destinationsArray = [];" + LS
                + " var namesArray = [];" + LS
                + " var d=" + interval + ";" + LS;
        originInMap = " var origin='" + order.getShipment().getShippingAddress().getExactLocation() + "';" + LS;
        //    origin=order.getShipment().getShippingAddress().getCity();
        //////////       System.out.println(originInMap);
        // location="var destinationC = new google.maps.LatLng(42.3011, -71.0869);"+LS+"var destinationB = new google.maps.LatLng(42.3011, -71.0869);"+LS+"  var destinationA = new google.maps.LatLng(42.3011, -71.0879);";
        //   location='"'+"var destinationC = new google.maps.LatLng(42.3011, -71.0869);"+'"'+'+'+'L'+'S'+'+'+"var destinationB = new google.maps.LatLng(42.3011, -71.0869);"+LS+"  var destinationA = new google.maps.LatLng(42.3011, -71.0879);";
        //   for (OrderItem item : order.getOrder()) {
        Supplier s = orderItem.getProduct().getSupplier();
        System.out.println(s.getName() + "11111");
        organizations = s.getAllWarehouses(orderItem.getProduct().getProductId());
        for (WarehouseOrganization wa : organizations) {
            System.out.println(wa.getName() + "2222");
        }
        for (WarehouseOrganization w : organizations) {
            location = location + "var destination={ name:'" + w.getName() + "', l:" + w.getLocation().getExactLocation() + "};" + LS
                    + "destinationsArray.push(destination.l);" + LS
                    + "namesArray.push(destination.name);" + LS;
            System.out.println(w.getName() + "2222");
            //    }

            //     }
            //     if(i==network.getEnterpriseList().size()-1) {
            //        location=location+enterprise.getLocation().getExactLocation();
            //    }

        }
        /*  final  String script1="var destinationB ={ name:'B', l:new google.maps.LatLng(42.3011, -71.0869)};"+LS+ 
         // " var name1=destinationB"+LS+ 
         "  var destinationA = { name:'A', l:new google.maps.LatLng(42.3011, -71.2459)};"+LS+
         " var destinationsArray = [];"+LS+
         " var namesArray = [];"+LS+
         "destinationsArray.push(destinationA.l)"+LS+
         "destinationsArray.push(destinationB.l)"+LS+
         "namesArray.push(destinationA.name)"+LS+
         "namesArray.push(destinationB.name)";*/
        final String script1 = location;
        final String script2 = originInMap;
        //    location="var destinationC = new google.maps.LatLng(42.3011, -71.0869);"+LS+"var destinationB = new google.maps.LatLng(42.3011, -71.0869);"+LS+"  var destinationA = new google.maps.LatLng(42.3011, -71.0879);";
        /* final  String script1 ="var destinationC = new google.maps.LatLng(42.3011, -71.0869);"+LS+
         "var destinationB = new google.maps.LatLng(42.3011, -71.0869);"+LS+
         "  var destinationA = new google.maps.LatLng(42.3011, -71.0879);";*/
        final String htmlContent =
                "<!DOCTYPE html>" + LS
                + "<html>" + LS
                + "<head>" + LS
                + "  <title>Location</title>" + LS
                + "<script src=" + LS
                + "https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false" + LS
                + "></script>" + LS
                + "<style>" + LS
                + " html, body {" + LS
                + "    height: 100%;" + LS
                + "  margin: 0;" + LS
                + "   padding: 0;" + LS
                + "}" + LS
                + "  #map-canvas {" + LS
                + " height: 100%;" + LS
                + "   width: 80%;" + LS
                + "}" + LS
                + "#content-pane {" + LS
                + "  float:right;" + LS
                + "   width:48%;" + LS
                + "  padding-left: 2%;" + LS
                + "}" + LS
                + " #outputDiv {" + LS
                + "  font-size: 11px;" + LS
                + " }" + LS
                + "</style>" + LS
                + " <script>" + LS
                + " var map;" + LS
                + " var geocoder;" + LS
                + " var name;" + LS
                + " var bounds = new google.maps.LatLngBounds();" + LS
                + " var markersArray = [];" + LS
                + " var destinationIcon = 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=D|FF0000|000000';" + LS
                + " var originIcon = 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=O|FFFF00|000000';" + LS
                + "var testOrigin;" + LS
                + "var origin  ;" + LS
                + "function initialize() {" + LS
                + " var opts = {" + LS
                + "  center: new google.maps.LatLng(42.3011, -71.0869)," + LS
                + "  zoom: 10" + LS
                + "  };" + LS
                + " map = new google.maps.Map(document.getElementById('map-canvas'), opts);" + LS
                + "  geocoder = new google.maps.Geocoder();" + LS
                + " }" + LS
                + " function addMarker(location, isDestination,info) {" + LS
                + "  var icon;" + LS
                + " if (isDestination) {" + LS
                + "  icon = destinationIcon;" + LS
                + " } else {" + LS
                + "  icon = originIcon;" + LS
                + "  }" + LS
                + "  geocoder.geocode({ 'address': location }, function (results, status) {" + LS
                + "if (status == google.maps.GeocoderStatus.OK) {" + LS
                + "   bounds.extend(results[0].geometry.location);" + LS
                + " map.fitBounds(bounds);" + LS
                + " var marker = new google.maps.Marker({" + LS
                + "    map: map," + LS
                + " position: results[0].geometry.location," + LS
                + "  icon: icon" + LS
                + " });" + LS
                + " var infowindow = new google.maps.InfoWindow({" + LS
                + "  content:info" + LS
                + " });" + LS
                + "   google.maps.event.addListener(marker, 'mouseover', function(){" + LS
                + "  infowindow.open(map,marker);" + LS
                + "  });" + LS
                + "   google.maps.event.addListener(marker, 'click', function(){" + LS
                + // "  var name=infowindow.getContent();"+LS+
                ////////////  "name=infowindow.getContent();"+LS+
                /////////////   "sendNSCommand(name);"+LS+
                "  });" + LS
                + " markersArray.push(marker);" + LS
                + " } else {" + LS
                + "  alert('Geocode was not successful for the following reason: '" + LS
                + "  + status);" + LS
                + "   }" + LS
                + " });" + LS
                + "   }" + LS
                /*    + " function addPosition(isDestination) {" + LS
                 + " var address = document.getElementById('address').value;" + LS
                 + "  var icon;" + LS
                 + " if (isDestination) {" + LS
                 + "  icon = destinationIcon;" + LS
                 + " } else {" + LS
                 + "  icon = originIcon;" + LS
                 + "  }" + LS
                 + "  geocoder.geocode({ 'address': address }, function (results, status) {" + LS
                 + "if (status == google.maps.GeocoderStatus.OK) {" + LS
                 + "   bounds.extend(results[0].geometry.location);" + LS
                 + " map.fitBounds(bounds);" + LS
                 + " var marker = new google.maps.Marker({" + LS
                 + "    map: map," + LS
                 + " position: results[0].geometry.location," + LS
                 + "  icon: icon" + LS
                 + " });" + LS
                 + "addOrigin( results[0].geometry.location);" + LS
                 + " var infowindow = new google.maps.InfoWindow({" + LS
                 + "  content:'my position'" + LS
                 + " });" + LS
                 + " } else {" + LS
                 + "  alert('Geocode was not successful for the following reason: '" + LS
                 + "  + status);" + LS
                 + "   }" + LS
                 + " });" + LS
                 + "   }" + LS
                 + " function addOrigin(o) {" + LS
                 + "origin = o;" + LS
                 + "   }" + LS*/
                + "   function deleteOverlays() {" + LS
                + "   for (var i = 0; i < markersArray.length; i++) {" + LS
                + "   markersArray[i].setMap(null);" + LS
                + " }" + LS
                + "  markersArray = [];" + LS
                + " }"
                + LS
                + " google.maps.event.addDomListener(window, 'load', initialize);" + LS
                + "</script>" + LS
                + " </head>" + LS
                + "  <body>" + LS
                + " <div id=" + LS
                + "content-pane" + LS
                + ">" + LS
                + " <div id=" + LS
                + "inputs" + LS
                + ">" + LS
                + " <p><button type=" + LS
                + "button" + LS
                + "onclick=" + LS
                + " sendNSCommand('store');" + LS
                + "> start</button></p>" + LS
                /*      + " <p><input id=" + LS
                 + "address" + LS
                 + "type=" + LS
                 + "textbox" + LS
                 +"value="+ LS
                 +origin+ LS
                 +">My position</button></p>" + LS
                 + " <p><button type=" + LS
                 + "button" + LS
                 + "onclick=" + LS
                 + "addPosition(false);" + LS
                 + ">My position</button></p>" + LS*/
                + " <p><button type=" + LS
                + "button" + LS
                + "onclick=" + LS
                + "calculateDistances();" + LS
                + ">Calculate" + LS
                + " distances</button></p>" + LS
                + /*  " <p><button type="+LS+
                 "button" +LS+
                 "onclick="+LS+
                 "sendNSCommand(name);"+LS+
                 ">Choose</button></p>"+LS+
                 */ " </div>" + LS
                + " <div id=" + LS
                + "outputDiv" + LS
                + "></div>" + LS
                + " </div>" + LS
                + " <div id=" + LS
                + "map-canvas" + LS
                + "></div>" + LS
                + " </body>" + LS
                + "</html>";

        webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
            @Override
            public void commandReceived(WebBrowserCommandEvent e) {
                String command = e.getCommand();
                Object[] parameters = e.getParameters();
                //  "var a='\"+b+\"';"+LS+  
                //  " document.getElementById('a').value='"+b+"'"+LS+
                // String b="42.3011, -71.0869";

                String script =
                        " var resultsArray = [];" + LS
                        //   " var origin = document.getElementById('orign1').value;"+LS+
                        //   "  addOrigin();" + LS
                        + //  " var origin = new google.maps.LatLng(42.3011, -71.0879);"+LS+
                        " function calculateDistances() {" + LS
                        + " var service = new google.maps.DistanceMatrixService();" + LS
                        + "service.getDistanceMatrix(" + LS
                        + "{" + LS
                        + //  " origins: [origin1, origin2],"+LS+
                        // " destinations: [destinationA, destinationB,destinationC],"+LS+
                        " origins: [origin]," + LS
                        + " destinations: destinationsArray," + LS
                        + " travelMode: google.maps.TravelMode.DRIVING," + LS
                        + " unitSystem: google.maps.UnitSystem.METRIC," + LS
                        + " avoidHighways: false," + LS
                        + "  avoidTolls: false" + LS
                        + " }, callback);" + LS
                        + " }" + LS
                        + "function callback(response, status) {" + LS
                        + " if (status != google.maps.DistanceMatrixStatus.OK) {" + LS
                        + "  alert('Error was: ' + status);" + LS
                        + " } else {" + LS
                        + "   var origins = response.originAddresses;" + LS
                        + "   var destinations = response.destinationAddresses;" + LS
                        + "   var outputDiv = document.getElementById('outputDiv');" + LS
                        + "    outputDiv.innerHTML = '';" + LS
                        + "  deleteOverlays();" + LS
                        + "  for (var i = 0; i < origins.length; i++) {" + LS
                        + "  var results = response.rows[i].elements;" + LS
                        + "  addMarker(origins[i], false,'my position');" + LS
                        + "  for (var j = 0; j < results.length; j++) {" + LS
                        + "   addMarker(destinations[j], true,namesArray[j]);" + LS
                        + "    outputDiv.innerHTML += origins[i] + ' to ' + destinations[j]" + LS
                        + " + ': ' + results[j].distance.text + ' in '" + LS
                        + "   + results[j].duration.text + '<br>';" + LS
                        + " if(String(results[j].duration.value)<d){" + LS
                        + "sendNSCommand(namesArray[j]);" + LS
                        + "sendNSCommand(String(results[j].duration.value));" + LS
                        + " }" + LS
                        + "    }" + LS
                        + " }" + LS
                        + "  }" + LS
                        + " }";
                if ("store".equals(command)) {
                    e.getWebBrowser().executeJavascript(location);
                    e.getWebBrowser().executeJavascript(script2);
                    e.getWebBrowser().executeJavascript(script);
                } /*  else{
                 String storename=command + (parameters.length > 0? " " + Arrays.toString(parameters): "");
                 System.out.println("its"+storename);
                 }*/ else {
                    String rusult = command + (parameters.length > 0 ? " " + Arrays.toString(parameters) : "");
                    result.add(rusult);
                }
            }
        });
        webBrowser.setHTMLContent(htmlContent);
        add(webBrowser, BorderLayout.CENTER);
        //  Button b=new Button("back");
        //  LocationJPanel.add(webBrowser, BorderLayout.CENTER);
        //   contentPane.add(webBrowserPanel, BorderLayout.CENTER);
        //   contentPane.add(commandPanel, BorderLayout.SOUTH);

    }

    /* Standard main method to try that test as a standalone application. */
    public static void main(String[] args) {
        UIUtils.setPreferredLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //   JFrame frame = new JFrame("DJ Native Swing Test");
                //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //   frame.getContentPane().add(new LocationJPanel(), BorderLayout.CENTER);
                //   frame.setSize(800, 600);
                //   frame.setLocationByPlatform(true);
                //   frame.setVisible(true);
                //     LocationJPanel locationJPanel=new LocationJPanel(userProcessContainer,system);
            }
        });
        NativeInterface.runEventPump();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkoutJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        checkoutJButton.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton.setText("continue>>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        backjButton1.setBackground(new java.awt.Color(0, 153, 0));
        backjButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(497, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(checkoutJButton)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(446, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton)
                    .addComponent(backjButton1))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        String name;
        String store = null;
        System.out.println("4444" + result.size());
        for (int j = 0; j < result.size(); j++) {
            System.out.println("66666666666" + result.get(j));
        }
        if (result.size() == 0) {
            supplier = null;
        } else {
            if (result.size() == 2) {
                store = result.get(0);
            } else {
                for (int i = 1; i < result.size() - 2; i = i + 2) {
                    name = result.get(i);
                    if (Integer.parseInt(result.get(i + 2)) <= Integer.parseInt(result.get(i))) {
                        System.out.println(Integer.parseInt(result.get(i + 2)));
                        System.out.println(Integer.parseInt(result.get(i)));
                        name = result.get(i + 2);
                        System.out.println(name);
                        store = result.get(i + 1);
                        System.out.println(store);
                    } else {
                        name = result.get(i);
                        store = result.get(i-1);
                    }
                }
            }
            for (WarehouseOrganization w : organizations) {
                if (w.getName().equals(store)) {
                    supplier = w;
                }
            }
        }
//        System.out.println(supplier.getName() + "5555");
//        System.out.println(supplier.getLocation());
        CheckResultAfterJPanel cjp = new CheckResultAfterJPanel(userProcessContainer, order, orderItem, user, system, supplier, true,count);
        userProcessContainer.add("ViewProductDetailJPanel", cjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton checkoutJButton;
    // End of variables declaration//GEN-END:variables
}
