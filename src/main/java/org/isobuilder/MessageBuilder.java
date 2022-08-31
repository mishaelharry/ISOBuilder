package org.isobuilder;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageBuilder {

    public static void main( String[] args ) throws ISOException {
        GenericPackager packager = new GenericPackager("packager/iso87ascii.xml");

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);

        //MTI
        isoMsg.set(0, "0100");

        //Processing code
        isoMsg.set(3, "10000");

        //transaction amount
        isoMsg.set(4, "2000");

        //transmission date & time
        isoMsg.set(7, new SimpleDateFormat("MMddHHmmss").format(new Date()));

        //System trace audit number
        isoMsg.set(11, "123456");

        //Local transaction time
        isoMsg.set(12, new SimpleDateFormat("HHmmss").format(new Date()));

        //Effective date
        isoMsg.set(13, new SimpleDateFormat("MMdd").format(new Date()));

        byte[] bytesISoMsg = isoMsg.pack();
        String result = "";
        for (int i = 0; i < bytesISoMsg.length; i++){
            result += (char) bytesISoMsg[i];
        }
        System.out.println("ISO8385 Message = " +result);
    }

}
