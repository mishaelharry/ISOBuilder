package org.isobuilder;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class MessageUnPacker
{
    public static void main( String[] args ) throws ISOException {
        GenericPackager packager = new GenericPackager("packager/iso87ascii.xml");

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);

        String message = "0100323800000000000001000000000000200008310539221234560539220831";

        byte[] bIsoMsg = new byte[message.length()];
        for (int i = 0; i < bIsoMsg.length; i++){
            bIsoMsg[i] = (byte) (int) message.charAt(i);
        }

        isoMsg.unpack(bIsoMsg);

        for (int i = 0; i <= isoMsg.getMaxField(); i++){

            if (isoMsg.hasField(i)){
                System.out.println(i + "= " + isoMsg.getString(i));
            }
        }

    }
}
