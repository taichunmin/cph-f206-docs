package com.rfid.test;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import com.rfid.AppNotifyImpl.MRfidReaderNotifyImpl;
import com.rfid.reader.MRfidReader;
import com.rfid.reader.RfidReader;
import com.rfid.transport.RfidReaderManager;

class RfidUdpTest {
	@Test
	void test() throws Exception {
		System.out.println("this sample is for R2000 with UDP.");
		//���������д����Ӧ�Ĵ������
		MRfidReaderNotifyImpl appNotify = new MRfidReaderNotifyImpl();
		
		//��ʼ��rfid����ģ��
		RfidReaderManager.initilizeTransportManager(appNotify);
		
		//���÷��͵�Ŀ�ĵ�ַ�Ƕ�д����IP(192.168.1.65 12345)�͵�ַ,���ش򿪵�UDP�˿�Ϊ12345
		RfidReader reader = RfidReaderManager.getInstance().CreateUdpConnection("192.168.1.150", 9000, "127.0.0.1",12345);
		
		if (null != reader){
			System.out.println("connet to the reader is ok.");
		}
		else{
			return;
		}

		//������豸�Զ�����������Ϊtrue,���๦�ܲ�����Ϊfalse
		boolean isInventoryTest = true;
		if (isInventoryTest){
			//������Ѱ����ʹ�豸��ʼ��������ǩ��Reboot����Ҳ��ͬ���Ĺ���
			reader.Inventory();
			while(true) {
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
