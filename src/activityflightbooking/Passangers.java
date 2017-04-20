/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityflightbooking;

/**
 *
 * @author Befkadu Degefa
 */
public class Passangers
{
    private String name;
    private String address;
    private String telnr;

    
    public Passangers(String name, String address, String telnr)
    {
        this.name = name;
        this.address = address;
        this.telnr = telnr;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getTelnr()
    {
        return telnr;
    }

    @Override
    public String toString()
    {
        return "Passangers{" + "name=" + name + ", address=" + address + ", telnr=" + telnr + '}';
    }
    
}
