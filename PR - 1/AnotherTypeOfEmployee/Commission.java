/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnotherTypeOfEmployee;

/**
 *
 * @author Ali Nurdin
 */
public class Commission extends Hourly {
    protected double total_sales;
    protected double commission_rate;
    
    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double cr){
        super(eName, eAddress, ePhone, socSecNumber, rate);
        commission_rate = cr;
    }
    public void addSales(double totalSales) {
        total_sales = totalSales;
    }
    @Override
    public double pay(){
        double p_payment = super.pay();
        return p_payment+(commission_rate*p_payment);
    }
}
