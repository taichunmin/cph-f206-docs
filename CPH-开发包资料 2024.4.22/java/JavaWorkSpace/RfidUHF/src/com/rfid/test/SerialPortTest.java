package com.rfid.test;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import com.rfid.AppNotifyImpl.MRfidReaderNotifyImpl;
import com.rfid.reader.MRfidReader;
import com.rfid.reader.RfidReader;
import com.rfid.transport.RfidReaderManager;

public class SerialPortTest {

	@Test
	public void test() throws Exception{
		System.out.println("Start Serial Port Test....");
		MRfidReaderNotifyImpl appNotify = new MRfidReaderNotifyImpl();
		RfidReaderManager.initilizeTransportManager(appNotify);
		//��COM2����,������115200
		RfidReader reader = RfidReaderManager.getInstance().CreateSerialPort("COM4",115200);
		System.out.println("the application start recveive data from reader.");
		//������豸�Զ�����������Ϊtrue,���๦�ܲ�����Ϊfalse
		boolean isInventoryTest = false;
		if (isInventoryTest){
			//�豸����,Ҳ��Ϊ��ʼ������
			reader.Inventory();
			while(true) {
				//���߳����ߣ�appNotify�ᱻRfidReaderManager���÷��ر�ǩ����
				Thread.sleep(3000);
			}
		}
		else {
			//�����¹��ܵ�ʱ����ò�Ҫ���豸����ǩ
			//reader.Stop();
			while(true) {
				Thread.sleep(3000);
				
				//ֹͣ�������ܲ���
				//reader.Stop();
				
				
				/*
				//д��ǩ����
				byte[] writtenData = new byte[4];
				for (int iIndex = 0;iIndex < 4;iIndex++) {
					writtenData[iIndex] = (byte)iIndex;
				}
				reader.WriteTagBlock((byte)GeneralReader.RFID_TAG_MEMBANK_USER, (byte)0, (byte)2, writtenData, 0);
				*/
				
				/*
				//��ȡ�û�������ʼ��ַΪ0������Ϊ2���ֵ�����
				//reader.ReadTagBlock((byte)GeneralReader.RFID_TAG_MEMBANK_USER, (byte)0, (byte)2);
				 * */
				
				//����EPC
				//reader.LockTag(GeneralReader.RFID_LOCK_EPC);
				
				//���ٱ�ǩ
				//reader.KillTag();
				
				//ͨ������������ķ�ʽ��Ѱһ�α�ǩ
				//reader.InventoryOnce();
			}
		}
	}

}
